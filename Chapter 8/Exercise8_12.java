public class Exercise8_12 {

    // ===== DATE CLASS =====
    static class Date {
        private int month; // 1-12
        private int day;   // 1-31
        private int year;

        private static final int[] daysPerMonth =
                {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        public Date(int month, int day, int year) {
            if (month <= 0 || month > 12)
                throw new IllegalArgumentException("month must be 1-12");

            if (day <= 0 || day > daysPerMonth[month])
                throw new IllegalArgumentException("invalid day");

            if (month == 2 && day == 29 && !(year % 400 == 0 ||
                    (year % 4 == 0 && year % 100 != 0)))
                throw new IllegalArgumentException("invalid leap year day");

            this.month = month;
            this.day = day;
            this.year = year;
        }

        private boolean isLeapYear() {
            return (year % 400 == 0 ||
                   (year % 4 == 0 && year % 100 != 0));
        }

        public void nextDay() {
            int daysInMonth = daysPerMonth[month];

            if (month == 2 && isLeapYear()) {
                daysInMonth = 29;
            }

            day++;

            if (day > daysInMonth) {
                day = 1;
                month++;

                if (month > 12) {
                    month = 1;
                    year++;
                }
            }
        }

        public String toString() {
            return String.format("%d/%d/%d", month, day, year);
        }
    }

    // ===== TIME CLASS =====
    static class Time {
        private int hour;
        private int minute;
        private int second;

        private Date date; // link to Date

        public Time(int hour, int minute, int second, Date date) {
            setTime(hour, minute, second);
            this.date = date;
        }

        public void setTime(int hour, int minute, int second) {
            if (hour < 0 || hour >= 24)
                throw new IllegalArgumentException("hour must be 0-23");
            if (minute < 0 || minute >= 60)
                throw new IllegalArgumentException("minute must be 0-59");
            if (second < 0 || second >= 60)
                throw new IllegalArgumentException("second must be 0-59");

            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }

        // Increment second
        public void tick() {
            second++;

            if (second == 60) {
                second = 0;
                incrementMinute();
            }
        }

        // Increment minute
        public void incrementMinute() {
            minute++;

            if (minute == 60) {
                minute = 0;
                incrementHour();
            }
        }

        // Increment hour (calls nextDay if needed)
        public void incrementHour() {
            hour++;

            if (hour == 24) {
                hour = 0;
                date.nextDay(); // move to next day
            }
        }

        // Universal time with date
        public String toUniversalString() {
            return String.format("%s %02d:%02d:%02d",
                    date.toString(), hour, minute, second);
        }

        // Standard time with date
        public String toString() {
            return String.format("%s %d:%02d:%02d %s",
                    date.toString(),
                    ((hour == 0 || hour == 12) ? 12 : hour % 12),
                    minute, second,
                    (hour < 12 ? "AM" : "PM"));
        }
    }

    // ===== TEST PROGRAM =====
    public static void main(String[] args) {

        Date date = new Date(12, 31, 2024);

        // Set time close to midnight
        Time time = new Time(23, 59, 58, date);

        System.out.println("Initial:");
        System.out.println(time.toUniversalString());
        System.out.println(time.toString());

        // Tick twice to roll into next day
        time.tick();
        System.out.println("\nAfter 1 tick:");
        System.out.println(time.toUniversalString());

        time.tick();
        System.out.println("\nAfter 2 ticks (next day):");
        System.out.println(time.toUniversalString());
        System.out.println(time.toString());
    }
}