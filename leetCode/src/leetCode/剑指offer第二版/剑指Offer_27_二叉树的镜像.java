package leetCode.剑指offer第二版;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 例如输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 镜像输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 */
public class 剑指Offer_27_二叉树的镜像 {

    private TreeNode mirrorTree(TreeNode root) {
        //为空时判断
        if (root == null) {
            return root;
        }
        //构建队列，用来模拟翻转操作
        Deque<TreeNode> queue = new LinkedList<>();
        //将根节点放入队列
        queue.offer(root);
        //翻转操作
        while (!queue.isEmpty()) {
            //将父节点获取并弹出
            TreeNode node = queue.poll();
            //拿到左边节点 做缓存
            TreeNode left = node.left;
            //交换左右节点
            node.left = node.right;
            node.right = left;
            //向下进行移动
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
}
