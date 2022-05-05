package leetCode.剑指Offer;

import java.util.Arrays;

public class 剑指Offer_003_前n个数字二进制中1的个数 {
    public static void main(String[] args) {
        int n =11;
        //结果为[0,1,1,2,1,2]
        System.out.println(Arrays.toString(countBits(n)));
    }
    private static int[] countBits(int n) {
        //思路：dp[i] = dp[i/2] + i % 2
        int [] res = new int[n+1];
        for (int i = 0; i <= n; i++) {
            res[i]=res[i>>1]+(i&1);
        }
        return res;
    }
}
