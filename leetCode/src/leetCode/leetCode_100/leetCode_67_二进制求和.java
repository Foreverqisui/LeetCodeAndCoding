package leetCode.leetCode_100;

public class leetCode_67_二进制求和 {
    public static void main(String[] args) {
        String a ="1111";
        String b ="1111";
        System.out.println(addBinary(a,b));
    }
    /**
     * 如果sum==2则代表两数应该进位
     * sum%2==2 时就意味着此时该进位
     * 此时字符串拼接等于0的部分，并且此时carry==1 在拼上1 完成进位
     * 如果不是这样 则每次拼接1或0 以此反复 完成拼接
     * */
    private static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        //Google immutability or string vs stringbuilder if you don't know why we use this instead of regular string
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        //two pointers starting from the back, just think of adding two regular ints from you add from back
        while (i >= 0 || j >= 0) {
            int sum = carry;
            //if there is a carry from the last addition, add it to carry
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            //we subtract '0' to get the int value of the char from the ascii
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            sb.append(sum % 2);
            //if sum==2 or sum==0 append 0 cause 1+1=0 in this case as this is base 2 (just like 1+9 is 0 if adding ints in columns)
            carry = sum / 2;
            //if sum==2 we have a carry, else no carry 1/2 rounds down to 0 in integer arithematic
        }
        if (carry != 0) {
            sb.append(carry);
        }
        //leftover carry, add it
        return sb.reverse().toString();
    }
}
