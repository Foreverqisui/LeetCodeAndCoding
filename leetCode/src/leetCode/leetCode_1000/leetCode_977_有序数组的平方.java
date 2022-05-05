package leetCode.leetCode_1000;

import java.util.Arrays;

/**
 * 有序数组的平方
 * 双指针
 * */
public class leetCode_977_有序数组的平方 {
    public static void main(String[] args) {
        int[]arr={1,3,5,7,9};
        System.out.println(Arrays.toString(sortedSquares(arr)));
    }


    public static int [] sortedSquares(int []arr){
            int negative=-1;
            int n=arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<0){
                negative=i;
            }else {
                break;
            }
        }
        int temp[]=new int[n];
       int index=0;int i=negative;int j=negative+1;
        while(i>=0||j<n){
           if (i<0){
               temp[index]=arr[j]*arr[j];
               ++j;
           }else if (j==n){
               temp[index]=arr[i]*arr[i];
               --i;
           }else if (arr[i]*arr[i]<arr[j]*arr[j]){
               temp[index]=arr[i]*arr[i];
               --i;
           }else {
               temp[index]=arr[j]*arr[j];
               ++j;
           }
            index++;
    }
        return temp;
}}
