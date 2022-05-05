package leetCode.leetCode_1000;


/**
 * 有两种特殊字符：
 * <p>
 * 第一种字符可以用一比特 0 表示
 * 第二种字符可以用两比特（10 或 11）表示
 * <p>
 * 给你一个以 0 结尾的二进制数组 bits ，如果最后一个字符必须是一个一比特字符，则返回 true 。
 * 示例 1:
 * <p>
 * 输入: bits = [1, 0, 0]
 * 输出: true
 * 解释: 唯一的解码方式是将其解析为一个两比特字符和一个一比特字符。
 * 所以最后一个字符是一比特字符。
 */
public class leetCode_717_比特与比特字符 {

    public static void main(String[] args) {
        int[] bits = {0};
        System.out.println(isOneBitCharacter(bits));
    }

    private static boolean isOneBitCharacter(int[] bits) {
        int n  = bits.length;
        int i = 0;
        while(i<n-1){
            i+=bits[i]+1;
        }
        return i == n-1;
    }
}
