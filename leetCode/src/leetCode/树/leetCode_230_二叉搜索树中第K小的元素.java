package leetCode.树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetCode_230_二叉搜索树中第K小的元素 {
    public static void main(String[] args) {

    }
    private static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack =new Stack<TreeNode>();
        while(!stack.isEmpty()||root!=null) {
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k==0){break;}
            root = root.right;
        }
        return root.val;
    }
}
