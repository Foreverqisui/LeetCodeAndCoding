package leetCode.双指针;

public class leetCode_151_翻转字符串里的单词 {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reserveWords(s));
    }

    private static String reserveWords(String s) {
        int n = s.length();
        StringBuilder sb = trimSpace(s);
        reserveWord(sb, 0, n - 1);
        reserveEach(sb);
        return sb.toString();

    }

    /**
     * 翻转每一个单词
     * */

    private static void reserveEach(StringBuilder sb) {
        int n=sb.length();
        int start=0;
        int end=0;
        while(start<n){
            while(end<n&&sb.charAt(end)!=' '){
                end++;
            }
            reserveWord(sb,start,end-1);
            start=end+1;
            end++;

        }
    }

    /**
     * 翻转字符串
     * */
    private static void reserveWord(StringBuilder sb, int left, int right) {
        while(left<right){
            char temp=sb.charAt(left);
            sb.setCharAt(left++,sb.charAt(right));
            sb.setCharAt(right--,temp);
        }

    }

    /**
     * 去除前后中间的空格
     * */

    private static StringBuilder trimSpace(String s) {
        int n = s.length();
        int left = 0;
        int right = n - 1;
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (left != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length()) != ' ') {
                sb.append(c);
            }
            left++;
        }
        return sb;
    }
}
