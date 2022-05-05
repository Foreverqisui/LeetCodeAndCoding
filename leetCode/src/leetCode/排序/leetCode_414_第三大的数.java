package leetCode.排序;

import java.util.Arrays;
import java.util.TreeSet;

public class leetCode_414_第三大的数 {
    public static void main(String[] args) {
        int[] nums = {2,2,3,1};
        System.out.println(thirdMax(nums));
        System.out.println(thirdMax1(nums));
        System.out.println(thirdMax2(nums));
    }

    /**
     * 一次遍历
     * */
    private static int thirdMax2(int[] nums) {
        Integer a = null;
        Integer b = null;
        Integer c = null;
        for (int num:nums
             ) {
            if ( a==null||num>a ) {
                c=b;
                b=a;
                a=num;
            }else if (a>num&&(b==null||b<num)){
                c=b;
                b=num;
            }else if (b!=null &&b>num&&(c==null||c<num)){
                c=num;
            }
        }
        return c==null? a:c;
    }


    /**
     * 有序集合TreeSet
     * */
    private static int thirdMax1(int[] nums) {
        TreeSet<Integer> ts = new TreeSet<Integer>();
        for (int num:nums
             ) {
            ts.add(num);
            if (ts.size()>3){
                ts.remove(ts.first());
            }
        }
        return ts.size()==3? ts.first() :ts.last();
    }


    /**
     * 普通排序
     * */
    private static int thirdMax(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0,right = n - 1;
        //把大的数按顺序放前面
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        //dif代表是第几个数
        for (int i = 1,dif=1; i < n; i++) {
            if (nums[i] != nums[i - 1] && ++dif == 3) {
                return nums[i];
            }
        }
        return nums[0];
    }
}
