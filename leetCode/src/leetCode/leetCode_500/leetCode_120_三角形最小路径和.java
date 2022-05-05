package leetCode.leetCode_500;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class leetCode_120_三角形最小路径和 {
    public static void main(String[] args) {
        List<List<Integer>> list = new LinkedList<>();
        list.add(0, Collections.singletonList(3));
        list.add(1, List.of(2, 3));
        list.add(2, List.of(5, 6, 7));
        System.out.println(minimumTotal(list));
    }

    private static int minimumTotal(List<List<Integer>> triangle) {
       int n=triangle.size();
       int []dp=new int[n+1];
        for (int i = n-1; i >=0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j]=Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
