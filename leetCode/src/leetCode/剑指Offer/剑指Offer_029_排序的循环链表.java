package leetCode.剑指Offer;

public class 剑指Offer_029_排序的循环链表 {

    /**
     * head = [3,4,1], insertVal = 2
     * 指针随机 那就遍历所有 变成环形
     * */
    private Node insert(Node head, int insertVal) {
        if (head==null){
            Node node = new Node(insertVal);
            node.next=node;
            return node;
        }
        Node cur = head;
        while(cur.next!=head){
            if (cur.next.val<cur.val){
                if (cur.next.val>=insertVal){
                    //有序 所以大于的情况下，代表插入值在cur和cur.next的中间
                    break;
                }else if (cur.val<=insertVal){
                    //证明在头节点前插入
                    break;
                }
            }
            //中间顺序插入
            if (cur.val<=insertVal&&cur.next.val>=insertVal){
                break;
            }
            //移动指针
            cur=cur.next;
        }
        //插入新节点
        cur.next=new Node(insertVal,cur.next);
        return head;
    }
}
