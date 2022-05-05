package leetCode.leetCode_100;

/**
 * 判断是否是回文数
 * */
public class leetCode_09_判断是否是回文数 {
    public static void main(String[] args) {
        System.out.println(palindrome(121));
    }
    public static boolean palindrome(int x){
        if (x<0){
            return false;
        }
        int res=0;
        int temp=x;
        while(temp!=0){
            int a=temp%10;
            temp/=10;
            res=res*10+a;
        }
        return res==x;
    }
}
