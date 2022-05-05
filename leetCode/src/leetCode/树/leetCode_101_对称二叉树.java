package leetCode.树;



/**
 * 对称二叉树
 */
public class leetCode_101_对称二叉树 {
    public static void main(String[] args) {
        TreeNode1 treeNode = new TreeNode1(123);
        TreeNode1 treeNode1=new TreeNode1(123);
        System.out.println(isSymmetric(treeNode,treeNode1));
    }

    private static boolean isSymmetric(TreeNode1 treeNode, TreeNode1 treeNode1) {
        return isMiro(treeNode, treeNode1);
    }

    private static boolean isMiro(TreeNode1 treeNode, TreeNode1 treeNode1) {
        if (treeNode == null && treeNode1 == null) {
            return true;
        }
        if (treeNode == null || treeNode1 == null) {
            return false;
        }
        return treeNode.val == treeNode1.val &&
                isMiro(treeNode.left ,treeNode1.right) &&
                isMiro(treeNode.right, treeNode1.left);
    }
}
class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode1() {
    }

    TreeNode1(int val) {
        this.val = val;
    }

    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}