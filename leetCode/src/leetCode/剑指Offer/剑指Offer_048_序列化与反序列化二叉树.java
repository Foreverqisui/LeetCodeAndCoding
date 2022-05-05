package leetCode.剑指Offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 */
public class 剑指Offer_048_序列化与反序列化二叉树 {

    class Codec {

        // 序列化 dfs 前序遍历
        public String serialize(TreeNode root) {
            return rserialize(root, "");

        }

        private String rserialize(TreeNode root, String str) {
            //节点为空的位置拼接上Node
            //递归的终止条件
            if (root == null) {
                str += "Node,";
            } else {
                //进行前序遍历 递归
                str += str.valueOf(root.val) + ",";
                str += rserialize(root.left, str);
                str += rserialize(root.right, str);
            }
            return str;
        }

        //反序列化
        public TreeNode deserialize(String data) {
            String[] dataArray = data.split(",");
            List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
            return rdeserialize(dataList);

        }
        /**
         * 即我们可以先序遍历这颗二叉树，遇到空子树的时候序列化成 None，
         * 否则继续递归序列化。那么我们如何反序列化呢？首先我们需要根据 ,
         * 把原先的序列分割开来得到先序遍历的元素列表，然后从左向右遍历这个序列：
         *
         *     如果当前的元素为 None，则当前为空树
         *     否则先解析这棵树的左子树，再解析它的右子树
         * */
        private TreeNode rdeserialize(List<String> dataList) {
            //递归的终止条件
            if (dataList.get(0).equals("None")) {
                dataList.remove(0);
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
            dataList.remove(0);
            root.left = rdeserialize(dataList);
            root.right = rdeserialize(dataList);

            return root;
        }
    }

}
