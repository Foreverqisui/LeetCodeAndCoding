package leetCode.剑指Offer;

import java.util.*;

/**
 * 给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 *
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 *
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 *     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * */
public class 剑指Offer_061_和最小的k个数对 {

    public static void main(String[] args) {
        int [] nums1 = {1,7,11},nums2 = {2,4,6};
        int k = 3;
        System.out.println(kSmallestPairs(nums1,nums2,k));
    }
    private static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //构建优先队列 进行比较
        PriorityQueue<int []> heap = new PriorityQueue<>(
                (i,j)->nums1[i[0]]+nums2[i[1]]-(nums1[j[0]]+nums2[j[1]]));

        //
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
          heap.offer(new int[]{i,0});
        }

        //构建结果变量
        List<List<Integer>> res =new ArrayList<List<Integer>>();

        while(k-- >0&& !heap.isEmpty()){
            int [] pos = heap.poll();
            res.add(Arrays.asList(nums1[pos[0]], nums2[pos[1]]));

            // 将 index2 加 1 之后继续入队
            if (++pos[1] < nums2.length) {
                heap.offer(pos);
            }
        }
        return res;
    }
}
