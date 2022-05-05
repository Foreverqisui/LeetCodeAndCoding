package leetCode.递归;

import java.util.ArrayList;
import java.util.List;

public class leetCode_784_字母大小写全排列 {
    public static void main(String[] args) {
        String s = "a1b2";
        System.out.println(letterCasePermutation(s));
    }

    private static List<String> letterCasePermutation(String S) {
        List<StringBuffer> list = new ArrayList<>();
        list.add(new StringBuffer());

        for (char c : S.toCharArray()
        ) {
            int n = list.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; i++) {
                    list.add(new StringBuffer(list.get(i)));
                    list.get(i).append(Character.toLowerCase(c));
                    list.get(i + n).append(Character.toUpperCase(c));
                }
            } else {
                for (int i = 0; i < n; i++) {
                    list.get(i).append(c);
                }
            }
        }
        List<String> finalnes = new ArrayList<>();
        for (StringBuffer sb : list
        ) {
            finalnes.add(sb.toString());
        }
        return finalnes;
    }
}
