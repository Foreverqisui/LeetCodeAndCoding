package leetCode.剑指offer第二版;

/**
 * @author foreverqisui
 */
public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int val) {
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public Node(int val, Node prev, Node next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }

    public Node(int val, Node prev, Node next, Node child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }


}
