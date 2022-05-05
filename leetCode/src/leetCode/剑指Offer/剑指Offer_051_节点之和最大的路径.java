package leetCode.剑指Offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给定一个二叉树的根节点 root ，返回其 最大路径和，即所有路径上节点值之和的最大值。
 *
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * */
public class 剑指Offer_051_节点之和最大的路径 {
    int res = Integer.MIN_VALUE;
    private int maxPathSum(TreeNode root) {
        maxGain(root);
        return res;

    }
    private int maxGain(TreeNode node){
        if (node==null){
            return 0;
        }
        //当大于0的时候，才会用
        //求左侧最大值
        int leftGain = Math.max(maxGain(node.left),0);
        //求右侧最大值
        int rightGain = Math.max(maxGain(node.right),0);
        //递归左右节点的最大贡献值
        int preSum = leftGain+rightGain+node.val;
        //结果值
        res = Math.max(res,preSum);
        //返回节点的最大贡献值
        return node.val+Math.max(leftGain,rightGain);
    }
}
