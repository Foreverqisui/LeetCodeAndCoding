package leetCode.leetCode_2000;

public class leetCode_1185_一周中的第几天 {
    public static void main(String[] args) {
        int day = 3;
        int month = 1;
        int year = 2022;
        System.out.println(dayOfTheWeek(day, month, year));
    }

    private static String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        // 从2022到1971年份的天数是多少
        int days = 365 * (year - 1971) + (year - 1969) / 4;
        // 年份天数再加上月份的天数
        for (int i = 0; i < month - 1; ++i) {
            days += monthDays[i];
        }
        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {
            days += 1;
        }
        //再加上今天是第七天，除以一周 得出周几
        days += day;
        return week[(days + 3) % 7];

    }
}
