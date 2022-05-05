package leetCode.树;



import java.util.*;

/**
 * 二叉树的中序遍历
 * 1.递归
 * 2.迭代
 * 3.Morris遍历算法
 */
public class leetCode_94_二叉树的中序遍历 {

    public List<Integer> inorderTraversal2(TreeNode root){
        //用来存储树的值
        List<Integer> result = new ArrayList<Integer>();
        if (root == null){return result;}
        //用来模拟树结构
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while(root != null||!stack.isEmpty()){
            //反复遍历左子树 当左节点为null时 遍历右子树
            while(root!=null){
                //将中间节点放入栈中
                stack.push(root);
                //走到左节点
                root = root.left;
            }
            //当左节点为空时 返回到中间父节点
            root = stack.pop();
            //将值加入到链表中
            result.add(root.val);
            //遍历右节点
            root = root.right;
        }
        return result;
    }

    /**
     * 迭代做法
     */

    public List<Integer> inorderTraversal1(TreeNode roo) {
        List<Integer> list1 = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        while (roo != null || !deque.isEmpty()) {
            while (roo != null) {
                deque.push(roo);
                roo = roo.left;
            }
            roo = deque.pop();
            list1.add(roo.val);
            roo=roo.right;
        }
        return list1;
    }

    /***
     *  递归做法
     */

    public List<Integer> inorderTraversal(TreeNode too) {
        List<Integer> list = new ArrayList<>();
        inorder(too, list);
        return list;
    }

    private void inorder(TreeNode too, List<Integer> list) {
        if (too == null) {
            return;
        }
        inorder(too.left, list);
        list.add(too.val);
        inorder(too.right, list);
    }
}

