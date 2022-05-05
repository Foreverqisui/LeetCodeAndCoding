package leetCode.排序;

import java.util.Arrays;

public class leetCode_455_分发饼干 {
    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        System.out.println(findContentChildren(g, s));
    }

    /**
     * 贪心算法
     * 贪婪：先喂饱吃的最少的孩子
     * */
    private static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; i++, j++) {
            while (j < s.length && g[i] > s[j]) {
                //如果孩子大于cookie就不断加cookie的值
                j++;
            }
            if (j < s.length) {
                //如果j在数组长度内，则孩子+1
                count++;
            }
        }
        return count;
    }

    /**
     * 贪心简化版
     * 贪婪：先喂饱吃的最少的孩子
     * */
    public int findContentChildren1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        for(int cookie = 0;child<g.length&&cookie<s.length;cookie++){
            if(s[cookie]>=g[child]) {
                //如果蛋糕满足了第一个孩子的胃口就加一个孩子
                child++;
            }
        }
        return child;
    }
}