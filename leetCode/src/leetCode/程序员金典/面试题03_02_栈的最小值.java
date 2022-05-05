package leetCode.程序员金典;

import java.util.*;

/**
 * 面试题 03.02. 栈的最小值
 * <p>
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。
 * 执行push、pop和min操作的时间复杂度必须为O(1)。
 */
public class 面试题03_02_栈的最小值 {
    public static void main(String[] args) {

    }

    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            stack.push(x);
            minStack.push(Math.min(x,minStack.peek()));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin(){
            return minStack.peek();
        }
    }

}
