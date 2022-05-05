package leetCode.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetCode_986_区间列表的交集 {
    public static void main(String[] args) {
        int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}},
                secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        System.out.println(Arrays.deepToString(intervalIntersection(firstList, secondList)));
    }

    /**
     * 双指针
     * 已经从小到大排序过，整个二维数组有序
     * */
    private static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intervals = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            //i行0列比j行0列谁大，i行1列比j行1列谁小，
            int lo = Math.max(firstList[i][0], secondList[j][0]);
            int hi = Math.min(firstList[i][1], secondList[j][1]);
            if (lo <= hi) {
                intervals.add(new int[]{lo, hi});
            }
            if (firstList[i][1]<secondList[j][1]){
                i++;
            }else {
                j++;
            }
        }
        return intervals.toArray(new int[intervals.size()][]);
    }
}
