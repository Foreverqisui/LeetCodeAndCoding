package leetCode.剑指Offer;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 请实现 KthLargest 类：
 *
 *     KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 *     int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 * 示例：
 *
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 *
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8

 * */
public class 剑指Offer_059_数据流的第K大数值 {
    /**利用优先队列的特性求值*/
    class KthLargest {
        PriorityQueue<Integer> pq;
        int k;
        public KthLargest(int k, int[] nums) {
            this.k=k;
            pq = new PriorityQueue<Integer>();
            //将数组中的元素加入优先队列当中，按照从小到大的方式进行排序
            //因为要第k大的数 所以只留到k的队列长度
            for (int i = 0; i < nums.length; i++) {
                add(nums[i]);
            }
        }
        //具体实现
        public int add(int val) {
            pq.offer(val);
            while(pq.size()>k){
                pq.poll();
            }
            return pq.peek();
        }
    }
}
