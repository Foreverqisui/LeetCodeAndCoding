package leetCode.递归;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetCode_90_子集II {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }
    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backTrack(result,new ArrayList<>(),nums,0);
        return result;
    }

    private static void  backTrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            //删除重复项
            if (i>start&&nums[i]==nums[i-1]){continue;}
            tempList.add(nums[i]);
            backTrack(result,tempList,nums,i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}
