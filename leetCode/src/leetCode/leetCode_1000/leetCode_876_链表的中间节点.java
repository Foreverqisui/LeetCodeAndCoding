package leetCode.leetCode_1000;


/**
 * 链表的中间节点
 * */
public class leetCode_876_链表的中间节点 {
    public static void main(String[] args) {
        ListNode listNode=new ListNode(1234);
        System.out.println(middleNode(listNode));
    }

    //双指针
    private static ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
