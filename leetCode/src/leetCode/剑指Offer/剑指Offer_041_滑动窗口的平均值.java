package leetCode.剑指Offer;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 实现 MovingAverage 类：
 * <p>
 * MovingAverage(int size) 用窗口大小 size 初始化对象。
 * double next(int val) 成员函数 next 每次调用的时候都会往滑动窗口增加一个整数，
 * 请计算并返回数据流中最后 size 个值的移动平均值，即滑动窗口里所有数字的平均值。
 * 输入：
 * inputs = ["MovingAverage", "next", "next", "next", "next"]
 * inputs = [[3], [1], [10], [3], [5]]
 * 输出：
 * [null, 1.0, 5.5, 4.66667, 6.0]
 * <p>
 * 解释：
 * MovingAverage movingAverage = new MovingAverage(3);
 * movingAverage.next(1); // 返回 1.0 = 1 / 12
 * movingAverage.next(10); // 返回 5.5 = (1 + 10) / 2
 * movingAverage.next(3); // 返回 4.66667 = (1 + 10 + 3) / 3
 * movingAverage.next(5); // 返回 6.0 = (10 + 3 + 5) / 3
 */
public class 剑指Offer_041_滑动窗口的平均值 {

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        movingAverage.next(1);
        movingAverage.next(10);
        movingAverage.next(3);
        System.out.println(movingAverage.next(5));
    }

    static class MovingAverage {

        //定义三个全局变量
        private final int length;
        private final Deque<Integer> queue;
        private double sum;

        //对定义的变量进行初始化
        public MovingAverage(int size) {
            length = size;
            queue = new LinkedList<Integer>();
            sum = 0;
        }

        public double next(int val) {
            //判断是否超过窗口长度
            if (queue.size() == length) {
                sum -= queue.remove();
            }
            //执行逻辑
            queue.add(val);
            sum += val;
            return sum / queue.size();
        }
    }
}
