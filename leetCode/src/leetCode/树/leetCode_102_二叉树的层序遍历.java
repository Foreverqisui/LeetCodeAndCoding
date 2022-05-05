package leetCode.树;

import java.util.*;

public class leetCode_102_二叉树的层序遍历 {


    public List<List<Integer>> levelOrder(TreeNode root) {

        /**
         * @param res 用来返回结果的集合
         * @param queue 模拟树结构
         * @param nod 存储最后进去的节点
         * @param list 中间值存取
         * queue.poll：检索并删除该队列的头部，如果该队列为空，则返回null。
         * 层序遍历的步骤：1.创建结果对象res 2.创建队列模拟树对象queue 把根节点放入 3.创建上一节点的接收对象nod 4.创建中间值存取对象list
         *             每次循环后都会进行删头操作，也就是将上一层的值放入list 把子节点放入队列 以此类推
         * */
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                TreeNode nod = queue.poll();
                list.add(nod.val);
                if (nod.left != null) {
                    queue.add(nod.left);
                }
                if (nod.right != null) {
                    queue.add(nod.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
