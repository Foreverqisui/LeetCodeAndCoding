package leetCode.剑指offer第二版;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * <p>
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 */
public class 剑指Offer_07_重建二叉树 {

    class Solution {

        private Map<Integer, Integer> index;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            //前序的顺序 -- 根左右
            //中序的顺序 -- 左根右
            //后序的顺序 -- 右根左
            index = new HashMap<Integer, Integer>();
            int len = preorder.length;
            for (int i = 0; i < len; i++) {
                index.put(inorder[i], i);
            }
            return myBuildTree(preorder, inorder, 0, len - 1, 0, len - 1);
        }

        private TreeNode myBuildTree(int[] preorder, int[] inorder, int pre_left,
                                     int pre_right, int ino_left, int ino_right) {
            //递归终止条件
            if (pre_left>pre_right){
                return null;
            }
            //前序遍历最左边的是根节点
            int pre_root = pre_left;
            //在中序遍历中找到根节点
            int ino_root = index.get(preorder[pre_root]);
            //创建根节点
            TreeNode root = new TreeNode(preorder[pre_root]);
            //确定左子树长度
            int leftSize = ino_root - ino_left;
            //递归左子树
            // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素
            // 就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
            root.left = myBuildTree(preorder,inorder,pre_left+1,
                                    leftSize+pre_left,ino_left,ino_root-1);
            //递归右子树
            // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素
            // 就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
            root.right = myBuildTree(preorder, inorder, pre_left + leftSize + 1,
                                     pre_right, ino_root + 1, ino_right);
            return root;
        }
    }

}
