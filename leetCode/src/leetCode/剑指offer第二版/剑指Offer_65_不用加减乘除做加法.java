package leetCode.剑指offer第二版;

public class 剑指Offer_65_不用加减乘除做加法 {
    public static void main(String[] args) {
        System.out.println(add(1, 2));
    }

    private static int add(int a, int b) {
        // 当进位为 0 时跳出
        while (b != 0) {
            // c = 进位
            int c = (a & b) << 1;
            // a = 非进位和
            a ^= b;
            // b = 进位
            b = c;
        }
        return a;
    }
}
