package leetCode.leetCode_100;

/**
 * Sqrt(x):给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 第一种解法：利用二分法
 * 第二种解法：利用牛顿迭代法
 * */
public class leetCode_69_Sqrt {
    public static void main(String[] args) {
        int a=8;
        System.out.println(mySqrt(a));
        System.out.println(mysqrt1(a));

    }

    /**
     * 二分
     * */
    private static int mySqrt(int a) {
        int l=0;
        int r=a;
        int ans=-1;
        while(l<=r){
            int mid=l+(r-1)/2;
            if ((long)mid*mid<=a){
                ans=mid;
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        return ans;
    }

    /**
     * 数学
     * */
    private static int mysqrt1(int x) {
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;

    }

}
