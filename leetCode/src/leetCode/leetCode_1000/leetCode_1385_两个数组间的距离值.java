package leetCode.leetCode_1000;

public class leetCode_1385_两个数组间的距离值 {
    public static void main(String[] args) {
        int []arr1={2,1,100,3};
        int [] arr2 = {-5,-2,10,-3,7};
         int d = 6;
        System.out.println(findTheDistanceValue(arr1,arr2,d));
    }

    private static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int cnt=0;
        boolean foud=false;
        for (int a1:arr1
             ) {
            for (int i = 0; i < arr2.length; i++) {
                if (Math.abs(a1-arr2[i])>d){
                    foud=true;
            }else {
                    foud=false;
                    break;
                }
            }
            if (foud){
                cnt++;
            }
        }
        return cnt;
    }
}
