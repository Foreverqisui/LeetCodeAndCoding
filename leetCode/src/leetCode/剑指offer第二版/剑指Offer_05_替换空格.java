package leetCode.剑指offer第二版;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * */
public class 剑指Offer_05_替换空格 {
    public static void main(String[] args) {
        String s ="We are happy.";
        System.out.println(replaceString(s));
    }
    /**
     *字符数组
     * */
    private static String replaceString(String s){
        char [] arr = new char[s.length()*3];
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                arr[size++]='%';
                arr[size++]='2';
                arr[size++]='0';
            }else{
                arr[size++]=c;
            }
        }
        String res = new String(arr,0,size);
        return res;
    }
}
