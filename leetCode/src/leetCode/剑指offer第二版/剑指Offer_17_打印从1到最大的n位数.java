package leetCode.剑指offer第二版;

import java.util.Arrays;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 */
public class 剑指Offer_17_打印从1到最大的n位数 {
    public static void main(String[] args) {
        int n = 1;

    }

    static class Solution {
        //初始化操作
        int[] res;
        int nine = 0, count = 0, start, n;
        char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        public int[] printNumbers(int n) {
            this.n = n;
            //求得平方长度，初始化数组大小
            res = new int[(int) Math.pow(10, n) - 1];
            num = new char[n];
            //判断头包含0的个数
            start = n - 1;
            //进行dfs
            dfs(0);
            return res;
        }

        void dfs(int x) {
            //到末尾处
            if (x == n) {
                //将值转换成字符串
                String s = String.valueOf(num).substring(start);
                //判断是否为0
                if (!s.equals("0")) {
                    //转化成int
                    res[count++] = Integer.parseInt(s);
                }
                //判断0的个数是否多了 01 001 0001 多了就减去
                if (n - start == nine) {
                    start--;
                }
                return;
            }
            //循环固定元素位置
            for (char i : loop) {
                //末尾时，9的个数++
                if (i == '9') {
                    nine++;
                }

                num[x] = i;
                //固定下一个位置
                dfs(x + 1);
            }
            //恢复9的个数
            nine--;
        }
    }
}
