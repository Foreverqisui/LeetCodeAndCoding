package leetCode.双指针;

public class leetCode_202_快乐数 {
    public static void main(String[] args) {
        int n=19;
        System.out.println(isHappy(n));
    }

    private static boolean isHappy(int n) {
        int fast=getNext(n);
        int slow=n;
        while(fast!=1&&fast!=slow){
            slow=getNext(slow);
            fast=getNext(getNext(fast));
        }
        return fast==1;

    }
    private static int getNext(int n){
        int sum=0;
        while(n>0){
            int m=n%10;
            n=n/10;
            sum+=m*m;
        }
        return sum;
    }
}
