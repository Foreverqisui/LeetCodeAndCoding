package leetCode.leetCode_100;

import java.util.*;

public class leetCode_71简化路径 {
    public static void main(String[] args) {
        String path = "/home//foo/";
        System.out.println(simplifyPath(path));
    }
    private static String simplifyPath(String path) {
        /**
         * @param stack:用队列模拟栈
         * @param set:用来存储特殊符号
         * @param dir:已经被/划分好的目录
         * @param res:用来存储结果
         * */
        Deque<String> stack = new LinkedList<>();
        Set<String> set = new HashSet<String>(Arrays.asList("..",".",""));
        for (String dir:path.split("/")){
            //如果/后面是..则弹出
            if (dir.equals("..")&&!stack.isEmpty()){
                stack.pop();
                //如果dir里面不包含set里面的特殊字符，则放入栈中
            }else if (!set.contains(dir)){
                stack.push(dir);
            }
        }
        String res="";
        for (String dir:stack){
            res="/"+dir+res;
        }
        return stack.isEmpty() ? "/" : res;
    }
}
