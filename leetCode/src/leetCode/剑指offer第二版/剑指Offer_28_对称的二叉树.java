package leetCode.剑指offer第二版;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * 示例 1：
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 */
public class 剑指Offer_28_对称的二叉树 {
    private boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        //递归调用
        return isMiro(root.left, root.right);
    }

    public boolean isMiro(TreeNode L, TreeNode R) {
        if (L == null && R == null) {
            return true;
        }
        if (L == null || R == null || L.val != R.val) {
            return false;
        }
        return isMiro(L.left, R.right) && isMiro(L.right, R.left);
    }
}

