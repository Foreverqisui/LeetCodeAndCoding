package leetCode.剑指Offer;

/**
 *
 * 给定一个非负整数 x ，计算并返回 x 的平方根，即实现 int sqrt(int x) 函数。
 *
 * 正数的平方根有两个，只输出其中的正数平方根。
 *
 * 如果平方根不是整数，输出只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: x = 4
 * 输出: 2
 * */
public class 剑指Offer_072_求平方根 {

    public static void main(String[] args) {
        int x = 1;
        System.out.println(mySqrt(x));
    }
    private static int mySqrt(int x) {
        int left = 0,right = x,res = -1;
        while (left <= right){
            int mid = (left + right) >> 1;
            if ((long)mid * mid <= x){
                res = mid;
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return res;
    }




}
