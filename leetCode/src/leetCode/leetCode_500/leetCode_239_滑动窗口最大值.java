package leetCode.leetCode_500;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * */
public class leetCode_239_滑动窗口最大值 {
    public static void main(String[] args) {
        int [] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    /**
     * 单调队列
     * */
    private static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();

        //固定一个大小为k的窗口 而且是单调递减的
        //扔掉末尾小于头的元素
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        //初始化结果数组
        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];


        for (int i = k; i < n; ++i) {
            //固定一个大小为k的窗口 而且是单调递减的
            //扔掉末尾小于头的元素
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            //判断当前队首是否有效
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            //保存结果
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
