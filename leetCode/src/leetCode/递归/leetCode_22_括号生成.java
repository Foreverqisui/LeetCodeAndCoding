package leetCode.递归;


import java.util.ArrayList;
import java.util.List;


public class leetCode_22_括号生成 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
    private static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    /**
     * 递归
     * 先加入n个左括号，之后匹配n个右括号
     * terminator：当括号总长度str==2的时候，匹配成功
     * drill down: 当左括号数量小于n时，一直加入左括号
     *             当右括号长度小于左括号长度时，一直加入右括号
     * */

    private static void backtrack(List<String> list, String str, int open, int close, int max){
        //terminator
        if(str.length() == max*2){
            list.add(str);
            return;
        }
        //process current logic

        //drill down
        if(open < max){
            backtrack(list, str+"(", open+1, close, max);
            System.out.println(list);}
        if(close < open){
            backtrack(list, str+")", open, close+1, max);
            System.out.println(list);}
        //reverse states
    }
}
