package leetCode.leetCode_100;

/**
 * 搜索插入位置
 * 利用二分法
 */
public class leetCode_35_搜索插入位置 {
    public static void main(String[] args) {
        int[] sum = {1, 3, 5, 7};
        System.out.println(searchInsert(sum, 5));
    }

    public static int searchInsert(int[] sum, int target) {
        int l = 0;
        int r = sum.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (sum[mid] == target) {
                return mid;
            } else if (sum[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
