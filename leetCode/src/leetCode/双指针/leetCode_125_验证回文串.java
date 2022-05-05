package leetCode.双指针;

public class leetCode_125_验证回文串 {
    public static void main(String[] args) {
        String s="race a car";
        System.out.println(isPalindrome(s));
    }

    private static boolean isPalindrome(String s) {
        int left=0;
        int right=s.length()-1;
        while(left<right){
            //Character.isLetterOrDigit确定指定字符是一个字母或者数字
            while (left<right&&!Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while (left<right&&!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
           if (left<right){
                if (Character.toLowerCase(s.charAt(right)) != Character.toLowerCase(s.charAt(left))){
                    return false;
                }
                left++;
                right--;
           }
        }
        return true;
    }
}
