package leetCode.剑指Offer;

/**
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，
 * 求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，
 * 但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 示例 1：
 *
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * */

public class 剑指Offer_050_向下的路径节点之和 {




    /**
     * dfs枚举所有可能的节点
     * n2复杂度
     * */
    private int pathSum(TreeNode root, int targetSum) {
        if (root==null){
            return 0;
        }
        //从根节点开始遍历 找到从根节点开始的所有的
        int res = dfs(root,targetSum);
        //从左节点开始遍历 转换根节点成左节点
        res+=pathSum(root.left,targetSum);
        ///从右节点开始遍历 转换根节点成右节点
        res+=pathSum(root.right,targetSum);
        return res;
    }
    private int dfs(TreeNode root, int targetSum){
        //将结果值归0
        int res = 0;

        int val = root.val;
        if (val==targetSum){
            res+=1;
        }
        //左节点上满足要求的值
        res += dfs(root.left,targetSum-val);
        //右节点上满足要求的值
        res += dfs(root.right,targetSum-val);
        return res;
    }
}
