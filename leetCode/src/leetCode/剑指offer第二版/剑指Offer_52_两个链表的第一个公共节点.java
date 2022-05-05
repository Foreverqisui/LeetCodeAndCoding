package leetCode.剑指offer第二版;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 * */
public class 剑指Offer_52_两个链表的第一个公共节点 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headB==null||headA==null){
            return null;
        }
        ListNode a = headA,b=headB;
        while(a!=b){
            a = a==null? headB: a.next;
            b = b==null? headA: b.next;
        }
        return a;
    }
}
