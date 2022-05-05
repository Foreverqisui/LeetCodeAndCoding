package leetCode.剑指Offer;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 设计一个用完全二叉树初始化的数据结构 CBTInserter，它支持以下几种操作：
 * <p>
 * CBTInserter(TreeNode root) 使用根节点为 root 的给定树初始化该数据结构；
 * CBTInserter.insert(int v)  向树中插入一个新节点，节点类型为  TreeNode，值为 v 。
 * 使树保持完全二叉树的状态，并返回插入的新节点的 父节点 的值；
 * CBTInserter.get_root() 将返回树的根节点。
 * <p>
 * 输入：inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
 * 输出：[null,1,[1,2]]
 */

public class 剑指Offer_043_往完全二叉树添加节点 {

    /**
     * 双端队列模拟
     */
    class CBTInserter {
        TreeNode root;
        Deque<TreeNode> deque;

        public CBTInserter(TreeNode root) {
            //初始化双端队列
            this.root = root;
            deque = new LinkedList<>();
            //初始化普通队列 并将根节点放入
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            //遍历根节点 放入双端队列里 以放入头或者尾部 模拟二叉树
            while (!queue.isEmpty()) {
                //检索根节点 并删去
                TreeNode node = queue.poll();
                //以末尾元素作为根节点 向前延伸
                if (node.left == null || node.right == null) {
                    deque.offerLast(node);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        //向树中插入一个新节点，节点类型为  TreeNode，值为 v
        // 使树保持完全二叉树的状态，并返回插入的新节点的 父节点 的值；
        public int insert(int v) {
            TreeNode node = deque.peekFirst();
            //将值放在末尾
            deque.offerLast(new TreeNode(v));
            //判断插入左右节点
            if (node.left == null) {
                node.left = deque.peekLast();
            }else{
                node.right = deque.peekLast();
                //左右节点已满 不能插入 则可以删去
                deque.pollFirst();
            }
            //返回父节的值
            return node.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }

}
