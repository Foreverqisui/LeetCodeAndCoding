package leetCode.剑指Offer;

/**
 * 狒狒喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 *
 * 狒狒可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉，下一个小时才会开始吃另一堆的香蕉。
 *
 * 狒狒喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 *
 *
 *
 * 示例 1：
 *
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 * */
public class 剑指Offer_073_狒狒吃香蕉 {

    public static void main(String[] args) {
        int [] piles = {3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeed(piles,h));
    }
    private static int minEatingSpeed(int[] piles, int h) {
        //题目分析：本题要找狒狒在规定时间内吃完所有香蕉所花费的最小速度
        //可以通过最大速度和最小速度和中间值来找到合适的速度
        //二分求解

        /*
        * 1.首先设最小速度为1，遍历求解出最大速度
        * 2.求出速度中间值，用来计算市场
        * 3.不断调整速度左右区间找到合适的速度
        * */
        //求最大值
        int maxSpeed =0;
        for(int pile:piles){
            maxSpeed = Math.max(maxSpeed,pile);
        }
        //最小值
        int minSpeed =1;
        //二分
        while (minSpeed < maxSpeed){
            int mid = (minSpeed + maxSpeed)>>1;
            if (calculateTime(mid,piles)>h){
                //花费的时间多，需要移动区间
                minSpeed = mid+1;
            }else{
                maxSpeed = mid;
            }
        }
        return minSpeed;
    }

    private static int calculateTime(int speed, int[] piles) {
        int sum = 0;
        for(int pile:piles){
            //向上取整
            sum += (pile-1)/speed+1;
        }
        return sum;
    }

}
