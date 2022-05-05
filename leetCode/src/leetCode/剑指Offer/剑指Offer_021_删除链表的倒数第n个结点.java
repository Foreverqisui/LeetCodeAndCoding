package leetCode.剑指Offer;

import java.util.LinkedList;
import java.util.List;

public class 剑指Offer_021_删除链表的倒数第n个结点 {
    public static void main(String[] args) {

    }
    /**
     * 双指针
     * */
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode res = dummy.next;
        return res;
    }
    /**
     * 计算链表长度
     * */
    private static ListNode removeNthFromEnd1(ListNode head,int n){
        ListNode dummy = new ListNode(0,head);
        int len = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < len - n + 1; i++) {
            cur=cur.next;
        }
        cur.next = cur.next.next;
        ListNode res = dummy.next;
        return res;
    }
    private static int getLength(ListNode head){
        int len = 0;
        while(head!=null){
            ++len;
            head = head.next;
        }
        return len;
    }
}
