package leetcode;

public class T1360 {
    // 1360. 日期之间隔几天
    // 请你编写一个程序来计算两个日期之间隔了多少天。
    // 日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。
    public int daysBetweenDates(String date1, String date2) {
        // 始终保持 date1 < date2
        if (date1.compareTo(date2) > 0) return daysBetweenDates(date2, date1);
        int[] d1 = parseDateStr(date1);
        int[] d2 = parseDateStr(date2);
        return helper(d2[0], d2[1], d2[2]) - helper(d1[0], d1[1], d1[2]);
    }

    // 当前日期算出距离 1971 年 1 月 1 日 过了多少天
    private int helper(int year, int month, int day) {
        int daySum = 0;
        int k = year;
        while (k > 1971) {
            // 这里应该是加上前一年的所有天数
            daySum += isLeapYear(k - 1) ? 366 : 365;
            k--;
        }

        while (month > 1) {
            // 这里应该是加上前一个月的所有天数
            daySum += getMonthOfDays(year, month - 1);
            month--;
        }
        daySum += (day - 1);

        return daySum;
    }

    private int getMonthOfDays(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 0;
        }
    }

    // YYYY-MM-DD
    private int[] parseDateStr(String dateStr) {
        int year = Integer.parseInt(dateStr.substring(0, 4));
        int month = Integer.parseInt(dateStr.substring(5, 7));
        int day = Integer.parseInt(dateStr.substring(8));
        return new int[]{year, month, day};
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void main(String[] args) {
        System.out.println(new T1360().daysBetweenDates("2019-06-29", "2019-06-30"));
        System.out.println(new T1360().daysBetweenDates("2019-12-31", "2020-11-25"));
        System.out.println(new T1360().helper(2100, 12, 31));
    }
}
