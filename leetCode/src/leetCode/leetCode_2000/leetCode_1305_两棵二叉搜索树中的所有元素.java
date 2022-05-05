package leetCode.leetCode_2000;

import leetCode.leetCode_2000.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 * <p>
 * 输入：root1 = [2,1,4], root2 = [1,0,3]
 * 输出：[0,1,1,2,3,4]
 */
public class leetCode_1305_两棵二叉搜索树中的所有元素 {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        //五一种树大业
        //借助两个集合存储树中值
        List<Integer> r1 = new ArrayList<Integer>();
        List<Integer> r2 = new ArrayList<Integer>();
        //结果变量
        List<Integer> res = new ArrayList<Integer>();
        //归并变量
        int m = 0, n = 0;
        //dfs中序遍历
        dfs(r1, root1);
        dfs(r2, root2);
        //死循环 -- 终止条件时 一方长度到达上限
        //由于二叉搜索树，所以两边已经达到顺序状态 -- 可以归并
        while (true) {
            //一方遍历到长度 -- 把另一个后面的所有拼上去
            if (m == r1.size()) {
                res.addAll(r2.subList(n, r2.size()));
                break;
            }
            if (n == r2.size()) {
                res.addAll(r1.subList(m, r1.size()));
                break;
            }
            //一方比另一方小
            if (r1.get(m) < r2.get(n)) {
                res.add(r1.get(m++));
            } else {
                res.add(r2.get(n++));
            }
        }
        return res;
    }

    //中序遍历
    public void dfs(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(list, root.left);
        list.add(root.val);
        dfs(list, root.right);
    }
}