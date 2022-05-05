package leetCode.leetCode_1000;

import java.util.ArrayList;
import java.util.List;

public class leetCode_590_N叉树的后序遍历 {

    class Solution{
        List<Integer> res;

        private List<Integer> postorder(Node root) {
            res = new ArrayList<Integer>();
            dfs(root);
            return res;
        }
        private void dfs(Node root) {
            if(root==null){
                return;
            }
            for(Node nodes:root.children){
                dfs(nodes);
            }
            res.add(root.val);
        }
    }

}
