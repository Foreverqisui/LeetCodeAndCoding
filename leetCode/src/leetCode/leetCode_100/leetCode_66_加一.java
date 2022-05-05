package leetCode.leetCode_100;

/**
 * 加一
 * 找出最长的后缀 9
 * 如果为9 创造一个长度+1的数组用来承载新的数据
 */
public class leetCode_66_加一 {
    public static void main(String[] args) {
        int[] sum = {9,9};
        for (int data : plusOne(sum)
        ) {
            System.out.print(data);
        }

    }

    private static int[] plusOne(int[] sum) {
        for (int i = sum.length - 1; i >= 0; i--) {
            sum[i]++;
            sum[i] %= 10;
            if (sum[i] != 0) {
                return sum;
            }
        }
        sum = new int[sum.length + 1];
        sum[0] = 1;
        return sum;
    }
}
