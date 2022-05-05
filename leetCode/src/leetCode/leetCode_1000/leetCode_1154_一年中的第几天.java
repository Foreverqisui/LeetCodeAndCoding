package leetCode.leetCode_1000;

public class leetCode_1154_一年中的第几天 {
    public static void main(String[] args) {
        String s = "2021-12-21";
        System.out.println(dayOfYear(s));
    }

    private static int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, date.length()));
        int[] count = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {
            count[1]++;
        }
        int ans = 0;
        for (int i = 0; i < month-1; i++) {
            ans += count[i];
        }

        return ans+day;

    }
}
