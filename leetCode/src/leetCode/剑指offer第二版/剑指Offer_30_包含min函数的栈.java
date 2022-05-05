package leetCode.剑指offer第二版;

import java.util.Stack;

public class 剑指Offer_30_包含min函数的栈 {

    class MinStack {

        //构建两个栈
        // A栈负责正常的 pop push top操作
        // B栈负责在栈顶维护最小值
        Stack<Integer> A,B;

        public MinStack() {
            A = new Stack<Integer>();
            B = new Stack<Integer>();
        }

        public void push(int x) {
            A.push(x);
            //判断B中栈顶元素是否大于等于x，以此在栈顶维护最小值
            if (B.isEmpty()||B.peek()>=x){
                B.push(x);
            }
        }

        public void pop() {
            //如果弹出元素为最小值，则两边都进行弹出操作
            if (A.pop().equals(B.peek())){
                B.pop();
            }
        }

        public int top() {
            //返回A的栈顶元素
            return A.peek();
        }

        public int min() {
            //返回B的栈顶元素
            return B.peek();
        }
    }

}
