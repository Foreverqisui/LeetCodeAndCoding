package leetCode.链表;

public class leetCode_203_移除链表元素 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        System.out.println(removeElements(listNode, 3));
        System.out.println(removeElements1(listNode,4));
    }

    /**
     * 迭代
     * */
    private static ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }
    /**
     * 递归
     * */
    private static ListNode removeElements1(ListNode listNode, int i) {
        if (listNode == null){return null;}
        listNode.next = removeElements(listNode.next, i);
        return listNode.val == i ? listNode.next : listNode;
    }
}
