package leetCode.leetCode_500;

public class leetCode_136_只出现一次的数字 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 3};
        System.out.println(singleNumber(nums));
    }
    private static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;

    }
}
