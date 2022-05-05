package leetCode.剑指Offer;

import java.util.*;

public class 剑指Offer_035_最小时间差 {
    public static void main(String[] args) {
        List<String> timePoints = Arrays.asList("23:59", "00:00");
        System.out.println(findMinDifference(timePoints));
    }

    /**
     * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
     * 示例 1：
     * <p>
     * 输入：timePoints = ["23:59","00:00"]
     * 输出：1
     */
    private static int findMinDifference(List<String> timePoints) {
        //鸽巢原理
        if (timePoints.size() > 1440) {
            return 0;
        }
        //进行排序
        Collections.sort(timePoints);
        int res = Integer.MAX_VALUE;
        //首时间
        int t0minutes = getMinutes(timePoints.get(0));
        int preTime = t0minutes;
        for (int i = 1; i < timePoints.size(); i++) {
            int minutes = getMinutes(timePoints.get(i));
            //相邻的时间差
            res = Math.min(res, minutes - preTime);
            preTime = minutes;
        }
        //首尾的时间差
        res = Math.min(res, t0minutes + 1440 - preTime);
        return res;
    }

    private static int getMinutes(String t) {
        return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60 + (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0');
    }
}
