package com.pc.controller;

import java.util.*;

/**
 * @author foreverqisui
 */
public class TestSum {
//    public static void main(String[] args) {
//        String text = "这个手机非常丑";
//        int res = find(text);
//        System.out.println(res);
//    }

    public  int find(String text) {
        //目标词
        String[] target = {"很", "非常", "不", "都", "特别", "比较"};
        String[] n = {"快", "神秘", "高", "大", "好", "不错", "一般", "慢"};
        //映射key
        int taLen = target.length;
        int nLen = n.length;
        //借助哈希表
        Map<String, Integer> taMap = new HashMap<String, Integer>();
        Map<String, Integer> nMap = new HashMap<String, Integer>();

        //和形容词目标值建立映射
        for (String s : target) {
            if ("很".equals(s)) {
                taMap.put(s, 1);
            }
            if ("非常".equals(s)) {
                taMap.put(s, 2);
            }
            if ("不".equals(s)) {
                taMap.put(s, 3);
            }
            if ("都".equals(s)) {
                taMap.put(s, 4);
            }
            if ("特别".equals(s)) {
                taMap.put(s, 5);
            }
            if ("比较".equals(s)) {
                taMap.put(s, 6);
            }

        }
        //和名词目标值建立映射
        for (String s : n) {
            if ("快".equals(s)) {
                nMap.put(s, 1);
            }
            if ("神秘".equals(s)) {
                nMap.put(s, 2);
            }
            if ("高".equals(s)) {
                nMap.put(s, 3);
            }
            if ("大".equals(s)) {
                nMap.put(s, 4);
            }
            if ("好".equals(s)) {
                nMap.put(s, 5);
            }
            if ("不错".equals(s)) {
                nMap.put(s, 6);
            }
            if ("一般".equals(s)) {
                nMap.put(s, -1);
            }
            if ("慢".equals(s)) {
                nMap.put(s, -2);
            }
        }
        //借助set做文字提取
        Set<Character> set = new HashSet<Character>();

        for (int i = 0; i < text.length(); i++) {
            set.add(text.charAt(i));
        }
        int res = 0, taNum = 0, nNum = 0;
        //分别遍历 寻找映射
        for (String value : target) {
            if (value.length() == 1) {
                if (set.contains(value.charAt(0))) {
                    taNum = taMap.get(value);
                    break;
                }
                continue;
            }
            //中间变量
            if (set.contains(value.charAt(0))) {
                taNum = taMap.get(value);
                break;
            }
        }
        for (String s : n) {
            if (s.length() == 1) {
                if (set.contains(s.charAt(0))) {
                    nNum = nMap.get(s);
                    break;
                }
                continue;
            }
            if (set.contains(s.charAt(0))) {
                nNum = nMap.get(s);
                break;
            }
        }
        //返回结果 0为没寻找到
        res = taNum * nNum;
        return res;
    }
}
