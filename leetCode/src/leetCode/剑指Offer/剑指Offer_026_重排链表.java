package leetCode.剑指Offer;

import java.util.ArrayList;
import java.util.List;

public class 剑指Offer_026_重排链表 {

    /**
     * 线性表
     * */
    private void reorderList(ListNode head) {
        if (head == null){
            return;
        }
        List<ListNode> newList = new ArrayList<>();
        ListNode node = head;
        while(node!=null){
            newList.add(node);
            node=node.next;
        }
        int left = 0,right = newList.size()-1;
        while(left<right){
            newList.get(left).next = newList.get(right);
            left++;
            if (left==right){
                break;
            }
            newList.get(right).next = newList.get(left);
            right--;
        }
        newList.get(left).next=null;
    }


    /**
     * 寻找链表中点 + 链表逆序 + 合并链表
     * */
    private void reorderList1(ListNode head){
        if (head==null) {
            return;
        }
        //通过快慢指针找到中间值 定义指针位置 反转 合并
        ListNode mid = middleNode(head);
        ListNode l1 = head,l2=mid.next;
        mid.next=null;
        l2=reverseList(l2);
        mergeList(l1,l2);
    }

    /**
     * 合并链表
     * */
    private void mergeList(ListNode l1, ListNode l2) {
        ListNode l1Tmp;
        ListNode l2Tmp;
        while(l1!=null&&l2!=null){
            l1Tmp=l1.next;
            l2Tmp=l2.next;
            l1.next=l2;
            l1=l1Tmp;
            l2.next=l1;
            l2=l2Tmp;
        }
    }

    /**
     * 反转链表
     * */
    private ListNode reverseList(ListNode head) {
        ListNode prev = null,cur =head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }

    /**
     * 快慢指针寻找中间点
     * */
    private ListNode middleNode(ListNode head) {
        ListNode slow = head,fast = head;
        while(fast!=null&&fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
