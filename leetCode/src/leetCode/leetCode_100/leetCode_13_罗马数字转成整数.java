package leetCode.leetCode_100;

/**
 * 罗马数字转成整数
 */
public class leetCode_13_罗马数字转成整数 {
    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt2("IV"));
    }

    public static int romanToInt(String s) {
        s=s.replace("IV","a");
        s=s.replace("IX","b");
        s=s.replace("XL","c");
        s=s.replace("XC","d");
        s=s.replace("CD","e");
        s=s.replace("CM","f");
        int result = 0;
        for (int i=0; i<s.length(); i++) {
            result += getValue(s.charAt(i));
        }
        return result;
    }public static int romanToInt2(String S){
        int sums=0;
        int preNums=getValue(S.charAt(0));
        for (int i = 1; i < S.length(); i++) {
            int nums=getValue(S.charAt(i));
            if (preNums>nums){
                sums+=preNums;
            }else if (preNums<nums){
                sums-=preNums;
            }
            preNums=nums;
            sums+=preNums;
        }
        return sums;
    }

    public static int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            case 'a':
                return 4;
            case 'b':
                return 9;
            case 'c':
                return 40;
            case 'd':
                return 90;
            case 'e':
                return 400;
            case 'f':
                return 900;

            default:
                return 0;
        }
    }
}
