package leetCode.剑指offer第二版;

import java.util.*;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class 剑指Offer_06_从尾到头打印链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode node = new ListNode(4);
        ListNode offer = new ListNode(3);
        head.next = node;
        node.next = offer;
        System.out.println(Arrays.toString(reversePrint(head)));
    }

    /**
     * 辅助栈
     * */
    private static int[] reversePrint(ListNode head) {
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode temp = head;

        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }
}
