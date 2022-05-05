package leetCode.树;




/**
 * 二叉树的最大深度
 */
public class leetCode_104_二叉树的最大深度 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.val=5;
        System.out.println(maxDepth(treeNode));
    }

    private static int maxDepth(TreeNode treeNode) {
        if(treeNode.val==0) {
            return 0;
        }else {
            int left=maxDepth(treeNode.left);
            int right=maxDepth(treeNode.right);
            int max=Math.max(left,right)+1;
            return max;
        }

    }
}
