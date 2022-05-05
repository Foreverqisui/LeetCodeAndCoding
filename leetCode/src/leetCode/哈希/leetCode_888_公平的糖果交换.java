package leetCode.哈希;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leetCode_888_公平的糖果交换 {
    public static void main(String[] args) {
        int[] aliceSizes = {1, 2, 5};
        int[] bobSizes = {2, 4};
        System.out.println(Arrays.toString(fairCandySwap(aliceSizes, bobSizes)));
        System.out.println(Arrays.toString(fairCandySwap1(aliceSizes, bobSizes)));
    }

    private static int[] fairCandySwap1(int[] aliceSizes, int[] bobSizes) {
        Set<Integer> set = new HashSet<Integer>();
        int sumA =0,sumB =0;
        for(int i = 0; i < aliceSizes.length;i++){
             set.add(aliceSizes[i]);
             sumA += aliceSizes[i];
        }
        for(int i = 0; i < bobSizes.length;i++){
            sumB += bobSizes[i];
        }
        int avg = (sumA - sumB) >>1;
        for (int i = 0; i < bobSizes.length; i++) {
            int targetA = bobSizes[i]+avg;
            if (set.contains(targetA)){
                return new int[]{targetA,bobSizes[i]};
            }
        }
        return null;
    }


    /**
     * 暴力
     */
    private static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0, sumB = 0;
        for (int i = 0; i < aliceSizes.length; i++) {
            sumA += aliceSizes[i];
        }
        for (int i = 0; i < bobSizes.length; i++) {
            sumB += bobSizes[i];
        }
        int avg = (sumA - sumB)>>1;
        for (int i = 0; i < aliceSizes.length; i++) {
            for (int i1 = 0; i1 < bobSizes.length; i1++) {
                if (aliceSizes[i]-bobSizes[i1]==avg){
                    return new int[]{aliceSizes[i],bobSizes[i1]};
                }
            }
        }
        return null;
    }
}
