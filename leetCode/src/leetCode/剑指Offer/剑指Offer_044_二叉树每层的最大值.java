package leetCode.剑指Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 * 解释:
 * 1
 * / \
 * 3   2
 * / \   \
 * 5   3   9
 */
public class 剑指Offer_044_二叉树每层的最大值 {

    private static List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //判断特殊条件
        if (root==null) {
            return res;
        }
        queue.offer(root);
        //进行层序遍历
        while(!queue.isEmpty()){
            //维护变量最大值
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //进行了根节点删除操作
                TreeNode node = queue.poll();
                //判断当前节点是否比上一个节点的值大
                if (node!=null&&node.val>max){
                    max = node.val;
                }
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}
