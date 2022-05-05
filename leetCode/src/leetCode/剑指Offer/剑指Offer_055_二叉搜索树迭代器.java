package leetCode.剑指Offer;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
 *
 *     BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root 会作为构造函数的一部分给出。指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
 *     boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
 *     int next()将指针向右移动，然后返回指针处的数字。
 *
 * 输入
 * inputs = ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
 * inputs = [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
 * 输出
 * [null, 3, 7, true, 9, true, 15, true, 20, false]
 *
 * */
public class 剑指Offer_055_二叉搜索树迭代器 {

    class BSTIterator {
        TreeNode cur;
        Deque<TreeNode> stack;
        public BSTIterator(TreeNode root) {
            cur = root;
            stack= new LinkedList<>();
        }

        public int next() {
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur=stack.pop();
            int res = cur.val;
            cur = cur.right;
            return res;
        }

        public boolean hasNext() {
            return cur!=null||!stack.isEmpty();
        }
    }
}
