package leetCode.leetCode_100;

/**
 * 最大子序和
 * 动态规划
 */
public class leetCode_53_最大子序和 {
    public static void main(String[] args) {
        int[] sum = {1, 2};
        System.out.println(maxSubArray(sum));

    }

    private static int maxSubArray(int[] sum) {
     int ans=sum[0];
     int sums=0;
        for (int num:sum
             ) {
            if (sums>0){
                sums+=num;
            }else {
                sums=num;
            }
            ans=Math.max(ans,sums);
        }
        return ans;
    }
}
