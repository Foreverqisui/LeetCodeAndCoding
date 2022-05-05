package leetCode.leetCode_2000;

public class leetCode_1716_计算力扣银行的钱 {
    public static void main(String[] args) {
        int n = 20;
        System.out.println(totalMoney(n));
    }

    private static int totalMoney(int n) {
        int week = 1;
        int day = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += week+day-1;
            day++;
            if (day==8){
                day=1;
                week++;
            }
        }
        return sum;
    }
}
