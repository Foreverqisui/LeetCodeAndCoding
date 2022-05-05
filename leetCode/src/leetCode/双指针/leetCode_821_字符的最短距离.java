package leetCode.双指针;

import java.util.Arrays;

import static java.lang.Integer.MIN_VALUE;

public class leetCode_821_字符的最短距离 {
    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';
        System.out.println(Arrays.toString(shortestToChar(s, c)));
    }

    private static int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] nums = new int[n];
        int prev = MIN_VALUE / 2;
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == C) {
                prev = i;
            }

            nums[i] = i - prev;
        }
        prev = Integer.MAX_VALUE / 2;
        for (int j = n - 1; j >= 0; j--) {

            if (S.charAt(j) == C) {
                prev = j;
            }
            nums[j] = Math.min(nums[j], prev - j);
        }
        return nums;
    }
}
