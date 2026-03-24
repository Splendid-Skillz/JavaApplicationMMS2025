public class Exercise8_8 {

    private int month; // 1-12
    private int day;   // 1-31
    private int year;

    private static final int[] daysPerMonth =
            {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // Constructor with validation
    public Exercise8_8(int month, int day, int year) {

        // Validate month
        if (month <= 0 || month > 12)
            throw new IllegalArgumentException("month must be 1-12");

        // Validate day
        if (day <= 0 || day > daysPerMonth[month])
            throw new IllegalArgumentException("day out of range for month");

        // Leap year check for February
        if (month == 2 && day == 29 && !(year % 400 == 0 ||
                (year % 4 == 0 && year % 100 != 0))) {
            throw new IllegalArgumentException("invalid leap year day");
        }

        this.month = month;
        this.day = day;
        this.year = year;
    }

    // Check for leap year
    private boolean isLeapYear() {
        return (year % 400 == 0 ||
               (year % 4 == 0 && year % 100 != 0));
    }

    // Increment day
    public void nextDay() {

        int daysInMonth = daysPerMonth[month];

        // Adjust for leap year
        if (month == 2 && isLeapYear()) {
            daysInMonth = 29;
        }

        day++;

        // Move to next month
        if (day > daysInMonth) {
            day = 1;
            month++;

            // Move to next year
            if (month > 12) {
                month = 1;
                year++;
            }
        }
    }

    // toString method
    @Override
    public String toString() {
        return String.format("%d/%d/%d", month, day, year);
    }

    // ===== TEST PROGRAM =====
    public static void main(String[] args) {

        System.out.println("=== Test: Next Month ===");

        // Start at end of January
        Exercise8_8 date1 = new Exercise8_8(1, 30, 2024);

        for (int i = 0; i < 5; i++) {
            System.out.println(date1);
            date1.nextDay();
        }

        System.out.println("\n=== Test: Next Year ===");

        // Start at end of year
        Exercise8_8 date2 = new Exercise8_8(12, 30, 2024);

        for (int i = 0; i < 5; i++) {
            System.out.println(date2);
            date2.nextDay();
        }

        System.out.println("\n=== Leap Year Test ===");

        // Leap year test (Feb 28)
        Exercise8_8 date3 = new Exercise8_8(2, 27, 2024);

        for (int i = 0; i < 3; i++) {
            System.out.println(date3);
            date3.nextDay();
        }
    }
}