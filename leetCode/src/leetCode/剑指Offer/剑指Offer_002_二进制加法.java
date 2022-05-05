package leetCode.剑指Offer;

public class 剑指Offer_002_二进制加法 {
    public static void main(String[] args) {
        String a = "1111";
        String b = "1111";
        System.out.println(addBinary(a, b));
    }

    private static String addBinary(String a, String b) {
        //定义结果变量 初始参数变量
        StringBuffer res = new StringBuffer();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while(i>=0||j>=0){
            int sum =carry;
            if(i>=0){
                sum+=a.charAt(i--)-'0';
            }
            if(j>=0){
                sum+=b.charAt(j--)-'0';
            }
            res.append(sum%2);
            carry=sum/2;
        }
        if (carry!=0) {
            res.append(carry);
        }
        return res.reverse().toString();
    }
}
