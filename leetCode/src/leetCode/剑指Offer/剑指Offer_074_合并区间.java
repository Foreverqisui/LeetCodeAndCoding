package leetCode.剑指Offer;

import java.util.*;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class 剑指Offer_074_合并区间 {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    private static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        //构建比较器函数，以规定的方式进行排序--按区间左端点排序
        Arrays.sort(intervals, Comparator.comparingInt(intervals2 -> intervals2[0]));
        //初始化一个结果数组 用来存储符合要求的数组
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            //存储当前数组内的左边值 和 右边值
            int l = interval[0], r = interval[1];
            //无交集的部分
            //当第一个数组进入 和 进入数组的左边值大于右边值的时候 就创建个新数组
            if (res.size() == 0 || res.get(res.size() - 1)[1] < l) {
                res.add(new int[]{l, r});
            } else {
                //有交集的部分
                //否则就选择新数组右边和旧数组右边值的大小 选取最大值作为并集 将旧数组的右边进行替换
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], r);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
