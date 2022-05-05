package leetCode.剑指Offer;

import java.util.*;

/**
 * 给定一个整数数组 nums 和一个整数 k ，请返回其中出现频率前 k 高的元素。可以按 任意顺序 返回答案。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 */
public class 剑指Offer_060_出现频率最高的k个数字 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    private static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        //map计数--将nums中的值 设为key 记录 其中出现的频数为value
        for(int num :nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //优先队列 构建小顶堆
        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        //遍历哈希表，判断频数大小
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            //获取键值对
            int key = entry.getKey(),val = entry.getValue();
            if(queue.size()==k){
                //判断出现频数大小
                if(queue.peek()[1]<val){
                    //弹出小的
                    queue.poll();
                    //放入大的
                    queue.offer(new int[]{key,val});
                }
            }else{
                //不满足要求长度时 ，直接放入
                queue.offer(new int[]{key,val});
            }
        }
        //结果承接
        int[] res = new int[k];
        for(int i =0;i<k;i++){
            res[i]=queue.poll()[0];
        }
        return res;
    }
}
