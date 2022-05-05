package leetCode.leetCode_500;

/**
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num = 100
 * 输出: "202"
 */
public class leetCode_504_七进制数 {
    public static void main(String[] args) {
        int num = -7;
        System.out.println(convertToBase7(num));
    }

    private static String convertToBase7(int num) {
        int pre = 0;
        StringBuffer res = new StringBuffer();
        if (num==0){
            return "0";
        }
        boolean flag = num>0;
        num = Math.abs(num);

        while(num>0){
            pre = num%7;
            num/=7;
            res.append(pre);
        }
        if (!flag){
            res.append("-");
        }
        return res.reverse().toString();
    }
}

