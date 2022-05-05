package leetCode.树;


import java.util.Stack;

public class leetCode_98_验证二叉搜索树 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(5);
        TreeNode tree = new TreeNode(3,a,b);
        isValidBST(tree);
        isValidBST1(tree);
    }
    /**
     * 中序遍历
     * */
    private static boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                //第一次栈里压入root，root变成左节点
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //判断是否满足二叉搜索树的条件
            if(pre != null && root.val <= pre.val) {
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }



    /**
     * 递归
     * */
    private static boolean isValidBST(TreeNode root) {
        long pre = Long.MIN_VALUE;
        if (root == null){
            return true;
        }
        if (!isValidBST(root.left)){
            return false;
        }
        if (root.val<=pre){
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }
}
