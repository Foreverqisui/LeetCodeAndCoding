package leetCode.leetCode_1000;

/**
 * 反转字符串中的单词
 * */
public class leetCode_557_反转字符串中的单词 {
    public static void main(String[] args) {
       String str="wo ai China";
        System.out.println(reverseWords(str));
    }

    private static String reverseWords(String str) {
        StringBuffer sb=new StringBuffer();
        int length=str.length();
        int i=0;
        while(i<length){
            int start=i;
            while(i<length&&str.charAt(i)!=' '){
                i++;
            }
            for (int p=start;p<i;p++){
                sb.append(str.charAt(start+i-1-p));
            }
            while (i<length&&str.charAt(i)==' '){
                i++;
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
