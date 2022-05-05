package leetCode.树;

public class leetCode_701_二叉搜索树中的插入操作 {

    private TreeNode insertIntoBST(TreeNode root, int val) {
        //当root为空时，证明找到了合适的位置插入
        if (root==null) {
            return new TreeNode(val);
        }
        //如果树上的值大于val证明 val应该插入左子树 和其中元素反复交换 反之亦然
        if (root.val>val){
            root.left=insertIntoBST(root.left,val);
        }else{
            root.right=insertIntoBST(root.right,val);
        }
        return root;
    }
}
