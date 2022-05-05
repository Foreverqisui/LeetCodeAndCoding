package leetCode.leetCode_1000;

import java.util.Arrays;

public class leetCode_997_找到小镇的法官 {
    public static void main(String[] args) {
        int n = 4;
        int[][] trust = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        System.out.println(findJudge(n, trust));
    }

    private static int findJudge(int n, int[][] trust) {
        int[] ints = new int[n + 1];
        int[] outs = new int[n + 1];
        for (int[] c : trust
        ) {
            int in = c[0];
            int out = c[1];
            /*in是相信我的的
              out是我相信的*/
            ints[out]++;
            outs[in]++;
        }
            /*总共n个人
            信任法官的是n-1个人 所以ints[i]==n-1
            法官不信任任何人 所以outs[i]==0时 是法官*/
        for (int i = 1; i <= n; i++) {
            if (ints[i]==n-1&&outs[i]==0){
                return i;
            }
        }
        return -1;
    }
}
