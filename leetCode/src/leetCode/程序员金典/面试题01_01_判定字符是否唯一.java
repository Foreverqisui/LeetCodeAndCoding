package leetCode.程序员金典;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode"
 * 输出: false
 */
public class 面试题01_01_判定字符是否唯一 {
    public static void main(String[] args) {
        String s = "kzwunahkiz";
        System.out.println(isUnique(s));
    }

    private static boolean isUnique(String astr) {
        char[] num = astr.toCharArray();
        Arrays.sort(num);
        for (int i = 0; i < astr.length() - 1; i++) {
            if (num[i] == num[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
