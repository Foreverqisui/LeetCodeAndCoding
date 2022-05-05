package leetCode.leetCode_1000;



/**
 * 合并二叉树
 * */
public class leetCode_617_合并二叉树 {

    public static void main(String[] args) {

    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1==null){
                return root2;
            }
            if (root2==null){
                return root1;
            }
            TreeNode treeNode=new TreeNode(root1.val+root2.val);
            treeNode.left=mergeTrees(root1.left,root2.left);
            treeNode.right=mergeTrees(root1.right,root2.right);
            return treeNode;
    }

}

