package leetCode.leetCode_1000;

/**
 * 第n个泰波那契数
 * */
public class leetCode_1137_第n个泰波那契数 {
    public static void main(String[] args) {
        int a=5;
        System.out.println(tribonacci(a));
    }

    private static int tribonacci(int n) {
        if (n==0) return 0;
        if (n==1||n==2) return 1;
        int a=0,b = 1,c=1;
        for (int i=3;i<n;i++){
           int d=a+b+c;
            a=b;
            b=c;
            c=d;
        }
        return c;
    }
}
