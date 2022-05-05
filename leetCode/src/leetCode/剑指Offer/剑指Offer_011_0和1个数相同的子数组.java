package leetCode.剑指Offer;

import java.util.HashMap;
import java.util.Map;

public class 剑指Offer_011_0和1个数相同的子数组 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0};
        System.out.println(findMaxLength(nums));
    }

    private static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int counter =0,res=0,n=nums.length,preIndex=0;
        //将0转化成-1
        map.put(counter,-1);
        for (int i = 0; i < n; i++) {
            if (nums[i]==1){
                counter++;
            }else if (nums[i]==0){
                counter--;
            }
            if (map.containsKey(counter)){
                //如果包含这个元素 就判断索引位置 用当前i减去 就是他的长度
                preIndex = map.get(counter);
                res = Math.max(i-preIndex,res);
            }else {
                map.put(counter,i);
            }
        }
        return res;
    }
}
