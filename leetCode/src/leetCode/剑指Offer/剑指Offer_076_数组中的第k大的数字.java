package leetCode.剑指Offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * */
public class 剑指Offer_076_数组中的第k大的数字 {

    public static void main(String[] args) {
        int [] nums = {3,2,1,5,6,4};
        int k =2;
        System.out.println(findKthLargest(nums,k));
    }
    private static int findKthLargest(int[] nums, int k) {
        //构建优先队列
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, Comparator.comparingInt(a->a));

        //放入前k个元素
        for(int i = 0; i <k; i++){
            queue.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i]>queue.peek()){
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.poll();
    }
}
