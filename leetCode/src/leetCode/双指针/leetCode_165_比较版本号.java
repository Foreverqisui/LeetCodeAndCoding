package leetCode.双指针;

public class leetCode_165_比较版本号 {
    public static void main(String[] args) {
        String version1 = "1.0.1";
        String version2 = "1.0";
        System.out.println(compareVersion(version1, version2));
    }

    private static int compareVersion(String version1, String version2) {
        int n = version1.length();
        int m = version2.length();
        int v1 = 0;
        int v2 = 0;
        while (v1 < n || v2 < m) {
            int i = 0;
            for (; v1 < n && version1.charAt(v1) != '.'; v1++) {
                i = i* 10 + version1.charAt(v1) - '0';
            }
            v1++;
            int j = 0;
            for (; v2 < m && version2.charAt(v2) != '.'; v2++) {
                j= j* 10 + version2.charAt(v2) - '0';
            }
            v2++;
            if (i != j) {
                return i > j ? 1 : -1;
            }
        }

        return 0;
    }
}
