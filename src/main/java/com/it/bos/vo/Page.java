package com.it.bos.vo;/**
 * Created by Think on 2018/5/9.
 */

/**
 * @ClassName Page
 * @Description easyUI页面传递page和rows参数封装
 * @Author Think
 * @Date 2018/5/9 15:53
 * @Version 1.0
 */
public class Page {
    //页面传递的当前页
    private String page = "1";
    //页面传递的每页显示的条数
    private String rows = "3";

    public Page() {
    }

    public Page(String page, String rows) {
        this.page = page;
        this.rows = rows;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }
}











