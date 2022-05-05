package leetCode.剑指offer第二版;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 */
public class 剑指Offer_18_删除链表的节点 {

    private static ListNode deleteNode(ListNode head, int val) {
        //删除的是头节点
        if(head.val == val) {
            return head.next;
        }
        ListNode pre = head, cur = head.next;
        //迭代寻找符合要求的节点
        while(cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        //退出循环的值 且 不等于null 一定为目标值，进行删除
        if(cur != null) {
            pre.next = cur.next;
        }
        return head;
    }
}
