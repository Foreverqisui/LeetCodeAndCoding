package leetCode.剑指Offer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * */
public class 剑指Offer_077_链表排序 {

    public ListNode sortList(ListNode head) {
        //题目要求：排序链表
        //题目分析：一个点是怎样排序 --> 根据时间复杂度要求在nlogn可以想到二分
        //二分--进而可以想到归并排序
        //调用函数递归
        return sortList(head,null);

    }

    private ListNode sortList(ListNode head, ListNode tail) {
        //超前步 -- 边界判断
        if (head==null){
            return head;
        }
        if (head.next==tail){
            head.next=null;
            return head;
        }
        //首先第一步 找到中间点--快慢指针
        ListNode slow = head,fast = head;
        while(fast!=tail){
            slow=slow.next;
            fast=fast.next;
            if (fast!=tail){
                fast=fast.next;
            }
        }
        //此时可以判断出mid 为slow 调用函数进行归并
        ListNode left = sortList(head,slow);
        //右边
        ListNode right = sortList(slow,tail);
        //归并
        ListNode res = merge(left,right);
        return res;
    }

    private ListNode merge(ListNode left, ListNode right) {
        //归并操作 通过比较大小 进行合并
        ListNode res = new ListNode(0);
        //
        ListNode temp = res,tl=left,tr=right;
        //比较流程--小的在前面
        //首先在两个都不为空的时候进行比较
        while(tl!=null||tr!=null){
            //左边的小于等于右边的 原地不动 移动指针
            if (tl.val<=tr.val){
                temp.next=tl;
                tl=tl.next;
            }else{
                //右边大 左边小
                temp.next=tr;
                tr=tr.next;
            }
            //移动结果指针
            temp = temp.next;
        }
        //其次两者有一个为空的时候
        if(tr!=null){
            temp.next = tr;
        }else if(tl!=null){
            temp.next = tl;
        }
        return res.next;
    }
}
