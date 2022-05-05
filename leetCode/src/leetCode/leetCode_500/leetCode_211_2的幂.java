package leetCode.leetCode_500;

public class leetCode_211_2的幂 {
    public static void main(String[] args) {
        int n=3;
        System.out.println(isPowerOfTwo(n));
    }

    private static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
