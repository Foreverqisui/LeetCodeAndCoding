package leetCode.剑指Offer;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 输入：asteroids = [-2,-1,1,2]
 * 输出：[-2,-1,1,2]
 * 解释：-2 和 -1 向左移动，而 1 和 2 向右移动。 由于移动方向相同的行星不会发生碰撞，所以最终没有行星发生碰撞。
 * */
public class 剑指Offer_037_小行星碰撞 {
    public static void main(String[] args) {
        int [] asteroids={-2,-1,1,2};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }
    private static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int  ash:asteroids) {
            //// 当小行星向右移动并且它们比下一个小行星小
            while(!stack.isEmpty()&&stack.peek()>0&&stack.peek() < -ash){
                stack.pop();
            }
            //堆栈为空或小行星向左或与下一个小行星相同的方向
            if (stack.isEmpty()||stack.peek()<0||stack.peek()>0&&ash>0){
                stack.push(ash);
                //如果负正数值相等 则拿走
            }else if(stack.peek()==-ash){
                stack.pop();
            }
        }
        int [] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
