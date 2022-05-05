package leetCode.双指针;

/**
 * 删除数组中的重复项
 * 利用双指针
 */
public class leetCode_26_删除数组中的重复项 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int slow = 1;
        int fast = 1;
        while (fast < num.length ) {
            if (num[fast] != num[fast - 1]) {
                num[slow] = num[fast];
               ++slow;
            }
            ++fast;
        }
        return slow;
    }
}
