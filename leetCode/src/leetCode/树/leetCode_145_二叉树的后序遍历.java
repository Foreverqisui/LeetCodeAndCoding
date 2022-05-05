package leetCode.树;

import java.util.*;

public class leetCode_145_二叉树的后序遍历 {

    private static List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                //addFirst:在此双端队列的前面插入指定元素。做一个翻转的操作
                result.addFirst(root.val);
                //走到右子节点
                root = root.right;
            } else {
                //回到父节点
                root = stack.pop();
                //遍历左节点
                root = root.left;
            }
        }
        return result;

    }
}
