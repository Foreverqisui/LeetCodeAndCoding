package leetCode.剑指offer第二版;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，
 * 则最小的4个数字是1、2、3、4。
 *
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * */
public class 剑指Offer_40_最小的k个数 {
    public static void main(String[] args) {
        int [] arr = {3,2,1};
        int k =2;
        System.out.println(Arrays.toString(getLeastNumbers(arr, k)));
        System.out.println(Arrays.toString(getLeastNumbers1(arr, k)));
    }
    /**
     * 分组快排
     * */
    private static int[] getLeastNumbers1(int[] arr, int k) {
        int n = arr.length-1;
        if (k>=n+1){
            return arr;
        }
        return quickSort(arr,k,0,n);
    }
    //快排
    private static int[] quickSort(int[] arr, int k, int l, int r) {
        int i =l,j=r;
        while(i<j){
            //以首为基数 进行交换
            while(i<j&&arr[j]>=arr[l]){
                j--;
            }
            while (i<j&&arr[i]<=arr[l]){
                i++;
            }
            swap(arr,i,j);
        }
        swap(arr,i,l);
        //判断是哪半部分
        if (i>k){
            quickSort(arr,k,i,l-1);
        }
        if (i<k){
            quickSort(arr,k,i,r);
        }
        return Arrays.copyOf(arr,k);
    }
    //swap函数
    private static void swap(int [] arr,int l ,int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }


    /**
     * 大顶堆
     * */
    private static int[] getLeastNumbers(int[] arr, int k) {
        //为空判断吧
        if (k==0){
            return null;
        }
        int [] res = new int[k];
        //构建大顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer num1, Integer num2) {
               return num2-num1;
            }
        });
        //放入前k个元素
        for (int i = 0; i < k; i++) {
            heap.offer(arr[i]);
        }
        //k个以后进行比较
        for (int i = k; i < arr.length; i++) {
            if (heap.peek()>arr[i]){
                heap.poll();
                heap.offer(arr[i]);
            }
        }
        //结果赋值
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
    }
}
