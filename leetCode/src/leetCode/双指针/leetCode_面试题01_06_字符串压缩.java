package leetCode.双指针;

public class leetCode_面试题01_06_字符串压缩 {
    public static void main(String[] args) {
        String S="aabcccccaaa";
        System.out.println(compressString(S));
    }

    private static String compressString(String s) {
        int n=s.length();
        if (n==0) return s;
        StringBuilder sb=new StringBuilder();
        int cnt = 1;
        char chars = s.charAt(0);
        for (int i = 1; i < n; i++) {
            if (chars==s.charAt(i)){
                cnt++;
            }else {
                sb.append(chars);
                sb.append(cnt);
                chars=s.charAt(i);
                cnt=1;
            }
        }
        sb.append(chars);
        sb.append(cnt);
        return sb.length()>=s.length()?s:sb.toString();
    }
}
