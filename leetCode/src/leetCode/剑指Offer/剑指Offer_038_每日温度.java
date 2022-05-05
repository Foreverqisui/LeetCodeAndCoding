package leetCode.剑指Offer;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 */
public class 剑指Offer_038_每日温度 {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    private static int[] dailyTemperatures1(int[] temperatures){
        int len = temperatures.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int []res = new int[len];
        for (int i = 0; i < len; i++) {
            int temperature = temperatures[i];
            while(!stack.isEmpty()&&temperature>temperatures[stack.peek()]){
                int prev = stack.pop();
                res [prev] =i-prev;
            }
            stack.push(i);
        }
        return res;
    }



    /**
     * 超时了
     * */
    private static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (temperatures[j] > temperatures[i]) {
                    stack.push(j - i);
                    break;
                } else if (temperatures[j] <= temperatures[i] && j == len-1 ) {
                    stack.push(0);
                }
            }
        }
        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;

    }
}
