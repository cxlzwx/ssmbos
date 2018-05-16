package com.it.bos.vo;/**
 * Created by Think on 2018/5/10.
 */

import com.it.bos.pojo.BcRegion;
import com.it.bos.utils.PinYin4jUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ExcelUtil
 * @Description TODO
 * @Author Think
 * @Date 2018/5/10 15:10
 * @Version 1.0
 */
public class ExcelUtil {
    public static List<BcRegion> getListRegion(MultipartFile regionFile){
        InputStream in =null;
        //得到excel
        List<BcRegion> bcRegions = null;
        String filename=regionFile.getOriginalFilename();
        Workbook wb = null;
        try {
            in = regionFile.getInputStream();
            String fileType = filename.substring(filename.lastIndexOf("."));
            if(".xls".equals(fileType)){
                wb = new HSSFWorkbook(in);  //2003-
            }else if((".xlsx").equals(fileType)){
                wb = new XSSFWorkbook(in);  //2007+
            }else{
                throw new IOException("未知错误");
            }
            bcRegions = new ArrayList<>();
            //得到sheet
            Sheet sheet = wb.getSheetAt(0); //默认取第一个sheet
            //int colsNum = sheet.getPhysicalNumberOfRows();  //获取实际的行数
            // getLastRowNum，获取最后一行的行标
            int rowsNum = sheet.getLastRowNum();
            //第一行为表头，所以从第二行开始
            for(int j=1; j<rowsNum+1;j++) {
                Row row =sheet.getRow(j);
                if (row != null){
                    String id = row.getCell(0).toString();
                    String province = row.getCell(1).toString();
                    String city = row.getCell(2).toString();
                    String district = row.getCell(3).toString();
                    String postcode = row.getCell(4).toString();
                    BcRegion region=new BcRegion(id,province,city,district,postcode,null,null);
                    //使用pinyin4j完成区域简码和城市简码生成
                    province = province.substring(0, province.length() - 1);
                    city = city.substring(0, city.length() - 1);
                    district = district.substring(0, district.length() - 1);
                    String info = province + city + district;
                    String[] strings = PinYin4jUtils.getHeadByString(info);
                    String shortcode = "";
                    for (String string : strings){
                        shortcode = string;
                    }
                    region.setShortcode(shortcode);
                    String citycode = PinYin4jUtils.hanziToPinyin(city,"");
                    region.setCitycode(citycode);
                    bcRegions.add(region);
                        /*for (int k = 0; k < row.getLastCellNum(); k++)
                        {// getLastCellNum，是获取最后一个不为空的列是第几个
                            System.out.print(row.getCell(k) + "\t");
                        }*/
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                wb.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bcRegions;
    }

}
