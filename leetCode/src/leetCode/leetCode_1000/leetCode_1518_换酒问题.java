package leetCode.leetCode_1000;

public class leetCode_1518_换酒问题 {
    public static void main(String[] args) {
        int numBottles = 17;
        int numExchange = 3;
        System.out.println(numWaterBottles(numBottles, numExchange));
    }

    private static int numWaterBottles(int numBottles, int numExchange) {
        /**
         * 首先我们有numBottles瓶酒
         * 之后每numExchange个空瓶子可以换一瓶酒
         * 求一共可以喝到几瓶酒
         * 思路：
         *
         * */
        int extra = numBottles;
        int all=numBottles;
        while (all>= numExchange) {
           all-=numExchange;
            extra++;
            all++;
        }
        return extra;
    }
}
