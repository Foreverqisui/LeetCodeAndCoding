package leetCode.leetCode_2000;

public class leetCode_2024_考试的最大困扰度 {
    public static void main(String[] args) {
        String answerKey = "TTFTTFTT";
        int k = 1;
        System.out.println(maxConsecutiveAnswers(answerKey, k));
    }

    private static int maxConsecutiveAnswers(String answerKey, int k) {
        int left =0,right =0,cnT = 0,cnF=0;
        char [] key = answerKey.toCharArray();
        //边界条件判断 终止条件
        while(right<answerKey.length()){
            //移动
            //统计T和F分别的字符数量
            if(key[right]=='T'){
                cnT++;
            }else{
                cnF++;
            }
            //求得两数之间的最小值，也就是需要改变的位置
            int minPosition = Math.min(cnF,cnT);
            //需要改变的字符数超过k，则需要减去左边窗口
            if (minPosition>k){
                if(key[left]=='T'){
                    cnT--;
                }else{
                    cnF--;
                }
                left++;
            }
            //移动右窗口
            right++;
        }
        return right-left;
    }

}
