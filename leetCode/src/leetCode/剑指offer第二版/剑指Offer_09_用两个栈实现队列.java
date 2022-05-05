package leetCode.剑指offer第二版;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * */
public class 剑指Offer_09_用两个栈实现队列 {
    class CQueue {
        Stack<Integer> stackInto;
        Stack<Integer> stackDelete;
        public CQueue() {
            stackInto = new Stack<Integer>();
            stackDelete = new Stack<Integer>();
        }

        public void appendTail(int value) {
            stackInto.push(value);
        }

        public int deleteHead() {
            if (stackDelete.isEmpty()){
                while(!stackInto.isEmpty()) {
                    stackDelete.push(stackInto.pop());
                }
            }
            if (stackDelete.isEmpty()){
                return -1;
            }else{
                int res = stackDelete.pop();
                return res;
            }
        }
    }
}
