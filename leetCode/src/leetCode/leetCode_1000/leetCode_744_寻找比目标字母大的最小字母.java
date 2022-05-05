package leetCode.leetCode_1000;

/**
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，
 * 请你寻找在这一有序列表里比目标字母大的最小字母。
 *
 * 在比较时，字母是依序循环出现的。举个例子：
 *
 *     如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 * 示例 1：
 *
 * 输入: letters = ["c", "f", "j"]，target = "a"
 * 输出: "c"
 * */
public class leetCode_744_寻找比目标字母大的最小字母 {
    public static void main(String[] args) {
        char [] letters = {'c', 'f', 'j'};
        char target = 'a';
        System.out.println(nextGreatestLetter(letters,target));
    }
    private static char nextGreatestLetter(char[] letters, char target) {
        int left = 0,right = letters.length-1;
        if (letters[right]>=target){
            return letters[0];
        }
        while(left<=right){
            int mid = (left+right)>>1;
            if (letters[mid]>target){
                right = mid-1;
            }else{
                left = mid;
            }
        }
        return letters[left];
    }
}
