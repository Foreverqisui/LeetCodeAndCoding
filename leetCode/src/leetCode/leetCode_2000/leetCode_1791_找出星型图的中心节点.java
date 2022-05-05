package leetCode.leetCode_2000;


import java.util.HashMap;
import java.util.Map;

/**
 * 输入：edges = [[1,2],[5,1],[1,3],[1,4]]
 * 输出：1
 * */
public class leetCode_1791_找出星型图的中心节点 {
    public static void main(String[] args) {
        int [][]edges = {{1,2},{2,3},{4,2}};
        System.out.println(findCenter(edges));
    }
    private static int findCenter(int[][] edges) {
        int m = edges.length,n=edges[0].length;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                if (map.containsKey(edges[i][j])) {
                    res = edges[i][j];
                }
                map.put(edges[i][j],edges[i][j]);
            }
        }
        return res;
    }
}
