package leetCode.剑指offer第二版;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 */
public class 剑指Offer_57II_和为s的连续正数序列 {
    public static void main(String[] args) {
        int target = 9;
        System.out.println(Arrays.toString(findContinuousSequence(target)));
    }

    private static int[][] findContinuousSequence(int target) {
        //结果变量
        List<int[]> res = new ArrayList<>();
        //本题可知，可以从1 、 2作为左右边界，3作为初始元素和
        int l = 1, r = 2, sum = 3;
        while (l < r) {
            //当满足要求是
            if (sum == target) {
                //创建对应长度的数组
                int[] ans = new int[r - l + 1];
                for (int i = l; i <= r; i++) {
                    //下标值 对应着i-l
                    ans[i - l] = i;
                }
                //放入结果中
                res.add(ans);
            }
            //此时证明数组内值 大于目标值 需要减去左窗口
            if (sum > target) {
                //和减去左窗口的值
                sum -= l;
                //移动窗口位置
                l++;
            } else {
                //此时证明数组内值 小于目标值 需要移动右窗口
                r++;
                sum += r;
            }
        }
        return res.toArray(new int[0][]);
    }
}
