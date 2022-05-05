package leetCode.leetCode_1000;

import java.util.ArrayList;
import java.util.List;

public class leetCode_589_N叉树的前序遍历 {
    List<Integer> result;
    private List<Integer> preorder(Node root) {
        result = new ArrayList<Integer>();
        dfs(root);
        return result;
    }
    private void dfs(Node node){
        if (node==null){
            return;
        }
        result.add(node.val);
        for(Node nodes:node.children){
            dfs(nodes);
        }
    }

}

