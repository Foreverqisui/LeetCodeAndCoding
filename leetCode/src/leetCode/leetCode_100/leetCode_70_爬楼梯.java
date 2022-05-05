package leetCode.leetCode_100;

/**
 * 爬楼梯
 * 1.动态规划（两种方式）
 * 2.斐波那契
 * */
public class leetCode_70_爬楼梯 {
    public static void main(String[] args) {
        int a=10;
        System.out.println(climbStairs(a));
        System.out.println(climbStairs1(a));
        System.out.println(climbStairs2(a));
    }

    private static int climbStairs1(int a) {
        int [] arr=new int[a+1];
        arr[0]=1;
        arr[1]=1;
        for (int i = 2; i <= a; i++) {
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[a];
    }

    private static int climbStairs(int a) {
        int p=0;
        int q=0;
        int r=1;
        for (int i = 1; i <=a; i++) {
            p=q;
            q=r;
            r=p+q;
        }
        return r;
    }
//可知本题是斐波那契数列，那么用斐波那契数列的公式即可解决问题，公式如下：
//Fn=1/5[(1+52)n−(1−52)n]F_n = 1/\sqrt{5}\Big[\Big(\frac{1+\sqrt{5}}{2}\Big)^n-\Big(\frac{1-\sqrt{5}}{2}\Big)^n\Big] Fn​=1/5
//​[(21+5)n−(21−5​​)n]
//

    private static int climbStairs2(int n){
        double sqrt5 = Math.sqrt(5);
        // 描述 sqrt() 方法返回数字x的平方根
        double fibN = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2,n + 1);
        //Math.pow()方法用于返回第一个参数的第二个参数次方
        return (int)(fibN / sqrt5);
    }
}
