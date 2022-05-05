package leetCode.剑指offer第二版;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，
 * 那么它就是一棵平衡二叉树。
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回 true
 * */
public class 剑指Offer_55II_平衡二叉树 {
    class Solution {
        public boolean isBalanced(TreeNode root) {
            return depth(root)>=0;
        }
        public int depth(TreeNode node){
            if(node == null){
                return 0;
            }
            //左子树到底
            int left = depth(node.left);
            //右子树到底
            int right = depth(node.right);
            if(left ==-1 || right == -1 || Math.abs(left-right)>1){
                //此时不平衡
                return -1;
            }else{
                //返回最大深度
                return Math.max(left,right)+1;
            }
        }
    }
}
