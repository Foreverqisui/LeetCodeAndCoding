package leetCode.leetCode_1000;

public class leetCode_1995_统计特殊四元组 {
    public static void main(String[] args) {
        int[] num = {1,1,1,3,5};
        System.out.println(countQuadruplets(num));
    }

    private static int countQuadruplets(int[] num) {
        int max = 0;
        int cnt = 0;
        int n = num.length;
        for (int i = 0; i < n; i++) {
            if (num[i] > max) {
                max = num[i];
            }}
            //第一个数
            for (int j = 0; j < n - 3; j++) {
                int a1 = num[j];
                //如果第一个数+2大于最大值 则证明数组里不存在这样的四个数
                if (a1 + 2 > max) {
                    continue;
                }
                for (int k = j + 1; k < n - 2; k++) {
                    int a2 = num[k];
                    //如果前两个数之和+1大于最大值 同理不存在
                    if (a1 + a2 + 1 > max) {
                        continue;
                    }
                    //同理不存在
                    for (int l = k + 1; l < n - 1; l++) {
                        int a3 = num[l];
                        int sum = a1 + a2 + a3;
                        if (sum > max) {
                            continue;
                        }
                        for (int m = l+1; m < n; m++) {
                            if (num[m] == sum) {
                                cnt++;

                            }
                        }
                    }
                }
            }

        return cnt;
    }
}
