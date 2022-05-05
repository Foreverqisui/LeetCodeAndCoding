package leetCode.递归;

/**
 * 合并两个有序链表
 */
class leetCode_21 {
    public static void main(String[] args) {
        ListNode a=new ListNode(123);
        ListNode b=new ListNode(456);
        System.out.println(mergeListNode(a,b));
    }
    public static ListNode mergeListNode(ListNode listNode, ListNode listNode1){
        if (listNode==null){
            return listNode1;
        }
        if (listNode1==null){
            return listNode;
        }
        if (listNode.val<listNode1.val){
            listNode.next=mergeListNode(listNode.next,listNode1);
            return listNode;
        }else {
            listNode1.next=mergeListNode(listNode1.next,listNode);
            return listNode1;
        }
    }
}

 class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) {
        val = x;
    }
}

