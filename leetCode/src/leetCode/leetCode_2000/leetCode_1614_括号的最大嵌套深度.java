package leetCode.leetCode_2000;

public class leetCode_1614_括号的最大嵌套深度 {
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s));
    }

    private static int maxDepth(String s) {
        int cnt = 0,res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                cnt++;
            }
            else if (s.charAt(i) == ')'){
                cnt--;
            }
            res =Math.max(res,cnt);
        }
        return res;
    }
}
