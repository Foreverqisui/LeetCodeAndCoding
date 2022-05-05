package com.pc.listen;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.exception.ExcelAnalysisStopException;
import com.pc.controller.TestSum;
import com.pc.entry.DemoData;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelListener extends AnalysisEventListener<DemoData> {
    /**
     * 进行读的操作具体执行方法，一行一行的读取数据
     * 从第二行开始读取，不读取表头
     *
     * @param userData
     * @param analysisContext
     */
    TestSum testSum = new TestSum();
    List<String[]> text = new ArrayList<String[]>();

    @Override
    public void invoke(DemoData userData, AnalysisContext analysisContext) {
        text.add(new String[]{userData.getString()});
    }

    /**
     * 读取表头信息
     *
     * @param headMap
     * @param context
     */
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        super.invokeHeadMap(headMap, context);
//        System.out.println("表头信息：" + headMap);
    }

    /**
     * 读取完数据的操作
     *
     * @param analysisContext
     */
    List<String> result = new ArrayList<String>();

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        int res = 0;
        for (int i = 0; i < text.size(); i++) {
            res = testSum.find(Arrays.toString(text.get(i)));
            System.out.println("第" + i + "行的情感词和为：" + res);
            result.add("第" + i + "行的情感词和为：" + res);
        }
        // 写法1
        // 指定写的路径
        String fileName = "D:\\" + 4 + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，
        // 名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, DemoData.class)
                .sheet("模板")
                .doWrite(get(result));
    }
    public List<DemoData> get(List<String> list){
        List<DemoData> res = new ArrayList<DemoData>();
        for (int i = 0; i < list.size(); i++) {
            DemoData data = new DemoData();
            data.setString(list.get(i));
            res.add(data);
        }
        return res;
    }
}


