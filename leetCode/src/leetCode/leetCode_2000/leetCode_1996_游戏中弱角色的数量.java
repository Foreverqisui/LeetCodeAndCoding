package leetCode.leetCode_2000;

import java.util.Arrays;

public class leetCode_1996_游戏中弱角色的数量 {
    public static void main(String[] args) {
        int[][]properties={{6,2},{6,4},{5,5}};
        System.out.println(numberOfWeakCharacters(properties));
    }
    private static int numberOfWeakCharacters(int[][] properties) {
        System.out.println(Arrays.deepToString(properties));
        int maxDef = 0;
        int ans = 0;
        for (int[] p : properties) {
            if (p[1] < maxDef) {
                ans++;
            } else {
                maxDef = p[1];
            }
        }
        return ans;
    }
}
