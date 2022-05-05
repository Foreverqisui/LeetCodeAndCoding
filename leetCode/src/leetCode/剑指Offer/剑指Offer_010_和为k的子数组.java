package leetCode.剑指Offer;

import java.util.HashMap;
import java.util.Map;

public class 剑指Offer_010_和为k的子数组 {
    public static void main(String[] args) {
        int [] nums = {1,1};
        int k = -1;
        System.out.println(subarraySum(nums, k));
    }
    private static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int res = 0,preSum=0;
        map.put(0,1);
        for(int num:nums){
            preSum+=num;
            if (map.containsKey(preSum-k)){
                res+=map.get(preSum-k);
            }
           map.put(preSum,map.getOrDefault(preSum,0)+1);
    }
        return res;
}
}
