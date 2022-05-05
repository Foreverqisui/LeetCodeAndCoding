package leetCode.剑指Offer;

import java.util.HashSet;
import java.util.Set;

public class 剑指Offer_019_最多删除一个字符得到回文 {
    public static void main(String[] args) {
        String s = "abca";
        System.out.println(validPalindrome(s));
    }

    private static boolean validPalindrome(String s) {
        int left =0,right=s.length()-1;
        while (left < right){
            char l = s.charAt(left);
            char r = s.charAt(right);
            if (l==r){
                left++;
                right--;
            }else{
                return check(s,left+1,right)||check(s,left,right-1);
            }
        }
        return true;
    }

    private static boolean check(String s, int left, int right) {
        while (left < right){
            char l = s.charAt(left);
            char r = s.charAt(right);
            if (l==r){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}
