package leetCode.树;




/**
 * 平衡二叉树
 * */
public class leetCode_110_平衡二叉树 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode();
        System.out.println(isBalanced(root));
    }

    private static boolean isBalanced(TreeNode root) {
            if (root==null) {
                return true;
            }else {
                return Math.abs(heigh(root.left)-heigh(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);
            }

    }

    private static int heigh(TreeNode root) {
        if (root==null){
            return 0;
        }else {
            return Math.max(heigh(root.left),heigh(root.right))+1;
        }

    }
}
