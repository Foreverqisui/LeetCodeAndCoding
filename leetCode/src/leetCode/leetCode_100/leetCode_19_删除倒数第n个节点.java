package leetCode.leetCode_100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 删除倒数第n个节点
 * */
public class leetCode_19_删除倒数第n个节点 {
    public static void main(String[] args) {
        ListNode listNode=new ListNode();
        int n=3;
        System.out.println(removeNthFromEnd(listNode,n));
        System.out.println(removeNthFromEnd1(listNode,n));
    }
    //双指针
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow=head;
        ListNode dumy=new ListNode(0,head);
        ListNode fast=dumy;
        for (int i = 0; i < n; i++) {
            slow=slow.next;
        }
        while(slow!=null){
            slow=slow.next;
            fast=fast.next;
        }
        fast.next=fast.next.next;
        ListNode ans=dumy.next;
        return ans;
    }

    //栈
    private static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy=new ListNode(0,head);
        Deque<ListNode> stack=new LinkedList<ListNode>();
        ListNode cur=dummy;
        while(cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode prev=stack.peek();
        prev.next=prev.next.next;
        ListNode ans=dummy.next;
        return ans;
    }

}
