package leetCode.剑指Offer;

import java.util.HashSet;
import java.util.Set;

public class 剑指Offer_022_链表中环的入口节点 {
    public static void main(String[] args) {

    }
    /**
     * 双指针
     * */
    private static ListNode detectCycle(ListNode head) {
        ListNode slow=head,fast=head;
        while(true){
            if (fast==null||fast.next==null){
                return null;
            }
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow){
                break;
            }
        }
        fast = head;
        while(slow!=fast){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;

    }
    /**
     * 哈希表
     * */
    private static ListNode detectCycle1(ListNode head){
        ListNode res = head;
        Set<ListNode> set = new HashSet<ListNode>();
        while(res!=null){
            if (set.contains(res)){
                return res;
            }else{
                set.add(res);
            }
            res=res.next;
        }
        return null;
    }
}
