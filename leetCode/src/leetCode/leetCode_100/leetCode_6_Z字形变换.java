package leetCode.leetCode_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * */

public class leetCode_6_Z字形变换 {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s,numRows));
    }
    /**
     * 二维矩阵模拟
     * */


    /**
     * 很灵巧的解法 字符串拼接
     * 主要利用flag判断是否到达三个
     * */
    private static String convert(String s, int numRows) {
        if (numRows<2){
            return s;
        }
        //做一个基础容器的创建
        List<StringBuffer> list = new ArrayList<StringBuffer>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuffer());
        }

        //核心思路 当numRows为3时
        //当i为0时 将flag变成1 开始移动
        //当i为2时 此时已经找完三个 需要把下一个拼接到第二个位置上 之后重置flag为-1
        //当i==3时，此时拼接到第二个位置上，继续将位置上移，让i回到0的位置
        //此时完成了一次numRows的字符串拼接循环
        int i = 0,flag = -1;
        for(char ch:s.toCharArray()){
            list.get(i).append(ch);
            if (i==0||i==numRows-1){
                flag = -flag;
            }
            i+=flag;
        }

        //结果打印
        StringBuffer res = new StringBuffer();
        for(StringBuffer c : list){
            res.append(c);
        }
        return res.toString();
    }
}
