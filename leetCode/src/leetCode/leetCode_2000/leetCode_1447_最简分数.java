package leetCode.leetCode_2000;

import java.util.ArrayList;
import java.util.List;

public class leetCode_1447_最简分数 {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(simplifiedFractions(n));
    }

    /**
     * 输入：n = 4
     * 输出：["1/2","1/3","1/4","2/3","3/4"]
     * 解释："2/4" 不是最简分数，因为它可以化简为 "1/2" 。
     */
    private static List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (gcd(i, j) == 1) {
                    ans.add(i + "/" + j);
                }
            }
        }
        return ans;
    }

    public static int gcd(int a, int b) {
        // 欧几里得算法
        return b == 0 ? a : gcd(b, a % b);


    }
}
