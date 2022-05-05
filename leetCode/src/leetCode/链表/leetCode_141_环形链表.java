package leetCode.链表;

import org.w3c.dom.Node;

import java.util.HashSet;
import java.util.Set;

public class leetCode_141_环形链表 {
    public static void main(String[] args) {
        ListNode list = new ListNode(3);
        System.out.println(hasCycle(list));
        System.out.println(hasCycle1(list));
    }

    /**
     * 快慢指针
     * 通过快指针每次走两步，慢指针每次走一步，进行套圈，直到fast==slow，变成环形链表
     * */

    private static boolean hasCycle1(ListNode head) {
        if (head==null||head.next==null) {return false;}
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow!=fast){
            if (fast==null||fast.next==null){return false;}
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 哈希表
     * 存储节点，利用add方法，判断是否为环形链表
     * set.add()
     * Adds the specified element to this set if it is not already present.
     * More formally, adds the specified element e to this set if this set contains no element e2 such that (e==null ? e2==null : e.equals(e2)).
     * If this set already contains the element, the call leaves the set unchanged and returns false.
     * */
    private static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        while (head != null) {
            if (!set.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
