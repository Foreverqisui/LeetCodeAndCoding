package leetCode.leetCode_500;

/**
 * 丑数
 */
public class leetCode_264_丑数 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(nthUglyNumber(n));
    }

    private static int nthUglyNumber(int n) {
        int []dp=new int[n+1];
        dp[1]=1;
        int p2=1,p3=1,p5=1;
        for (int i = 2; i <=n; i++) {
            int nums=dp[p2]*2,nums1=dp[p3]*3,nums2=dp[p5]*5;
            dp[i]=Math.min(Math.min(nums,nums1),nums2);
            if (dp[i]==nums) p2++;
            if (dp[i]==nums1) p3++;
            if (dp[i]==nums2) p5++;
        }
        return dp[n];
    }
}
