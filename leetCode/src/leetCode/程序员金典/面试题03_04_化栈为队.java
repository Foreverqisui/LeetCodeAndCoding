package leetCode.程序员金典;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;



/**
 * 实现一个MyQueue类，该类用两个栈来实现一个队列。
 * */
public class 面试题03_04_化栈为队 {
    public static void main(String[] args) {

    }
    class MyQueue {

        Deque<Integer> stack;
        Deque<Integer> headStack;
        /** Initialize your data structure here. */
        public MyQueue() {
            stack = new ArrayDeque<Integer>();
            headStack = new ArrayDeque<Integer>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (headStack.isEmpty()) {
                poll(stack);
            }
            return headStack.pop();
        }

        private void poll(Deque<Integer> stack) {
            while (!stack.isEmpty()){
                headStack.push(stack.pop());
            }
        }

        /** Get the front element. */
        public int peek() {
            while(headStack.isEmpty()){
                poll(stack);
            }
            return headStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack.isEmpty()&&headStack.isEmpty();
        }
    }
}
