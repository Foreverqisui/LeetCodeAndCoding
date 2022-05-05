package leetCode.leetCode_100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 求两数之和，并以数组的方式返回
 * */

public class leetCode_01_求两数之和 {
    public static void main(String[] args)  {
        int []nums={1,5,7,9,5,8,4};
        System.out.println(Arrays.toString(twoSum(nums, 5)));

    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
        /**
            get方法就是将target-nums[i]的key赋给i
            Returns the value to which the specified key is mapped,
            or null if this map contains no mapping for the key.
         */
                return new int[]{hashtable.get(target - nums[i]), i};
            }

        /**
             put方法 就是把i的值赋给nums[i]
             Associates the specified value with the specified key in this map.
             If the map previously contained a mapping for the key,
             the old value is replaced.
         */
            hashtable.put(nums[i], i);
        }
        return new int[0];

    }
    public static int [] twoSum2(int[]nums,int target){
        /**
         * 定义一个长度为2的辅助数组，进行循环遍历
         * */
        int n =nums.length;
        int [] num =new int[2];
        for(int i = 0 ;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]+nums[j]==target){
                    num[0]=i;
                    num[1]=j;
                }
            }
        }
        return num;

    }
}
