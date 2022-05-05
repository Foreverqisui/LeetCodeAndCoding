package leetCode.程序员金典;

public class 面试题01_03_URL化 {
    public static void main(String[] args) {
        String S = "Mr John Smith    ";
        int length = 13;
        System.out.println(replaceSpaces(S,length));
    }
    public static String replaceSpaces(String S, int length) {
        //先把字符串转化为字符数组
        char[] chars = S.toCharArray();
        int index = chars.length - 1;
        for (int i = length - 1; i >= 0; i--) {
            //如果遇到空格就把他转化为"%20"
            if (chars[i] == ' ') {
                chars[index--] = '0';
                chars[index--] = '2';
                chars[index--] = '%';
            } else {
                chars[index--] = chars[i];
            }
        }
        return new String(chars, index + 1, chars.length - index - 1);
    }
}
