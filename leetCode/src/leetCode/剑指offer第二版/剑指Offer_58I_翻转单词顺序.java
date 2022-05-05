package leetCode.剑指offer第二版;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"。
 */
public class 剑指Offer_58I_翻转单词顺序 {
    public static void main(String[] args) {
        String s = "a good   example!";
        System.out.println(reverseWords(s)+" "+reverseWords1(s));
    }

    /**
     * 分割倒序
     * */
    private static String reverseWords1(String s) {
        //分割字符串，去掉首尾空格
        String[] str = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        int n = s.length();
        for (int i = str.length-1; i >=0; i--) {
            if (str[i].equals("")){
                continue;
            }
            res.append(str[i]).append(' ');
        }
        return res.toString().trim();
    }


    /**
     * 双指针
     */
    private static String reverseWords(String s) {
        //删除首尾空格
        s = s.trim();
        StringBuilder res = new StringBuilder();
        int r = s.length()-1,l = r;
        //双指针遍历，迭代找出元素
        while(l>=0){
            //找到空格处，获取到一个完整单词
            while(l>=0&&s.charAt(l)!=' '){
                l--;
            }
            //拼接空格到r的字符
            res.append(s.substring(l+1,r+1)).append(" ");
            //转换r到下一个字符末尾的位置
            while(l>=0 && s.charAt(l) == ' '){
                l--;
            }
            r=l;
        }
        return res.toString().trim();

    }
}
