package leetCode.剑指Offer;

import java.util.HashSet;
import java.util.Set;

public class 剑指Offer_023_两个链表的第一个重合节点 {
    /**
     * 哈希表
     * */
    private  ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //判断两个链表是否有相交的 也就是判断两个链表是否有相等的
        Set<ListNode> set = new HashSet<ListNode>();
        ListNode a = headA;
        while (a != null) {
            set.add(a);
            a=a.next;
        }
        ListNode b = headB;
        while (b != null) {
            if (set.contains(b)) {
               return b;
            }
            b=b.next;
        }
        return null;
    }
    /**
     * 双指针
     * */
    private ListNode getIntersectionNode1(ListNode headA,ListNode headB) {
        ListNode pA=headA,pB=headB;
        if (pA==null || pB==null) {
            return null;
        }
        while(pA!=pB){
            pA=pA==null ? headB:pA.next;
            pB=pB==null ? headA:pB.next;
        }
        return pA;
    }
}
