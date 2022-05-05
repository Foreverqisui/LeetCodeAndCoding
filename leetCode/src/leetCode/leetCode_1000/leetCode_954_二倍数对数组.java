package leetCode.leetCode_1000;

import java.util.*;

/**
 *
 * 给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，
 * 都有 arr[2 * i + 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,1,3,6]
 * 输出：false
 * */
public class leetCode_954_二倍数对数组 {
    public static void main(String[] args) {
        int [] arr = {4,-2,2,-4,-8,-4};
        System.out.println(canReorderDoubled(arr));
    }
    private static boolean canReorderDoubled(int[] arr) {
        //题目让arr分成两个对半的数组 且 一个数组中的元素要是另一个元素的两倍
        //借助哈希表，模拟数量，进行减除
        Map<Integer,Integer> map = new HashMap<>();
        for(int i :arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        //list存储数组值，按值从小到大进行排序
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list,(a,b)->Math.abs(a)-Math.abs(b));
        for(int val:list){
            //得到当前值对应的数量
            int count = map.get(val);
            //为0是，则不存在
            if(count==0){
                continue;
            }
            //2倍的元素比本身少，证明不存在这样的数组
            int doubleVal = map.getOrDefault(2*val,0);
            if(count>doubleVal){
                return false;
            }
            //移除放进的count值
            map.put(2*val,doubleVal-count);
        }
        return true;
    }
}
