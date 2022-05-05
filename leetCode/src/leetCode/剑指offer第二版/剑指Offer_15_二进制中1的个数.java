package leetCode.剑指offer第二版;


public class 剑指Offer_15_二进制中1的个数 {
    public static void main(String[] args) {
        int n = 11;
        System.out.println(hammingWeight(n));
    }

    private static int hammingWeight(int n) {
        int ret = 0;
        while(n!=0){
            n&=n-1;
            ret++;
        }
        return ret;
    }
}
