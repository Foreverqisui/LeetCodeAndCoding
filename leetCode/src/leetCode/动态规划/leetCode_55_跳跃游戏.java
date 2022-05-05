package leetCode.动态规划;

/**
 * 跳跃游戏
 * */
public class leetCode_55_跳跃游戏 {
    public static void main(String[] args) {
        int []nums={3,2,1,0,4};
        System.out.println(canJump(nums));
    }

    private static boolean canJump(int[] nums) {
        //定义变量length作为数组长度 定义变量temp作为中间变量
        int length=nums.length;
        int temp=0;
        for (int i = 0; i < length; ++i) {
        //如果i>temp证明跳跃的数到不了末尾
            if (i<=temp){
            temp=Math.max(temp,i+nums[i]);
            if (temp>length-1){
                return true;
            }
        }

    }
        return false;
}}
