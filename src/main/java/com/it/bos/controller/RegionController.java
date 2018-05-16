package com.it.bos.controller;/**
 * Created by Think on 2018/5/8.
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.bos.pojo.BcRegion;
import com.it.bos.vo.ExcelUtil;
import com.it.bos.vo.Page;
import com.it.bos.service.RegionService;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @ClassName RegionAll
 * @Description 区域设置controller
 * @Author Think
 * @Date 2018/5/8 23:54
 * @Version 1.0
 */
@Controller
public class RegionController {
       @Autowired
       private RegionService regionService;

       /**  
        * 
        * @Description 区域查询方法
        * @date 2018/5/9 18:28  
        * @param [page]  
        * @return java.util.Map<java.lang.String,java.lang.Object>  
        */
        @RequestMapping(value = "/json/regionAll")
        @ResponseBody
         public Map<String, Object> findAllRegion(Page page){
            PageHelper.startPage(Integer.valueOf(page.getPage()),Integer.valueOf(page.getRows()));
            List<BcRegion> regions =  regionService.findAllRegion();
            PageInfo<BcRegion> pageInfo = new PageInfo<>(regions);
            int total = regionService.findCount();
            Map<String , Object> map = new HashMap<>();
            map.put("total",total);
            map.put("rows",pageInfo.getList());
            return map;
        }
        /**  
         * 
         * @Description 区域Excel导入功能实现
         * @date 2018/5/9 18:28  
         * @param []  
         * @return void  
         */
        @RequestMapping("/regionImportXls")
         public String regionImportXlsAdd(MultipartFile regionFile) throws MaxUploadSizeExceededException {
            if(regionFile.isEmpty()){
                  return "error";
            }
            //使用工具类完成Excel文件的解析
            List<BcRegion> listRegion = ExcelUtil.getListRegion(regionFile);
            //TODO 这里未完成对Excel文件的保存数据库操作


            return "redirect:json/regionAll";
        }

        @RequestMapping("/json/standard")
        @ResponseBody
        public List<BcRegion> findAll(){
            List<BcRegion> bcRegions = regionService.findAllRegion();
            return bcRegions;
        }


}
