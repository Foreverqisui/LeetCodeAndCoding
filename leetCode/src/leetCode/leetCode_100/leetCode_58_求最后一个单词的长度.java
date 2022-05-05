package leetCode.leetCode_100;

/**
 * 求最后一个单词的长度
 */
public class leetCode_58_求最后一个单词的长度 {
    public static void main(String[] args) {
        String s = "a";
        System.out.println(lengthOfLastWord(s));
    }

    private static int lengthOfLastWord(String s) {
        int num = s.length() - 1;
        while (s.charAt(num) == ' ') {
            num--;
        }
        int length = 0;
        while (num>=0 && s.charAt(num) != ' ') {
            length++;
            num--;
        }
        return length;
    }
}
