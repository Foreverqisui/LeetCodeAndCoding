package leetCode.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetCode_350_两个数组的交集II {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1};
        int[] num = {2, 2};
        System.out.println(Arrays.toString(intersect(nums, num)));
    }



    /**
     * 双指针
     */
    private static int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        while(i<n1&&j<n2){
            if (nums1[i]==nums2[j]){
                list.add(nums1[i]);
                j++;
                i++;
            }else if (nums1[i]<nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        int [] ret = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            ret[k] = list.get(k);
        }
        return ret;
    }
}
