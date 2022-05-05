package leetCode.leetCode_2000;

public class leetCode_1725_可以形成最大正方形的矩形数目 {
    public static void main(String[] args) {
        int[][] rectangles = {{5, 8}, {3, 9}, {5, 12}, {16, 5}};
        System.out.println(countGoodRectangles(rectangles));
    }

    private static int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0,res=0;
       for(int [] rect : rectangles) {
           int l = rect[0],w=rect[1];
           int k  = Math.min(l,w);
           if (maxLen==k){
               res++;
           }else if (maxLen<k){
               res=1;
               maxLen=k;
           }
       }
       return res;

    }
}
