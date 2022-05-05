package leetCode.leetCode_1000;


/**
 * 给你一个字符串 s ，根据下述规则反转字符串：
 * <p>
 * 所有非英文字母保留在原有位置。
 * 所有英文字母（小写或大写）位置反转。
 * <p>
 * 返回反转后的 s 。
 * 输入：s = "Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 */
public class leetCode_917_仅仅反转字母 {

    public static void main(String[] args) {
        String s = "Qedo1ct-eeLg=ntse-T!";
        System.out.println(reverseOnlyLetters(s));
    }

    private static String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length-1;
        while (left < right) {
            if (!Character.isLetter(chars[left])) {
                left++;
            } else if (!Character.isLetter(chars[right])) {
                right--;
            } else  {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}
