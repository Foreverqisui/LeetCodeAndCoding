package leetCode.链表;

public class leetCode_237_删除链表中的节点 {
    public static void main(String[] args) {

    }
    private static void deleteNode(ListNode node) {
       node.val = node.next.val;
       node.next=node.next.next;
    }
}
