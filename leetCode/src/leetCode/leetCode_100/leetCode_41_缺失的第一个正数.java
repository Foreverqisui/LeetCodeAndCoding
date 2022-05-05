package leetCode.leetCode_100;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,0]
 * 输出：3
 * */
public class leetCode_41_缺失的第一个正数 {
    public static void main(String[] args) {
        int [] nums = {1,2,0,-1,-3};
        System.out.println(firstMissingPositive(nums));
    }
    /**
     * 用数组替换哈希表
     *
     * 负号占位，正数归位
     * 人啊，要找到适合自己的位置
     * 负数就应该变得大到远离喧嚣
     * 正数就要找到自己适合的位置，给自己对应的位置变的暗淡无光
     * 正确答案就是一枝红杏，站在负数群中，熠熠生辉。
     * */
    private static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        //把负数做标记 变成n+1的正数
        for(int i =0;i<n;i++){
            if(nums[i]<=0){
                nums[i] = n+1;
            }
        }
        //把每个数值对应的位置都填上负号
        for(int i =0;i<n;i++){
            int num = Math.abs(nums[i]);
            //曾经是负号的不用判断
            if(num<n+1){
                //将位置-1的位置填上负号
                nums[num-1] = -Math.abs(nums[num-1]);
            }
        }
        //找到第一个不为负数的位置
        for(int i =0;i<n;i++){
            if(nums[i]>0){
                return i+1;
            }
        }
        return n+1;
    }
}
