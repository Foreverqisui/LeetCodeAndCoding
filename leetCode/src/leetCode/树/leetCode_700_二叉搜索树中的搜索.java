package leetCode.树;

public class leetCode_700_二叉搜索树中的搜索 {

    private static TreeNode searchBST(TreeNode root, int val) {
        if (root == null){
            return null;
        }
        if (root.val==val){
            return root;
        }
        return searchBST(val<root.val?root.left:root.right,val);
    }
}
