package leetCode.双指针;

/**
 * 移除元素
 * 利用双指针
 * */
public class leetCode_27_移除元素 {
    public static void main(String[] args) {
        int []arr={2};
        System.out.println(removeElement(arr,3));
    }
    public static int removeElement(int []sum,int val){
        if (sum==null||sum.length==0){
            return 0;
        }
        int slow=0;
        for (int i = 0; i < sum.length; i++) {
            if (sum[i]!=val){
                sum[slow]=sum[i];
                slow++;
            }
        }
        return slow;
    }
}
