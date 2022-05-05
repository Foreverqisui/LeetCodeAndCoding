package leetCode.双指针;

public class leetCode_541_反转字符串II {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s,k));
    }

    private static String reverseStr(String s, int k) {
        int n=s.length();
        char [] chars=s.toCharArray();
        for (int i = 0; i < n; i+=2*k) {
            int left=i;
            int right=Math.min(i+k,n)-1;
            while(left<right){
                char temp=chars[left];
                chars[left]=chars[right];
                chars[right]=temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}
