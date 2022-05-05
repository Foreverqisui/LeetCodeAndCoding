package leetCode.链表;

/**
 * 删除链表中的重复元素
 */
class leetCode_83 {
    public static void main(String[] args) {
        ListNode1 l1=new ListNode1();
        l1.val=123;
        System.out.println(deleteDuplicates(l1));
    }
        public static ListNode1 deleteDuplicates(ListNode1 head){
        ListNode1 cur=head;
        while(cur!=null&&cur.next!=null){
            if (cur.val==cur.next.val){
                cur.next=cur.next.next;
            }else {
                cur=cur.next;
            }
        }
        return head;
        }
}

class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1() {
    }

    ListNode1(int val) {
        this.val = val;
    }

    ListNode1(int val, ListNode1 next) {
        this.val = val;
        this.next = next;
    }
}
