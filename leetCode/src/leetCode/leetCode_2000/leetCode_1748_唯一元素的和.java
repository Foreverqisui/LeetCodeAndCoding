package leetCode.leetCode_2000;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetCode_1748_唯一元素的和 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2};
        System.out.println(sumOfUnique(nums));
    }

    private static int sumOfUnique1(int[] nums){
        int [] temp = new int [101];
        int res = 0;
        for(int i = 0; i < nums.length;i++){
            int temp1 = temp[nums[i]];
            if (temp1==0){
                res+=nums[i];
                temp[nums[i]]=1;
            }else if(temp1==1){
                res-=nums[i];
                temp[nums[i]]=2;
            }
        }
        return res;
    }



    private static int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                res += num;
                map.put(num, 1);
            } else if (map.get(num) == 1) {
                res -= num;
                map.put(num, 2);
            }
        }
        return res;
    }
}
