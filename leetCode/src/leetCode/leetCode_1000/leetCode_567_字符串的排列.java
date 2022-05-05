package leetCode.leetCode_1000;

/**
 * 字符串的排列
 */
public class leetCode_567_字符串的排列 {
    public static void main(String[] args) {
        String str1 = "ab";
        String str2 = "eidbaooo";
        System.out.println(checkInclusion(str1, str2));
    }

    private static boolean checkInclusion(String str1, String str2) {
       int n=str1.length();int m=str2.length();
       if (n>m) return false;
       int nums[]=new int[26];
        for (int i = 0; i < n; i++) {
            int x=str1.charAt(i)-'a';
            --nums[x];
        }
        int left=0;
        for (int right = 0; right < m; right++) {
            int y=str2.charAt(right)-'a';
            ++nums[y];
            while(nums[y]>0){
                --nums[str2.charAt(left)-'a'];
                ++left;
            }
            if (right-left+1==n) return true;
        }
        return false;
    }
}
