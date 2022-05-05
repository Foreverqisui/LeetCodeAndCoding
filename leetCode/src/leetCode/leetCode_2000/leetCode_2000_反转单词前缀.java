package leetCode.leetCode_2000;

public class leetCode_2000_反转单词前缀 {
    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';
        System.out.println(reversePrefix(word, ch));
    }

    private static String reversePrefix(String word, char ch) {
        int len = word.length();
        int index = word.indexOf(ch);
        if (index >= 0) {
            int left = 0, right = index;
            char[] c = word.toCharArray();
            while (left < right) {
                char temp = c[left];
                c[left] = c[right];
                c[right] = temp;
                left++;
                right--;
            }
            word = new String(c);
        }
        return word;
    }
}
