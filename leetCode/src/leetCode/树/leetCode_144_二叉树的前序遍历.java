package leetCode.树;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class leetCode_144_二叉树的前序遍历 {

    private static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        //反复执行下述操作
        while(root!=null){
            //放入当前节点的值
            res.add(root.val);
            if(root.right!=null){
                //当右节点不为空的时候，将右节点入栈
                stack.push(root.right);
            }
            //切换到左子节点
            root = root.left;
            if(root==null&&!stack.isEmpty()){
                //当左子节点为空的时候，则返回到右父节点
                root = stack.pop();
            }
        }
        return res;
    }
}
