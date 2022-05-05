package leetCode.剑指Offer;

import java.util.ArrayList;
import java.util.List;

public class 剑指Offer_027_回文链表 {

    /**
     * 线性表
     * */
    private boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();
        ListNode node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        int first = 0,tail = list.size()-1;
        while(first < tail){
            if (list.get(first).equals(list.get(tail))){
                first++;
                tail--;
            }else{
                return false;
            }
        }
        return true;
    }

    /**
     * 快慢指针+反转链表
     * */
    private boolean isPalindrome1(ListNode head){
        if (head==null){
            return true;
        }
        //找到前半部分链表
        ListNode firstHalf = middleNode(head);
        //反转后半部分链表
        ListNode endHalf = receiverList(firstHalf.next);
        ListNode l1 = head,l2=endHalf;
        boolean result = true;
        while(result&&l2!=null){
            if (l1.val!=l2.val){
                result = false;
            }
            l1=l1.next;
            l2=l2.next;
        }
        //还原链表
        firstHalf.next= receiverList(endHalf);
        return result;
    }


    /**
     * 反转链表
     * */
    private ListNode receiverList(ListNode head) {
        ListNode prev = null,cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next=prev;
            prev = cur;
            cur=next;
        }
        return prev;

    }

    /**
     * 快慢指针寻找中间节点
     * */
    private ListNode middleNode(ListNode head) {
        ListNode slow = head,fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

}
