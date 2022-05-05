package leetCode.双指针;


public class leetCode_844_比较含退格的字符串 {
    public static void main(String[] args) {
        String s = "a##c", t = "#a#c";
        System.out.println(backspaceCompare(s, t));
        System.out.println(backspaceCompare1(s,t));
    }


    /**
     * 双指针
     * 因为#号删除前面的元素，所以从后往前遍历
     * 一个指针是skips 判断元素是否为#
     * skipt同理
     * */
    private static boolean backspaceCompare1(String s, String t) {
        int sl = s.length()-1,tl=t.length()-1,skips=0,skipt=0;
        while (sl>=0||tl>=0){
            //判断s字符串
            while (sl>=0) {
                //判断s字符串中的元素是否为#
                //如果是#，则让skips++
                if (s.charAt(sl) == '#') {
                    skips++;
                    sl--;
                //如果skips大于0证明这个元素为#之前的，得跳过
                } else if (skips > 0) {
                    skips--;
                    sl--;
                } else {
                    break;
                }
            }
            //同理s
            while(tl>=0){
                if (t.charAt(tl)=='#'){
                    skipt++;
                    tl--;
                }else if (skipt>0){
                    skipt--;
                    tl--;
                }else{
                    break;
                }
            }
           if (sl>=0&&tl>=0){
               if (s.charAt(sl)!=s.charAt(tl)){
                   return false;
               }
            }else {
               if (sl>=0||tl>=0){
                   return false;
               }
           }
           sl--;
           tl--;
        }
        return true;
    }





    /**
     * 重构字符串
     * */
    private static boolean backspaceCompare(String s, String t) {
        return del(s).equals(del(t));
    }
    private static String del(String str){
        int n = str.length();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) !='#'){
                buf.append(str.charAt(i));
            }else{
                if (buf.length() >0){
                    buf.deleteCharAt(buf.length() -1);
                }
            }
        }
        return buf.toString();
    }

}
