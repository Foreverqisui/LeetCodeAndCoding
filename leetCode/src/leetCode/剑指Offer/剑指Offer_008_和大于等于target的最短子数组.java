package leetCode.剑指Offer;

public class 剑指Offer_008_和大于等于target的最短子数组 {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(target, nums));
    }

    private static int minSubArrayLen(int target, int[] nums) {
        int left =0;
        int minSize = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length;i++){
            sum+=nums[i];
            while (sum>=target){
                minSize = Math.min(minSize,i-left+1);
                sum-=nums[left++];
            }
        }
        return Integer.MAX_VALUE==minSize?0:minSize;
    }

}
