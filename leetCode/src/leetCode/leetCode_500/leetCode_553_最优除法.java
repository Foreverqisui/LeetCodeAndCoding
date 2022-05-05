package leetCode.leetCode_500;

/**
 * 给定一组正整数，相邻的整数之间将会进行浮点除法操作。例如， [2,3,4] -> 2 / 3 / 4 。
 *
 * 但是，你可以在任意位置添加任意数目的括号，来改变算数的优先级。
 * 你需要找出怎么添加括号，才能得到最大的结果，并且返回相应的字符串格式的表达式。你的表达式不应该含有冗余的括号。
 *
 * 示例：
 *
 * 输入: [1000,100,10,2]
 * 输出: "1000/(100/10/2)"
 * 解释:
 * 1000/(100/10/2) = 1000/((100/10)/2) = 200
 * 但是，以下加粗的括号 "1000/((100/10)/2)" 是冗余的，
 * 因为他们并不影响操作的优先级，所以你需要返回 "1000/(100/10/2)"。
 *
 * 其他用例:
 * 1000/(100/10)/2 = 50
 * 1000/(100/(10/2)) = 50
 * 1000/100/10/2 = 0.5
 * 1000/100/(10/2) = 2
 * */
public class leetCode_553_最优除法 {
    public static void main(String[] args) {
        int []nums = {1000,100,10,2};
        System.out.println(optimalDivision(nums));
    }
    private static String optimalDivision(int[] nums) {
        int n = nums.length;
        StringBuffer res = new StringBuffer();
        if (n==1){
            return String.valueOf(nums[0]);
        }
        if (n==2){
            return nums[0] + "/" + nums[1];
        }
        res.append(nums[0]);
        res.append("/(");
        res.append(nums[1]);
        for (int i = 2; i < n; i++) {
            res.append("/");
            res.append(nums[i]);
        }
        res.append(")");
        return res.toString();
    }
}
