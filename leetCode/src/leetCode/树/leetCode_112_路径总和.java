package leetCode.树;

public class leetCode_112_路径总和 {

    private boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null) {
            return false;
        }
        if (root.left==null&&root.right==null&&root.val==targetSum) {
            return true;
        }
        return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
    }
}
