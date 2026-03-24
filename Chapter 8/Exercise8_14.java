public class Exercise8_14 {

    private int month; // 1-12
    private int day;
    private int year;

    private static final String[] months = {
            "", "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };

    private static final int[] daysPerMonth = {
            0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    // ===== Constructors =====

    // Format: MM/DD/YYYY
    public Exercise8_14(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    // Format: MonthName DD, YYYY
    public Exercise8_14(String monthName, int day, int year) {
        for (int i = 1; i <= 12; i++) {
            if (months[i].equals(monthName)) {
                this.month = i;
                break;
            }
        }
        this.day = day;
        this.year = year;
    }

    // Format: DDD YYYY (day of year)
    public Exercise8_14(int dayOfYear, int year) {
        this.year = year;

        int month = 1;

        while (dayOfYear > daysInMonth(month)) {
            dayOfYear -= daysInMonth(month);
            month++;
        }

        this.month = month;
        this.day = dayOfYear;
    }

    // Helper method
    private int daysInMonth(int month) {
        if (month == 2 && isLeapYear())
            return 29;
        return daysPerMonth[month];
    }

    // Check leap year
    private boolean isLeapYear() {
        return (year % 400 == 0 ||
               (year % 4 == 0 && year % 100 != 0));
    }

    // ===== Output Methods =====

    // MM/DD/YYYY
    public String toString() {
        return String.format("%02d/%02d/%04d", month, day, year);
    }

    // MonthName DD, YYYY
    public String toMonthDayYear() {
        return String.format("%s %d, %d", months[month], day, year);
    }

    // DDD YYYY (day of year)
    public String toDayOfYear() {
        int dayOfYear = day;

        for (int i = 1; i < month; i++) {
            dayOfYear += daysInMonth(i);
        }

        return String.format("%03d %d", dayOfYear, year);
    }

    // ===== Test Program =====
    public static void main(String[] args) {

        System.out.println("=== Constructor 1: MM/DD/YYYY ===");
        Exercise8_14 date1 = new Exercise8_14(6, 14, 1992);
        System.out.println("MM/DD/YYYY: " + date1.toString());
        System.out.println("Month Day Year: " + date1.toMonthDayYear());
        System.out.println("DDD YYYY: " + date1.toDayOfYear());

        System.out.println("\n=== Constructor 2: Month Name ===");
        Exercise8_14 date2 = new Exercise8_14("June", 14, 1992);
        System.out.println("MM/DD/YYYY: " + date2.toString());
        System.out.println("Month Day Year: " + date2.toMonthDayYear());
        System.out.println("DDD YYYY: " + date2.toDayOfYear());

        System.out.println("\n=== Constructor 3: Day of Year ===");
        Exercise8_14 date3 = new Exercise8_14(165, 1992);
        System.out.println("MM/DD/YYYY: " + date3.toString());
        System.out.println("Month Day Year: " + date3.toMonthDayYear());
        System.out.println("DDD YYYY: " + date3.toDayOfYear());
    }
}