package leetCode.剑指Offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class 剑指Offer_025_链表中的两数相加 {

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<Integer>();
        Deque<Integer> stack2 = new ArrayDeque<Integer>();
        while(l1!=null){
            stack1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            stack2.push(l2.val);
            l2=l2.next;
        }
        ListNode res =null;
        int carry=0;
        while(!stack1.isEmpty() || !stack2.isEmpty()||carry!=0){
            int a = stack1.isEmpty()?0:stack1.pop();
            int b = stack2.isEmpty()?0:stack2.pop();
            int cur = a+b+carry;
            carry=cur/10;
            cur%=10;
            ListNode curNode = new ListNode(cur);
            curNode.next=res;
            res = curNode;
        }
        return res;
    }

}
