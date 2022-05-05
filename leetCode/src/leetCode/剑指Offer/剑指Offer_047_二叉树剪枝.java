package leetCode.剑指Offer;

/**
 * 给定一个二叉树 根节点 root ，树的每个节点的值要么是 0，要么是 1。请剪除该二叉树中所有节点的值为 0 的子树。
 * <p>
 * 节点 node 的子树为 node 本身，以及所有 node 的后代。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,null,0,0,1]
 * 输出: [1,null,0,null,1]
 */
public class 剑指Offer_047_二叉树剪枝 {
    private TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    /**
    * 递归：

     我们用 containsOne(node) 函数来判断以 node 为根的子树中是否包含 1，
     其不包含 1 当且仅当以 node 的左右孩子为根的子树均不包含 1，并且 node 节点本身的值也不为 1。
     如果 node 的左右孩子为根的子树不包含 1，那我们就需要把对应的指针置为空。
     例如当 node 的左孩子为根的子树不包含 1 时，我们将 node.left 置为 null。
     在递归结束之后，如果整颗二叉树都不包含 1，那么我们返回 null，否则我们返回原来的根节点。

    * */
    private boolean containsOne(TreeNode root) {
        if (root == null) {
            return false;
        }
        //递归了啊
        boolean a1 = containsOne(root.left);
        boolean a2 = containsOne(root.right);
        //如果树上不包含1 则置空
        if (!a1) {
            root.left = null;
        }
        if (!a2){
            root.right=null;
        }
        return root.val==1||a1||a2;
    }
}
