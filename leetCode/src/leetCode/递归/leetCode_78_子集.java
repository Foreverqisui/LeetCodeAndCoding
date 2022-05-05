package leetCode.递归;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetCode_78_子集 {
    public static void main(String[] args) {
        int []nums = {1,2,3};
        System.out.println(subsets(nums));
    }


    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backTrack(list,new ArrayList<>(),nums,0);
        return list;
    }

    private static void backTrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backTrack(list,tempList,nums,i+1);
            tempList.remove(tempList.size()-1);
        }
    }
    /*      [[]]
            [[], [1]]
            [[], [1], [1, 2]]
            [[], [1], [1, 2], [1, 2, 3]]
            [1, 2, 3]
            [1, 2]
            [1, 2]
            [1]
            [[], [1], [1, 2], [1, 2, 3], [1, 3]]
            [1, 3]
            [1]
            [1]
            []
            [[], [1], [1, 2], [1, 2, 3], [1, 3], [2]]
            [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3]]
            [2, 3]
            [2]
            [2]
            []
            [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
            [3]
            []
            [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
*/

}
