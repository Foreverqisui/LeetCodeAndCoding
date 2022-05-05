package leetCode.剑指Offer;

public class 剑指Offer_001_整数除法 {
    public static void main(String[] args) {
        int a = 9;
        int b = -2;
        System.out.println(a / b);
        System.out.println(divide(a, b));
    }
    //时间复杂度O(1)--优化版

    private static int divide1(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        a = Math.abs(a);
        b = Math.abs(b);
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            // 首先，右移的话，再怎么着也不会越界
            // 其次，无符号右移的目的是：将 -2147483648 看成 2147483648

            // 注意，这里不能是 (a >>> i) >= b 而应该是 (a >>> i) - b >= 0
            // 这个也是为了避免 b = -2147483648，如果 b = -2147483648
            // 那么 (a >>> i) >= b 永远为 true，但是 (a >>> i) - b >= 0 为 false

            if ((a >>> i) - b >= 0) { // a >= (b << i)
                a -= (b << i);
                res += (1 << i);
            }
        }
        // bug 修复：因为不能使用乘号，所以将乘号换成三目运算符
        return sign == 1 ? res : -res;

    }

    //时间复杂度O（n）--简单易懂版

    private static int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        //判断两个符号是否相等
        int flat = (a > 0) ^ (b > 0) ? -1 : 1;
        //将两个数转为同样的符号--负数形式
        if (a > 0) {
            a = -a;
        }
        if (b > 0) {
            b = -b;
        }

        int res = 0;
        //减法求值
        while (a <= b) {
            a -= b;
            res++;
        }
        //正负判断 返回结果
        return flat == 1 ? res : -res;
    }

}
