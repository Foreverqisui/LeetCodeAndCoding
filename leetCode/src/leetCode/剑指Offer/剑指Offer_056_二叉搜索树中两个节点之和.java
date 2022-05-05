package leetCode.剑指Offer;

import java.util.*;

public class 剑指Offer_056_二叉搜索树中两个节点之和 {

    /**
     * 给定一个二叉搜索树的 根节点 root 和一个整数 k ,
     * 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。假设二叉搜索树中节点的值均唯一。
     *
     * 示例 1：
     *
     * 输入: root = [8,6,10,5,7,9,11], k = 12
     * 输出: true
     * 解释: 节点 5 和节点 7 之和等于 12
     * */

    /**
     * HashSet+递归
     * */
    private static boolean findTarget1(TreeNode root,int k){
        Set<Integer> set = new HashSet<Integer>();
        return find(root,k,set);
    }

    private static boolean find(TreeNode root, int k, Set<Integer> set) {
        if (root == null){
            return false;
        }
        if (set.contains(k-root.val)){
            return true;
        }
            set.add(root.val);
        return find(root.left,k,set)||find(root.right,k,set);
    }

    /**
     * 中序遍历+两数之和
     * */
    private static boolean findTarget(TreeNode root, int k) {
        List<Integer> res = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //中序遍历
        inorder(root,res);
        //遍历集合 判断是否满足题意
        for(int val :res) {
            if (map.containsKey(k-val)){
                return true;
            }
            map.put(k,val);
        }
        return false;
    }

    private static void inorder(TreeNode root, List<Integer> res) {
        if (root==null) {
            return;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }

}
