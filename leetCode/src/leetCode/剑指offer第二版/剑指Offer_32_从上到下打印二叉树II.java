package leetCode.剑指offer第二版;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
public class 剑指Offer_32_从上到下打印二叉树II {

    private static List<List<Integer>> levelOrder(TreeNode root) {
        //结果变量
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //
        Queue<TreeNode> queue = new LinkedList<>();
        //加入根节点
        queue.add(root);
        while (!queue.isEmpty()) {
            //中间每层的结果
            List<Integer> list = new ArrayList<>();
            //每层的数量
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                //中间节点承接
                TreeNode node = queue.poll();
                //获得父中节点值
                list.add(node.val);
                //左右非空判断
                if (node.left != null) {
                    //向下一层进发
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            //每层的结果
            res.add(list);
        }
        return res;
    }
}
