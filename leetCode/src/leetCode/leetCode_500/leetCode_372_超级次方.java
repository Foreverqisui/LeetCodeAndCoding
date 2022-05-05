package leetCode.leetCode_500;

public class leetCode_372_超级次方 {
    static final int MOD=1337;
    public static void main(String[] args) {
        int a=2;
        int []nums={2};
        System.out.println(superPow(a,nums));
    }

    private static int superPow(int a, int[] nums) {
       int ans=1;
        for (int e:nums
             ) {
           ans=(int)((long)pow(ans,10)*pow(a,e)%MOD);
        }
        return ans;
    }

    private static int pow(int a, int n) {
        int res=1;
        while(n!=0){
            if (n%2!=0){
                res=(int)((long) res*a%MOD);
            }
            a=(int)((long)a*a%MOD);
            n/=2;
        }
        return res;
    }
}
