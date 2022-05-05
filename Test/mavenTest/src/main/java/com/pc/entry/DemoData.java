package com.pc.entry;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author foreverqisui
 */
@Data
public class DemoData {
//    @ExcelProperty("字符串标题")
//    private String string;
//    @ExcelProperty("日期标题")
//    private Date date;
    @ExcelProperty("评价内容")
    private String  string;
    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private String ignore;
}
