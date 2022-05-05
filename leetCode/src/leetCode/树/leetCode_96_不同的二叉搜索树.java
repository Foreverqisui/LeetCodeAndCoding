package leetCode.树;

/**
 * 不同的二叉搜索树
 * 卡特兰数
 * */
public class leetCode_96_不同的二叉搜索树 {
    public static void main(String[] args) {
        int n=3;
        System.out.println(numTrees(3));
    }

    private static int numTrees(int n) {
            int []dp=new int[n+1];
            dp[0]=1;
            dp[1]=1;
        for (int i = 2; i < n+1; i++) {
            for (int j = 1; j < i+1; j++) {
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
