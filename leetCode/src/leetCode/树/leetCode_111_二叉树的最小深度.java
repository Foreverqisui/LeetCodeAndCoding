package leetCode.树;




/**
 * 二叉树的最小深度
 */
public class leetCode_111_二叉树的最小深度 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        System.out.println(minDepth(treeNode));
    }

    private static int minDepth(TreeNode root) {
        if(root==null) {
            return 0;
        }
        if (root.left==null&&root.right==null) {
            return 1;
        }
        int minDept=Integer.MAX_VALUE;
        if(root.left!=null){
            minDept=Math.min(minDept,minDepth(root.left));
        }
        if(root.right!=null){
            minDept=Math.min(minDept,minDepth(root.right));
        }
        return minDept+1;
    }
}
