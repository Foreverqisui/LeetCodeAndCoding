package leetCode.数组;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leetCode_217_存在重复元素 {
    public static void main(String[] args) {
        int [] nums={1,2,3,4};
        System.out.println(containsDuplicate(nums));
        System.out.println(containsDuplicate1(nums));
    }

    private static boolean containsDuplicate1(int[] nums) {
        int n =nums.length;
        Arrays.sort(nums);
        for (int i = 0; i +1< n; i++) {
            if (nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    private static boolean containsDuplicate(int[] nums) {
        Set <Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++){
            if (!set.add(nums[i])){
                return true;
            }
        }
        return false;

    }
}
