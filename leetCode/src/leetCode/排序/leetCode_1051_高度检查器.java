package leetCode.排序;

import java.util.HashMap;
import java.util.Map;

public class leetCode_1051_高度检查器 {
    public static void main(String[] args) {
        int [] height = {1,1,1,2,3,4};
        System.out.println(heightChecker(height));
    }
    private static int heightChecker(int[] heights) {
        int []heightToFred = new int[101];
        //按照递减的顺序排在桶里
        for (int height : heights) {
            heightToFred[height]++;
        }
        int result = 0;
        int curheight = 0;
        for (int i = 0; i < heights.length; i++) {
            //清空为0的多余元素
            while(heightToFred[curheight]==0){
                curheight++;
            }

            if (curheight!=heights[i]){
                result++;
            }
            //将每次比较过的数减去一个
            heightToFred[curheight]--;
        }
        return result;
    }
}
