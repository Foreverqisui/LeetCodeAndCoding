package leetCode.leetCode_1000;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * 示例 1：
 *
 * 输入: root = [5,3,6,2,4,null,7], k = 9
 * 输出: true
 * */
public class leetCode_653_两数之和_输入BST {

    class Solution {
        Set<Integer> set = new HashSet<>();
        public boolean findTarget(TreeNode root, int k) {
            if(root==null){
                return false;
            }
            if(set.contains(k-root.val)){
                return true;
            }
            set.add(root.val);
            return findTarget(root.left,k) || findTarget(root.right,k);
        }
    }
}
