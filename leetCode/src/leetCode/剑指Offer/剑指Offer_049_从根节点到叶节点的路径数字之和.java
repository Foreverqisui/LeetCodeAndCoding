package leetCode.剑指Offer;

/**
 * 给定一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * <p>
 * 每条从根节点到叶节点的路径都代表一个数字：
 * <p>
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * <p>
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * <p>
 * 叶节点 是指没有子节点的节点。
 * <p>
 * 输入：root = [1,2,3]
 * 输出：25
 * 解释：
 * 从根到叶子节点路径 1->2 代表数字 12
 * 从根到叶子节点路径 1->3 代表数字 13
 * 因此，数字总和 = 12 + 13 = 25
 */
public class 剑指Offer_049_从根节点到叶节点的路径数字之和 {

    private int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    private int dfs(TreeNode node,int res){
        if (node==null){
            return 0;
        }
        int temp = res*10+node.val;
        if (node.left==null&&node.right==null){
            return temp;
        }else{
           return dfs(node.left,temp)+dfs(node.right,temp);
        }
    }
}
