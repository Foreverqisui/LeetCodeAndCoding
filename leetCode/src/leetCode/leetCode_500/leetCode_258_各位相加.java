package leetCode.leetCode_500;

/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num = 38
 * 输出: 2
 * 解释: 各位相加的过程为：
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * 由于 2 是一位数，所以返回 2。
 */
public class leetCode_258_各位相加 {

    public static void main(String[] args) {
        int num = 38;
        System.out.println(addDigits(num));
        System.out.println(addDigits1(num));
    }
    /**
    * 自己写的模拟
    * */
    private static int addDigits(int num) {
        while(num>=10){
            int a = num%10;
            int b = num/10;
            num = a+b;
        }
        return num;
    }
    /**
     * 官方写的模拟
     * */
    private static int addDigits1(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                System.out.println(sum);
                num /= 10;
                System.out.println(num);
            }
            num = sum;
        }
        return num;
    }

}
