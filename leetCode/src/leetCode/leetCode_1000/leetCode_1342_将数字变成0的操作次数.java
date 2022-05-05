package leetCode.leetCode_1000;

public class leetCode_1342_将数字变成0的操作次数 {
    public static void main(String[] args) {
        int num = 123;
        System.out.println(numberOfSteps(num));
    }
    private static int numberOfSteps(int num) {
        int res = 0;
        while (num!=0){
            if (num%2==0){
                num/=2;
                res++;
            }else if (num%2==1){
                num-=1;
                res++;
            }
        }
        return res;
    }
}
