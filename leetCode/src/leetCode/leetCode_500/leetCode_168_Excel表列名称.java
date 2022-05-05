package leetCode.leetCode_500;

public class leetCode_168_Excel表列名称 {
    public static void main(String[] args) {
        int columnNumber = 701;
        System.out.println(convertToTitle(columnNumber));
    }

  /*  这是一道从 111 开始的的 262626 进制转换题。

    对于一般性的进制转换题目，只需要不断地对 columnNumber进行 % 运算取得最后一位，
    然后对 columnNumber 进行 / 运算，将已经取得的位数去掉，直到 columnNumber为 0 即可。

    一般性的进制转换题目无须进行额外操作，是因为我们是在「每一位数值范围在 [0,x」的前提下进行「逢 x 进一」。

    但本题需要我们将从 1开始，因此在执行「进制转换」操作前，我们需要先对 columnNumber执行减一操作，从而实现整体偏移。*/

    private static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber>0){
            columnNumber--;
            sb.append((char)(columnNumber%26+'A'));
            columnNumber/=26;
        }
        sb.reverse();
        return sb.toString();
    }
}
