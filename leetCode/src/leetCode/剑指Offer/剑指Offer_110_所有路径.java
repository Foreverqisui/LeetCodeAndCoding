package leetCode.剑指Offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个有 n 个节点的有向无环图，用二维数组 graph 表示，请找到所有从 0 到 n-1 的路径并输出（不要求按顺序）。
 *
 * graph 的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些结点（
 * 译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a ），若为空，就是没有下一个节点了。
 *
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 * */
public class 剑指Offer_110_所有路径 {

    public static void main(String[] args) {
        int [][] graph = {{1,2},{3},{3},{}};
        Solution sol = new Solution();
        System.out.println(sol.allPathsSourceTarget(graph));
    }
    static class Solution {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Deque<Integer> temp = new LinkedList<Integer>();
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            temp.offerLast(0);
            dfs(graph, 0,graph.length-1);
            return res;
        }
        private void dfs(int [][] graph, int start, int end) {
            //递归终止条件
            if (start==end){
                res.add(new ArrayList<Integer>(temp));
                return;
            }
            for(int x :graph[start]){
                temp.offerLast(x);
                dfs(graph, x, end);
                temp.pollLast();
            }
        }
    }
}
