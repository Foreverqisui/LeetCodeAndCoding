package leetCode.leetCode_100;

/**
 * 快速幂
 */
public class leetCode_50_Pow {
    public static void main(String[] args) {
        double x = 2;
        int n = -2;
        System.out.println(myPow(x, n));
    }

    private static double myPow(double x, int n) {
            long N=n;
            return N>=0? quick(x,N):1.0/quick(x,-N);
    }

    /**
     * 分治
     * */
    private static double quick(double x, long N) {
        double contribute = x;
        double ans = 1.0;
        while(N>0){
            if (N%2==1){
                ans*=contribute;
            }
            contribute*=contribute;
            N/=2;
        }
        return ans;
    }
}
