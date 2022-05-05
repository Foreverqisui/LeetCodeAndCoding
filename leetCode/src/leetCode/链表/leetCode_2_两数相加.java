package leetCode.链表;

public class leetCode_2_两数相加 {
    public static void main(String[] args) {

    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * @param carry:代表是否有进位的值
         * @param sum:加上进位值之后的总和
         * */
        //定义前置节点
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        //判断条件：l1和l2都为null时结束
        while (l1 != null || l2 != null) {
            //分别判断
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            //除10代表开头数字（进位） ，模10代表结尾数字（剩余进入链表位置）
            carry = sum / 10;
            sum = sum % 10;
            //把值放入下一个节点
            cur.next = new ListNode(sum);
            //调动指针向下走
            cur = cur.next;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!= null){
                l2=l2.next;
            }
            }
        //到最后 进1
        if(carry==1){
            cur.next=new ListNode(carry);
        }
        return pre.next;

    }
}
