package leetCode.leetCode_500;

import java.util.Arrays;

public class leetCode_748_最短补全词 {
    public static void main(String[] args) {
        String licensePlate = "1s3 PSt";
        String[] words = {"step", "steps", "stripe", "stepple"};
        System.out.println(shortestCompletingWord(licensePlate, words));
    }

    private static String shortestCompletingWord(String licensePlate, String[] words) {
        int[] cnt = get(licensePlate);
        String ans = null;
        for (String s : words
        ) {
            int[] cur = get(s);
            boolean ok = true;
            for (int i = 0; i < 26 && ok; i++) {
                if (cnt[i] > cur[i]) ok = false;
            }
            if (ok && (ans == null || ans.length() > s.length())) ans = s;
        }
        return ans;
    }

    private static int[] get(String license) {
        int[] arr = new int[26];
        for (char c : license.toCharArray()
        ) {
            if (Character.isLetter(c)) arr[Character.toLowerCase(c) - 'a']++;
        }
        return arr;
    }
}
