package leetCode.剑指offer第二版;

/**
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 *
 *
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * */

public class 剑指Offer_54_二叉搜索树的第k大节点 {

    class Solution {
        int res ,k;
        public int kthLargest(TreeNode root, int k) {
            this.k = k;
            dfs(root);
            return res;
        }
        public void dfs(TreeNode root){
            if(root==null){
                return;
            }
            //遍历右边
            dfs(root.right);
            if(k==0){
                return;
            }
            //找到结果
            if(--k==0){
                res = root.val;
            }
            //后遍历左边
            dfs(root.left);
        }
    }
}
