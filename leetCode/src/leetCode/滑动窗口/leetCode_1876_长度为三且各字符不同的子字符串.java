package leetCode.滑动窗口;

public class leetCode_1876_长度为三且各字符不同的子字符串 {
    public static void main(String[] args) {
        String s = "aababcabc";
        System.out.println(countGoodSubstrings(s));
    }
    private static int countGoodSubstrings(String s) {
        char []ch = s.toCharArray();
        int cnt = 0;
        for (int i = 0; i < s.length()-2; i++) {
            if(ch[i]!=ch[i+1]&&ch[i]!=ch[i+2]&&ch[i+1]!=ch[i+2]){
                cnt++;
            }
        }
        return cnt;
    }
}
