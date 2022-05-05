package leetCode.链表;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class leetCode_160_相交链表 {
    public static void main(String[] args) {
        ListNode listNodeA = new ListNode(5);
        ListNode listNodeB = new ListNode(5);
        System.out.println(getIntersectionNode(listNodeA, listNodeB));
        System.out.println(getIntersectionNode1(listNodeA, listNodeB));
    }

    /**
     * 双指针
     *
     *  a1 → a2 → a3
     *                    ↘ a
     *                      c1 → c2 → c3 → null
     *                    ↗ b
     *  b1 → b2 → b3
     *  Since a == b is true, end loop while(a != b),
     *  return the intersection node a = c1.
     * */
    private static ListNode getIntersectionNode1(ListNode listNodeA, ListNode listNodeB) {
        ListNode a = listNodeA;
        ListNode b = listNodeB;
        while (a != b) {
            a = a == null ? listNodeB : a.next;
            b = b == null ? listNodeA : b.next;
        }
        return a;
    }


    /**
     * 哈希表
     * 通过哈希表存储链表，用contains对比两个链表，最后找到相交链表
     */
    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            set.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
