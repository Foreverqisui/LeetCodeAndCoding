package leetCode.leetCode_1000;

import java.util.ArrayList;
import java.util.List;

/**
 * 自除数 是指可以被它包含的每一位数整除的数。
 * <p>
 * 例如，128 是一个 自除数 ，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * <p>
 * 自除数 不允许包含 0 。
 * <p>
 * 给定两个整数 left 和 right ，返回一个列表，列表的元素是范围 [left, right] 内所有的 自除数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：left = 1, right = 22
 * 输出：[1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 */
public class leetCode_728_自除数 {

    public static void main(String[] args) {
        int left = 11, right = 22;
        System.out.println(selfDividingNumbers(left, right));
    }

    private static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = left; i <= right; i++) {
            if (bol(i)) {
                res.add(i);
            }
        }
        return res;
    }

    private static boolean bol(int num) {
        int temp = num;
        while(temp>0){
            int dis = temp%10;
            if(dis ==0 || num%dis!=0){
                return false;
            }
            temp/=10;
        }
        return true;
    }
}
