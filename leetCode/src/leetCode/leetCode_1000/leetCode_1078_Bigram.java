package leetCode.leetCode_1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetCode_1078_Bigram {
    public static void main(String[] args) {
        String text = "alice is a good girl she is a good student";
        String first = "a";
        String second = "good";
        System.out.println(Arrays.toString(findOcurrences(text, first, second)));

    }

    private static String []findOcurrences(String text, String first, String second) {
        String[] s1=text.split(" ");
        int n=s1.length;
        List<String> l=new ArrayList<>();
        for (int i = 0; i+2 < n; i++) {
            if (s1[i].equals(first) && s1[i + 1].equals(second)) {
                l.add(s1[i+2]);
            }
        }
        return l.toArray(new String[l.size()]);
    }
}
