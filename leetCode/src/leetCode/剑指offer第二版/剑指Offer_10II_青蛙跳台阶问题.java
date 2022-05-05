package leetCode.剑指offer第二版;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 *
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * */
public class 剑指Offer_10II_青蛙跳台阶问题 {
    public static void main(String[] args) {
        int n = 44;
        System.out.println(numWays(n));
    }
    private static int numWays(int n) {
        int p = 0,q=0,r = 1;
        for (int i = 1; i <= n; i++) {
            p=q;
            q=r;
            r=p+q;
        }
        return r;
    }
}
