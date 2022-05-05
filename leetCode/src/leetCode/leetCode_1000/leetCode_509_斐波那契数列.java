package leetCode.leetCode_1000;



/**
 * 斐波那契数列
 * 动态规划
 * */
public class leetCode_509_斐波那契数列 {
    public static void main(String[] args) {
        int n=4;
        System.out.println(fib(n));
    }

    private static int fib(int n) {
        if (n<=2){
            return n;
        }
        int a=0;int b=0;int c=1;
        for (int i = 2; i <= n; i++) {
                b=a;
                a=c;
                c=a+b;
        }
        return c;
    }
}
