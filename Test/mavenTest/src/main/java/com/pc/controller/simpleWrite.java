package com.pc.controller;

import com.alibaba.excel.EasyExcel;
import com.pc.entry.DemoData;
import com.pc.listen.ExcelListener;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class simpleWrite {

    ExcelListener es = new ExcelListener();
    @Test
    public  void read() {
        // 指定读的路径
        String fileName = "D:\\idea_project_javase_Test1\\Test\\mavenTest\\src\\main\\java\\com\\pc\\controller\\2.xlsx";
        //  调用读的方法
        EasyExcel.read(fileName, DemoData.class, new ExcelListener())
                .sheet().doRead();
    }

    @Test
    public void simpleWrites() {
        // 写法1
        // 指定写的路径
        String fileName = "D:\\" + 7 + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，
        // 名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, DemoData.class)
                .sheet("模板")
                .doWrite(data());
    }

    private List<DemoData> data() {
        List<DemoData> list = new ArrayList<DemoData>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            list.add(data);
        }
        return list;
    }
}
