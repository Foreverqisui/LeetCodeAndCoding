package leetCode.leetCode_1000;

/**
 * 二分查找
 * */
public class leetCode_704_二分查找 {
    public static void main(String[] args) {
        int a[]={1,3,5,8,7};
        int target=5;
        System.out.println(serach(a,target));
    }

    private static int serach(int[] a, int target) {
            int low=0;int high=a.length-1;
            while(low<=high){
                int mid=(high-low)/2+low;
                if (a[mid]==target){
                    return mid;
                }
                else if (a[mid]>target){
                    high=mid-1;
                }
                else {
                    low=low+1;
                }
            }
            return -1;
    }
}
