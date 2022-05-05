package leetCode.剑指Offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * 输出：22
 * 解释：
 * 该算式转化为常见的中缀算术表达式为：
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * */
public class 剑指Offer_036_后缀表达式 {
    public static void main(String[] args) {
        String [] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
        System.out.println(evalRPN1(tokens));
    }
    /**
     * 栈
     * */
    private static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            }else{
                //后面的数
                int num2 = stack.pop();
                //前面的数
                int num1 = stack.pop();
                switch(token){
                    case "+":
                        stack.push(num2+num1);
                        break;
                     case "-":
                         stack.push(num1-num2);
                         break;
                      case "*":
                          stack.push(num2*num1);
                          break;
                        case "/":
                            stack.push(num1/num2);
                            break;
                    default:
                }
            }
        }
        return stack.pop();
    }
    private static boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
    /**
     * 用数组模拟栈
     * */
    private static int evalRPN1(String[] tokens) {
        int [] stack = new int[tokens.length/2+1];
        int index = -1;
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            switch(token){
                case "+":
                    index--;
                    stack[index]+=stack[index+1];
                    break;
                case "-":
                    index--;
                    stack[index]-=stack[index+1];
                    break;
                 case "*":
                     index--;
                     stack[index]*=stack[index+1];
                     break;
                  case "/":
                      index--;
                      stack[index]/=stack[index+1];
                      break;
                default:
                    index++;
                    stack[index]=Integer.parseInt(token);
            }
        }
        return stack[index];
    }
}
