package leetCode.树;

public class leetCode_572_另一棵树的子树 {
    public static void main(String[] args) {

    }

    private static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    private static boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return check(root, subRoot) || dfs(root.left, subRoot)||dfs(root.right, subRoot);

    }

    private static boolean check(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null || root.val == subRoot.val) {
            return false;
        }
        return check(root.left, subRoot.left) && check(root.right, subRoot.right);
    }


}
