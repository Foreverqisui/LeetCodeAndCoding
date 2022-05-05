package leetCode.leetCode_500;

import java.util.HashMap;
import java.util.Map;

public class leetCode_540_有序数组中的单一元素 {
    public static void main(String[] args) {
        int[] nums ={1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(nums));
        System.out.println(singleNonDuplicate1(nums));
    }
    /**
     * 示例 1:
     *
     * 输入: nums = [1,1,2,3,3,4,4,8,8]
     * 输出: 2
     * */

    private static int singleNonDuplicate1(int[] nums) {
        int len = nums.length,l=0,r=len-1;
        while(l<r){
            int mid = l+r>>1;
            if (nums[mid]==nums[mid^1]){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return nums[r];
    }


    private static int singleNonDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) ==1){
                res = nums[i];
            }
        }
        return res;
    }
}
