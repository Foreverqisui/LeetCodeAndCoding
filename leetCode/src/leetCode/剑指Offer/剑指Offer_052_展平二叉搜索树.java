package leetCode.剑指Offer;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一棵二叉搜索树，请 按中序遍历 将其重新排列为一棵递增顺序搜索树，
 * 使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 *
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * */
public class 剑指Offer_052_展平二叉搜索树 {

    private static TreeNode increasingBST(TreeNode root) {
        //作为存贮树内值的变量
        List<Integer> res = new ArrayList<>();
        //进入递归进行中序遍历
        inorder(root,res);
        //新构建一棵树 进行转化
        TreeNode newRoot = new TreeNode(-1);
        TreeNode node = newRoot;
        //遍历res中的值 向树中 进行添加
        for(int re:res){
            node.right = new TreeNode(re);
            node = node.right;
        }
        return newRoot.right;
    }

    private static void inorder(TreeNode node, List<Integer> res) {
        if (node==null) {
            return;
        }
        //遍历左节点 直到为空
        inorder(node.left,res);
        //将值加入到集合中
        res.add(node.val);
        //遍历右节点直到为空
        inorder(node.right,res);
    }
}
