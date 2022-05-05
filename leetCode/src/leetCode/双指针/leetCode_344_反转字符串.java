package leetCode.双指针;

import java.util.Arrays;

/**
 * 反转字符串
 * */
public class leetCode_344_反转字符串 {
    public static void main(String[] args) {
        char[]chars=new char[3];
        chars[0]='h';
        chars[1]='e';
        chars[2]='l';
        reverseString(chars);
    }

    private static void reverseString(char[] chars) {
        int left=0;
        int right=chars.length-1;
        while(left<right){
            char temp=chars[left];
            chars[left]=chars[right];
            chars[right]= temp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(chars));
    }
}
