package leetCode.剑指Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 */
public class 剑指Offer_046_二叉树的右侧视图 {

    /**
     * DFS
     * 递归的层序
     * */
    List<Integer> res = new ArrayList<Integer>();
    private List<Integer> rightSideView1(TreeNode root) {
        dfs(root,0);
        return res;
    }

    private void dfs(TreeNode root, int deep) {
        if (root == null){
            return;
        }
        if (deep == res.size()){
            res.add(root.val);
        }
        deep++;
        //其实没太看懂这个地方
        dfs(root.right,deep);
        dfs(root.left,deep);
    }


    /**
     * BFS
     * 迭代的层序
     * */
    private List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }

}