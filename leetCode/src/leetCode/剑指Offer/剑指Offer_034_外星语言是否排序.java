package leetCode.剑指Offer;

public class 剑指Offer_034_外星语言是否排序 {
    public static void main(String[] args) {
        String[] words = {"word","world","row"};
        String order = "worldabcefghijkmnpqstuvxyz";
        System.out.println(isAlienSorted(words, order));
    }

    private static boolean isAlienSorted(String[] words, String order) {
        for(int i=words.length-1;i>=1;i--)
        {
            String a=words[i];
            String b=words[i-1];
            int j=0;
            int k=0;
            while(j<a.length() || k<b.length())
            {
                if(k==b.length())
                {
                    break;
                }
                if(j==a.length())
                {
                    return false;
                }
                int idx1=order.indexOf(a.charAt(j));
                int idx2=order.indexOf(b.charAt(k));
                if(idx1>idx2)
                {
                    break;
                }
                if(idx1<idx2)
                {
                    return false;
                }
                j++;
                k++;
            }
        }
        return true;
    }
}
