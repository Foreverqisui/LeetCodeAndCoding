package leetCode.双指针;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetCode_15_三数之和 {
    public static void main(String[] args) {
        int[] nums = {1,-1,-1,0};
        System.out.println(threeSum(nums));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        if (nums == null || len < 3) {
            return ans;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i>0&&nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i+1;
            int right = len - 1;
            while (left < right) {
                int sum=nums[i]+nums[left]+nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left<right&&nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left<right&&nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                }
            }

        }
        return ans;
    }
}
