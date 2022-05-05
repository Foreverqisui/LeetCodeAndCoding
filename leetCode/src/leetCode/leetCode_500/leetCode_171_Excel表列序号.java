package leetCode.leetCode_500;

public class leetCode_171_Excel表列序号 {
    public static void main(String[] args) {
        String columnTitle = "ABCdE";
        System.out.println(titleToNumber(columnTitle));
    }
    private static int titleToNumber(String columnTitle) {
        char[] s = columnTitle.toCharArray();
        int ans = 0;
        for (int i = 0; i < s.length; i++) {
            ans = ans*26+(s[i]-'A'+1);
        }
        return ans;
    }
}
