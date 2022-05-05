package leetCode.树;

import java.util.Deque;
import java.util.LinkedList;

public class leetCode_226_翻转二叉树 {

    private static TreeNode invertTree(TreeNode root) {
        if (root==null) {
            return null;
        }
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if (node.left!=null){
                queue.offer(node.left);
            }
            if (node.right!=null){
                queue.offer(node.right);
            }
        }
        return root;
    }
}


