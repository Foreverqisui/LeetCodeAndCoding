package leetCode.leetCode_1000;

import java.util.ArrayList;
import java.util.List;

public class leetCode_1414_和为K的最少斐波那契数字数目 {
    public static void main(String[] args) {
        int k = 19;
        System.out.println(findMinFibonacciNumbers(k));
    }

    private static int findMinFibonacciNumbers(int k) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int a = 1, b = 1;
        while (a + b <= k) {
            int c = a + b;
            list.add(c);
            a = b;
            b = c;
        }
        int res = 0;
        for (int i = list.size() - 1; i >= 0 && k > 0; i--) {
            int num = list.get(i);
            if (k >= num) {
                k -= num;
                res++;
            }
        }
        return res;
    }

}