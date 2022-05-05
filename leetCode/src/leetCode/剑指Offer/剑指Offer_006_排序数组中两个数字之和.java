package leetCode.剑指Offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 剑指Offer_006_排序数组中两个数字之和 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 4, 6, 10};
        int target = 8;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    /**
     * 万能哈希表
     *时间复杂度O（n）
     * */
    private static int[] twoSum1(int[] numbers, int target){
        Map<Integer ,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<numbers.length; i++){
            if (map.containsKey(target-numbers[i])){
                return new int[]{map.get(target-numbers[i]),i};
            }
            map.put(numbers[i],i);
        }
        return new int[0];
    }


    /**
     * 无脑暴力法
     * 时间复杂度O（n2）
     * */
    private static int[] twoSum(int[] numbers, int target) {
        int [] res = new int[2];
        for(int i =0;i<numbers.length;i++){
            for(int j = i+1;j<numbers.length;j++){
                if (numbers[j]+numbers[i]==target){
                    res[0]=i;
                    res[1]=j;
                }
            }
        }
        return res;
    }
}
