package leetCode.leetCode_500;

import java.util.ArrayList;
import java.util.List;

public class leetCode_234_回文链表 {
    public static void main(String[] args) {

    }

    private static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}
