package leetCode.剑指Offer;


public class 剑指Offer_028_展平多级双向链表 {


    /**
     * 一dfs
     * */
    private Node flatten1(Node head) {
        dfs(head);
        return head;
    }

    public Node dfs(Node node) {
        Node cur = node;
        // 记录链表的最后一个节点
        Node last = null;

        while (cur != null) {
            Node next = cur.next;
            //  如果有子节点，那么首先处理子节点
            if (cur.child != null) {
                Node childLast = dfs(cur.child);

                next = cur.next;
                //  将 node 与 child 相连
                cur.next = cur.child;
                cur.child.prev = cur;

                //  如果 next 不为空，就将 last 与 next 相连
                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }

                // 将 child 置为空
                cur.child = null;
                last = childLast;
            } else {
                last = cur;
            }
            cur = next;
        }
        return last;
    }


    /**
     * 迭代
     * */
    private Node flatten(Node head) {
        Node dummy = new Node(0);
        dummy.next=head;
        for(;head!=null;head=head.next){
            if (head.child!=null){
                Node tmp = head.next;
                Node child = head.child;
                head.next=child;
                child.prev=head;
                head.child=null;
                Node last = head;
                while(last.next!=null){
                    last = last.next;
                }
                last.next=tmp;
                if (tmp!=null){
                    tmp.prev=last;
                }
            }
        }
        return dummy.next;
    }
}
