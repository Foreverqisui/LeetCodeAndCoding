package leetCode.leetCode_500;

public class leetCode_390_消除游戏 {
    public static void main(String[] args) {
        int n = 9;
        System.out.println(lastRemaining(n));
    }
    private static int lastRemaining(int n) {
            //定义变量left 来判断是正向遍历还是反向遍历
            boolean left = true;
            //设置步长 第一个数字的值
            int step = 1;
            int head = 1;
            //定义剩余长度
            int remaining = n;
            while (remaining>1){
                //因为要删除第一个head 如果偶数 则head不变 如果奇数 变成head+step
                if (left||remaining%2==1){
                    head = head + step;
                }
                step*=2;
                remaining/=2;
                left = !left;
            }
            return head;
    }
}
