package leetCode.剑指offer第二版;

import java.util.PriorityQueue;

public class 剑指Offer_41_数据流中的中位数 {
    public static void main(String[] args) {

    }


    class MedianFinder {

        PriorityQueue<Integer> bigHeap;
        PriorityQueue<Integer> smallHeap;

        public MedianFinder() {
            //大顶堆
            bigHeap = new PriorityQueue<>((a, b) -> b - a);
            //小顶堆
            smallHeap = new PriorityQueue<>((a, b) -> a - b);
        }

        //偶数插入之后会变奇数，要保证奇数时，前半部分比后半部分多一个
        public void addNum(int num) {
            int bs = bigHeap.size(), ss = smallHeap.size();
            //判断是奇数还是偶数

            /*
             * 插入前两者大小相同，说明插入前数据流元素个数为偶数，插入后变为奇数。
             * 我们期望操作完达到「l 的数量为 r 多一，同时双堆维持有序」，进一步分情况讨论：
             */
            //如果是偶数的话 要让前面比后面多一个
            if (bs == ss) {
                //判断小根堆是否为空，或者小根堆的值小于插入的值
                if (smallHeap.isEmpty() || num <= smallHeap.peek()) {
                    //说明是首个插入的 或者 是出现在前半部分的
                    bigHeap.add(num);
                } else {
                    //说明是在后半部分的 就把r中元素那出来给前半部分
                    bigHeap.add(smallHeap.poll());
                    smallHeap.add(num);
                }

                /*
                 * 插入前两者大小不同，说明前数据流元素个数为奇数，插入后变为偶数。
                 * 我们期望操作完达到「l 和 r 数量相等，同时双堆维持有序」，
                 * 进一步分情况讨论（此时 l 必然比 r 元素多一）：
                 */

            } else {
                //奇数的话
                //前半部分一定比后半部分多一个
                if (bigHeap.peek() <= num) {
                    //num比大根堆里最大的数大，所以加在后面
                    smallHeap.add(num);
                } else {
                    smallHeap.add(bigHeap.poll());
                    bigHeap.add(num);
                }
            }
        }

        //奇数的时候：中位数是中间值
        //偶数的时候：中位数是大小根堆值相加/2
        public double findMedian() {
            int bs = bigHeap.size(), ss = smallHeap.size();
            //偶数
            if (bs == ss) {
                return (smallHeap.peek() + bigHeap.peek()) / 2.0;
            } else {
                //奇数
                return bigHeap.peek();
            }
        }
    }

}
