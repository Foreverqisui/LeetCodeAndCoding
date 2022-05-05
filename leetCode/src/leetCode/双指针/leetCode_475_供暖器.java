package leetCode.双指针;

import java.util.Arrays;

public class leetCode_475_供暖器 {
    public static void main(String[] args) {
        int[] houses = {1,5};
        int[] heaters = {10};
        System.out.println(findRaius(houses, heaters));
    }

    private static int findRaius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int hou = 0;
        int hea = 0;
        int temp = 0;
        for (; hou < houses.length; hou++) {
            int r = Math.abs(houses[hou] - heaters[hea]);
            while (hea < heaters.length-1 &&
                    Math.abs(houses[hou] - heaters[hea]) >= Math.abs(houses[hou] - heaters[hea+1])){
                hea++;
                r = Math.min(r, Math.abs(houses[hou] - heaters[hea]));
            }
            temp = Math.max(temp, r);

        }
        return temp;

    }
}
