package leetCode.双指针;

public class leetCode_11_盛最多水的容器 {
    public static void main(String[] args) {
        int[] height = {4, 3, 2, 1, 4};
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
       int n = height.length;
       int left = 0 ;
       int right = n-1;
       int maxArea = 0;
       while (left < right) {
           maxArea = Math.max(maxArea,Math.min(height[left],height[right])*(right-left));
           if (height[left]<height[right]){
               left++;
           }else {
               right--;
           }
       }
       return maxArea;
    }

}
