package leetCode.程序员金典;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 面试题02_01_移除重复节点 {

    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode dummy = head;
        Set<Integer> set = new HashSet<Integer>();
        set.add(head.val);
        while (dummy.next != null) {
            //下一个节点的值
            ListNode cur = dummy.next;
            //如果可以加入 就正常移动
            if (set.add(cur.val)) {
                dummy = dummy.next;
            } else {
            // 不可以，就删除
                dummy.next = dummy.next.next;
            }
        }
        dummy.next = null;
        return head;
    }
}
