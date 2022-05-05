package leetCode.leetCode_500;

public class leetCode_521_最长特殊序列 {
    public static void main(String[] args) {
        String a="abc";
        String b="ddd";
        System.out.println(findLUSlength(a,b));
    }

    private static int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(),b.length());
    }
}
