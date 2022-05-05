package leetCode.leetCode_100;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 */
public class leetCode_25_K个一组翻转链表 {

    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            //将两个节点的位置 都指向同一地址空间上
            ListNode prev = dummy;
            ListNode end = dummy;
            //整个遍历开始 循环边界判断
            while (end.next != null) {
                //每k个一次循环
                for (int i = 0; i < k && end != null; i++) {
                    //移动节点
                    end = end.next;
                }
                //不满足k的长度
                if (end == null) {
                    break;
                }
                //对节点进行赋值
                ListNode start = prev.next;
                ListNode next = end.next;
                //断开 尾指针和后面的联系
                end.next = null;
                //指针指向翻转之后的节点
                prev.next = reverser(start);
                //此时start在末尾 连接上被断开的链表节点
                start.next = next;
                //都来到尾结点 准备进行下一次循环
                prev = start;
                end = prev;
            }
            return dummy.next;
        }

        public ListNode reverser(ListNode head) {
            ListNode prev = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return prev;
        }
    }
}
