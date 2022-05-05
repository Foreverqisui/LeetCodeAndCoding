package leetCode.leetCode_1000;

public class leetCode_1816_截断句子 {
    public static void main(String[] args) {
        int k = 5;
        String s = "chopper is not a tanuki";
        System.out.println(truncateSentence(s, k));
    }

    private static String truncateSentence(String s, int k) {
        int temp = 0;
        int end = 0;
        for (int i = 1; i <= s.length(); i++) {
            if (i==s.length()||s.charAt(i)==32) {
                temp++;
            }
            if (temp == k) {
                end = i;
                break;
            }
        }
        return s.substring(0, end);
    }
}
