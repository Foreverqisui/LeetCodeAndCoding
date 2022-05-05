package leetCode.链表;



public class leetCode_206_反转链表 {
    public static void main(String[] args) {
        ListNode listNode=new ListNode(3);
        System.out.println(listNode);

    }
    private static ListNode reverseList(ListNode head) {
            ListNode pre=null;
            ListNode cur=head;
            while(cur!=null){
                ListNode temp=cur.next;
                cur.next=pre;
                pre=cur;
                cur=temp;
            }
            return pre;
    }
}

