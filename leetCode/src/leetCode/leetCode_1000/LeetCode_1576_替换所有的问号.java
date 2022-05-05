package leetCode.leetCode_1000;

import java.util.Arrays;

public class LeetCode_1576_替换所有的问号 {
    public static void main(String[] args) {
        String s = "??yw?ipkj?";
        System.out.println(modifyString(s));
    }


    private static String modifyString(String s) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '?') {
                for (char c = 'a'; c >= 'a' && c <= 'z'; c++) {
                    if (i > 0 && ch[i - 1] == c || i < ch.length - 1 && ch[i + 1] == c) {
                        continue;
                    }
                    ch[i] = c;
                    break;
                }
            }

        }
        return new String(ch);
    }
}