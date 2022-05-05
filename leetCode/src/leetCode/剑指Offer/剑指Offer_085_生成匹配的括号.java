package leetCode.剑指Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * */
public class 剑指Offer_085_生成匹配的括号 {

    public static void main(String[] args) {
        int n = 3;

    }
    class Solution {
        public List<String> generateParenthesis(int n) {
            //排列组合 定是回溯
            //遇到回溯 不慌不忙 递归走起
            List<String> res = new ArrayList<>();
            //此题有左又有右，左右配对不孤单
            backTrack(n,res,0,0,"");
            return res;
        }
        public void backTrack(int max,List<String> res,int left,int right,String str){
            //遇到递归不要慌 认真仔细找终止
            //仔细看题是一对，配成二倍就换人
            if(str.length()==2*max){
                res.add(str);
                return;
            }
            //你配我来再配她，节目效果要拉满
            //看看左边看看右，先把演员安排齐
            if(left<max){
                //演员入场不慌乱，名额有限不能抢
                //自身条件得介绍 是左是右说清楚
                backTrack(max,res,left+1,right,str+'(');
            }
            //演员就位嘉宾上 嘉宾演员一对一
            if(right<left){
                backTrack(max,res,left,right+1,str+')');
            }
        }
    }
}
