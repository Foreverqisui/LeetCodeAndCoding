package leetCode.leetCode_2000;

public class leetCode_1688_比赛中的配对次数 {
    public static void main(String[] args) {
        int n = 14;
        System.out.println(numberOfMatches(n));
    }

    private static int numberOfMatches(int n) {
        /**
         * @param res:结果
         * @param team:队伍数
         * */
        int res = 0;
        int team = n;
        while(team>1){
            if (team%2==0){
                team/=2;
                res+=team;
            }
            if (team%2==1){
                res+=(team-1)/2;
                team=(team - 1) / 2 + 1;
            }
        }
        return res;
    }
}
