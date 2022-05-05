package leetCode.动态规划;

/**
 * 打家劫舍2
 */
public class leetCode_213_打家劫舍2 {
    public static void main(String[] args) {
        int nums[] = {1,3,7,9,8};
        System.out.println(rob(nums));
    }

    private static int rob(int[] nums) {
        int length = nums.length;
        if (length == 0){
            return 0;
        }else if (length==1){
            return nums[0];
        }else if (length==2){
            return Math.max(nums[0],nums[1]);
        }
        return Math.max(robRange(nums,0,length-2),robRange(nums,1,length-1));
    }

    private static int robRange(int[] nums, int start, int end) {
        int first=nums[start];int second=Math.max(nums[start],nums[start+1]);
        for (int i=start+2;i<=end;i++){
            int temp=second;
            second=Math.max(first+nums[i],second);
            first=temp;
        }
        return second;
    }
}
