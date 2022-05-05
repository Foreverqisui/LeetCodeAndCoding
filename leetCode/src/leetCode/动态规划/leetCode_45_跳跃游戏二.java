package leetCode.动态规划;

/**
 * 跳跃游戏二
 * 贪心
 * */
public class leetCode_45_跳跃游戏二 {
    public static void main(String[] args) {
        int []nums={3,10,3,1,1,0};
        System.out.println(jump(nums));
    }


    /**
     * step：总步数，每次到达上一次走的最远距离时，则加1
     * maxPosition：每个元素可以到达的最远位置
     * end：上一步的结束位置
     * */
    private static int jump(int[] nums) {
        int maxPosition=0;
        int num=nums.length;
        int step=0;
        int end=0;
        for (int i = 0; i < num-1; i++) {
            //判断上一个值的移动距离的最大值
            maxPosition=Math.max(maxPosition,i+nums[i]);
            //如果移动到了上一个值的end 证明要开始下一个元素的跳跃 步数+1
            if (i==end){
                end=maxPosition;
                step++;
            }
        }
        return step;
    }
}
