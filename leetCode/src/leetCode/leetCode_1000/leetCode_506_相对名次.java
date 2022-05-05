package leetCode.leetCode_1000;

/* 1. 不需要参数,返回值为 5
       () -> 5
         2. 接收一个参数(数字类型),返回其2倍的值
       x -> 2 * x
         3. 接受2个参数(数字),并返回他们的差值
        (x, y) -> x – y
         4. 接收2个int型整数,返回他们的和
        (int x, int y) -> x + y
         5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)
        (String s) -> System.out.print(s)*/


import java.util.Arrays;
import java.lang.String;

public class leetCode_506_相对名次 {
    public static void main(String[] args) {
        int[] score = {1, 5, 3, 7, 9};
        System.out.println(Arrays.toString(findRelativeRanks(score)));
    }

    private static String[] findRelativeRanks(int[] score) {
        int length = score.length;
        int[][] nums = new int[length][2];
        String desc[] = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        for (int i = 0; i < length; i++) {
            nums[i][0] = score[i];
            nums[i][1] = i;
        }
        System.out.println(Arrays.deepToString(nums));
        Arrays.sort(nums,(a, b) -> b[0] - a[0]);
        System.out.println(Arrays.deepToString(nums));
        String[] strings = new String[length];
        for (int i = 0; i < length; i++) {
            if (i >= 3) {
                strings[nums[i][1]] = Integer.toString(i+1);
            } else {
                strings[nums[i][1]] = desc[i];
            }

        }
        return strings;
    }
}
