package leetCode.剑指offer第二版;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 */
public class 剑指Offer_13_机器人的运动范围 {
    public static void main(String[] args) {
        int m =38,n=15,k=9;
        Solution sol = new Solution();
        System.out.println(sol.movingCount(m,n,k));
    }

    static class Solution {
        //我们在搜索的过程中搜索方向可以缩减为向右和向下，而不必再向上和向左进行搜索。
        public int movingCount(int m, int n, int k) {
            //边界判断
            if (k == 0) {
                return 1;
            }
            //bfs遍历 -- 传统方式

            //1.向上下左右四个方向移动 -- 本题可以优化搜索 成右下
            int[] r = {1, 0}, b = {0, 1};
            //2.标记数组 -- 用来标记是否搜索过
            boolean[][] flag = new boolean[m][n];
            //3.队列模拟
            Queue<int[]> queue = new LinkedList<>();
            //3.1 将0.0位置赋给队列 -- 意味着从0.0开始遍历
            queue.offer(new int[]{0, 0});
            //3.2 将标记数组0.0位置 设为已搜索
            flag[0][0] = true;
            //结果值
            int res = 1;
            //4 循环遍历
            while (!queue.isEmpty()) {
                //4.1 从队列里拿出上一个位置 -- 即为旧位置
                int[] cell = queue.poll();
                //4.2 保存旧位置 -- x方向 和 y方向
                int oldPostionX = cell[0], oldPostionY = cell[1];
                //4.3 设立新位置 -- 此题可用优化成两个方向
                for (int i = 0; i < 2; i++) {
                    int newPostionX = oldPostionX + r[i];
                    int newPostionY = oldPostionY + b[i];
                    //4.4 边界筛选 -- 不能出去、不能被搜索过； 此题限制不能超过数位和大于kd
                    if (newPostionX >= m || newPostionX < 0 || newPostionY >= n || newPostionY < 0 ||
                            flag[newPostionX][newPostionY] || sum(newPostionX) + sum(newPostionY) > k) {
                        continue;
                    }
                    //4.5 符合条件的加入队列 向下走
                    queue.offer(new int[]{newPostionX, newPostionY});
                    flag[newPostionX][newPostionY] = true;
                    res++;
                }
            }
            return res;
        }

        /**
         * 那么如何计算一个数的数位之和呢？
         * 1.我们只需要对数 x 每次对 10 取余，
         * 2.就能知道数 x 的个位数是多少，然后再将 x 除 10，
         * 这个操作等价于将 x 的十进制数向右移一位，删除个位数（类似于二进制中的 >> 右移运算符），
         * 不断重复直到 x 为 0 时结束。
         */
        public int sum(int x) {
            int res = 0;
            while (x != 0) {
                res += x % 10;
                x /= 10;
            }
            return res;
        }
    }
}
