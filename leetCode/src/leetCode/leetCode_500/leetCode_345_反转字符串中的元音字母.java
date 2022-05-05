package leetCode.leetCode_500;


public class leetCode_345_反转字符串中的元音字母 {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(reverseVowels(s));
    }

    private static String reverseVowels(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            while (left < right && !isV(chars[left])) {
                left++;
            }
            while (right > 0 && !isV(chars[right])) {
                right--;
            }
            if (left < right) {
                swap(chars, left, right);
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    private static boolean isV(char chars) {
        return "aeiouAEIOU".indexOf(chars) >= 0;
    }

    private static void swap(char[] chars, int left, int right) {

        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;

    }
}
