package leetCode.剑指Offer;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 [最底层] [最左边] 节点的值。
 * 假设二叉树中至少有一个节点。
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 */
public class 剑指Offer_045_二叉树最底层最左边的值 {

    class solution {
        //层数
        private int Deep;
        //节点对应的值
        private int value;

        /**
         * 层序遍历
         * 递归
         */
        private int findBottomLeftValue1(TreeNode root) {
            value = root.val;
            findLeftValue(root,0);
            return value;

        }

        private void findLeftValue(TreeNode root, int deep) {
            if (root == null){
                return;
            }
            //终止条件
            if (root.left==null && root.right==null) {
                if (deep>Deep) {
                    value = root.val;
                    Deep = deep;
                }
            }
            if (root.left!=null){
                findLeftValue(root.left,deep+1);
            }
            if (root.right != null){
                findLeftValue(root.right,deep+1);
            }
        }

        /**
         * 层序遍历
         * 迭代
         */
        private int findBottomLeftValue(TreeNode root) {
            int res = 0;
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (i == 0) {
                        res = node.val;
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            return res;
        }
    }
}
