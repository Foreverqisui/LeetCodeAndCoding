package leetCode.leetCode_1000;


import java.util.Arrays;
import java.util.Stack;

/**
 * 给你一个字符串 dominoes 表示这一行多米诺骨牌的初始状态，其中：
 * <p>
 * dominoes[i] = 'L'，表示第 i 张多米诺骨牌被推向左侧，
 * dominoes[i] = 'R'，表示第 i 张多米诺骨牌被推向右侧，
 * dominoes[i] = '.'，表示没有推动第 i 张多米诺骨牌。
 * <p>
 * 返回表示最终状态的字符串。
 */
public class leetCode_838_推多米诺 {

    public static void main(String[] args) {
        String dominoes = ".L.R...LR..L..";
        // 结果是 "LL.RR.LLRRLL.."
        System.out.println(pushDominoes(dominoes));
    }

    /**
     * 预处理+双指针
     */
    private static String pushDominoes(String dominoes) {
        char[] chars = dominoes.toCharArray();
        int len = chars.length, i = 0;
        char left = 'L';
        while (i < len) {
            //做第一次处理 找到连续的一段.
            //temp作为存储同一段连续区域内最后位置的变量
            int temp = i;
            while (temp < len && chars[temp] == '.') {
                temp++;
            }
            // 判断右边的值
            char right = temp<len?chars[temp] : 'R';
            //第二次处理 相等的情况 则将所有变成同向
            if (left == right){
                while(i<temp){
                    chars[i++]=right;
                }
            //第三次处理 如果不相等的情况下，左右向中间靠拢。
            }else if (left=='R'&& right=='L'){
                int k = temp-1;
                while (i<k){
                    chars[i++]=left;
                    chars[k--]=right;
                }
            }
            left = right;
            i=temp+1;
        }
        return new String(chars);
    }
}