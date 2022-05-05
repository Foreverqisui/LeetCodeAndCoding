package leetCode.leetCode_500;

import java.util.LinkedList;
import java.util.Queue;

public class leetCode_116_填充每个节点的下一个右侧节点指针 {
    public static void main(String[] args) {
        Node root = new Node();
        System.out.println(connect(root));
    }

    private static Node connect(Node root) {
        if(root ==null) return null;
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                Node node=queue.poll();
                if (i<size-1){
                    node.next=queue.peek();
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
        }
            return root;
    }
}
