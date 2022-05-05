package leetCode.leetCode_2000;

public class leetCode_1405_最长快乐字符串 {
    public static void main(String[] args) {
        int a = 7, b = 1, c = 0;
        System.out.println(longestDiverseString(a,b,c));
    }
    /**
     * 如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，
     * 那么该字符串就是一个「快乐字符串」。
     * 尽可能长
     * */
    private static String longestDiverseString(int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        int tol = a+b+c;
        int currA = 0,currB = 0,currC=0;
        for(int i = 0;i< tol;i++){
            if((a >= b && a >= c && currA !=2) || (a>0 && (currB == 2 || currC == 2))){
                res.append("a");
                a--;
                currA++;
                currB = 0;
                currC = 0;
            } else if((b >= a && b >= c && currB !=2) || (b>0 && (currC == 2 || currA == 2))){
                res.append("b");
                b--;
                currB++;
                currA = 0;
                currC = 0;
            } else if((c >= b && c >= a && currC != 2) || (c>0 && (currB == 2 || currA == 2))){
                res.append("c");
                c--;
                currC++;
                currA = 0;
                currB = 0;
            }
        }
        return res.toString();
    }
}
