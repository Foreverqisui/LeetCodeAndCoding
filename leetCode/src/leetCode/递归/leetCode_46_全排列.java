package leetCode.递归;

import java.util.ArrayList;
import java.util.List;

public class leetCode_46_全排列 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backTrack(result, new ArrayList<Integer>(), nums);
        return result;
    }

    private static void backTrack(List<List<Integer>> result, List<Integer> list, int[] nums) {
        if (nums.length == list.size()) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (list.contains(nums[i])) {
                    continue;
                }
                list.add(nums[i]);
                backTrack(result, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}
