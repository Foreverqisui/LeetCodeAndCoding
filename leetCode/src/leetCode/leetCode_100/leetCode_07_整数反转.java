package leetCode.leetCode_100;

/**
 * 整数反转
 * */
public class leetCode_07_整数反转 {
    public static void main(String[] args) {
        int x=98745;
        System.out.println(reserve(x));
    }
    public static int reserve(int x){
        int res=0;
        if (res<Integer.MIN_VALUE||res>Integer.MAX_VALUE){
            return 0;
        }
        while(x!=0){
           int a=x%10;
           x/=10;
           res=res*10+a;
        }
        return res;
    }
}
