package leetCode.剑指Offer;

import java.util.Arrays;

/**
 * 现在总共有 numCourses 门课需要选，记为 0 到 numCourses-1。
 *
 * 给定一个数组 prerequisites ，它的每一个元素 prerequisites[i] 表示两门课程之间的先修顺序。
 * 例如 prerequisites[i] = [ai, bi] 表示想要学习课程 ai ，需要先完成课程 bi 。
 *
 * 请根据给出的总课程数  numCourses 和表示先修顺序的 prerequisites 得出一个可行的修课序列。
 *
 * 可能会有多个正确的顺序，只要任意返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 *
 * 输入: numCourses = 2, prerequisites = [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * */
public class 剑指Offer_113_课程顺序 {

    public static void main(String[] args) {
        int numCourses = 2;
        int [][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.findOrder(numCourses, prerequisites)));
    }
    static class Solution {
        int [] res;
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            //我觉得可以dfs
            res = new int[numCourses];
            int m = prerequisites.length,n=prerequisites[0].length;
            return null;
        }
    }
}
