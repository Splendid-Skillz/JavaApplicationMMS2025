public class Exercise8_7 {

    private int totalSeconds;

    // Constructors
    public Exercise8_7() {
        this(0, 0, 0);
    }

    public Exercise8_7(int hour) {
        this(hour, 0, 0);
    }

    public Exercise8_7(int hour, int minute) {
        this(hour, minute, 0);
    }

    public Exercise8_7(int hour, int minute, int second) {
        setTime(hour, minute, second);
    }

    // Set time
    public void setTime(int hour, int minute, int second) {
        if (hour < 0 || hour >= 24)
            throw new IllegalArgumentException("hour must be 0-23");
        if (minute < 0 || minute >= 60)
            throw new IllegalArgumentException("minute must be 0-59");
        if (second < 0 || second >= 60)
            throw new IllegalArgumentException("second must be 0-59");

        totalSeconds = (hour * 3600) + (minute * 60) + second;
    }

    // Getters
    public int getHour() {
        return totalSeconds / 3600;
    }

    public int getMinute() {
        return (totalSeconds % 3600) / 60;
    }

    public int getSecond() {
        return totalSeconds % 60;
    }

    // ===== New Methods =====

    // Increment by one second
    public void tick() {
        totalSeconds++;
        if (totalSeconds >= 24 * 3600) {
            totalSeconds = 0; // wrap to next day
        }
    }

    // Increment minute by one
    public void incrementMinute() {
        int hour = getHour();
        int minute = getMinute();

        minute++;

        if (minute >= 60) {
            minute = 0;
            hour++;
        }

        if (hour >= 24) {
            hour = 0;
        }

        totalSeconds = (hour * 3600) + (minute * 60) + getSecond();
    }

    // Increment hour by one
    public void incrementHour() {
        int hour = getHour();
        hour++;

        if (hour >= 24) {
            hour = 0;
        }

        totalSeconds = (hour * 3600) + (getMinute() * 60) + getSecond();
    }

    // Output methods
    public String toUniversalString() {
        return String.format("%02d:%02d:%02d",
                getHour(), getMinute(), getSecond());
    }

    @Override
    public String toString() {
        return String.format("%d:%02d:%02d %s",
                ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
                getMinute(),
                getSecond(),
                (getHour() < 12 ? "AM" : "PM"));
    }

    // ===== TEST PROGRAM =====
    public static void main(String[] args) {

        // a) Increment into next minute
        System.out.println("=== Test: Next Minute ===");
        Exercise8_7 time1 = new Exercise8_7(10, 59, 58);
        System.out.println("Before: " + time1.toUniversalString());
        time1.tick();
        System.out.println("After 1 tick: " + time1.toUniversalString());
        time1.tick();
        System.out.println("After 2 ticks: " + time1.toUniversalString());

        // b) Increment into next hour
        System.out.println("\n=== Test: Next Hour ===");
        Exercise8_7 time2 = new Exercise8_7(10, 58, 0);
        System.out.println("Before: " + time2.toUniversalString());
        time2.incrementMinute();
        System.out.println("After 1 minute: " + time2.toUniversalString());
        time2.incrementMinute();
        System.out.println("After 2 minutes: " + time2.toUniversalString());

        // c) Increment into next day
        System.out.println("\n=== Test: Next Day ===");
        Exercise8_7 time3 = new Exercise8_7(23, 59, 59);
        System.out.println("Before: " + time3.toUniversalString());
        time3.tick();
        System.out.println("After tick (new day): " + time3.toUniversalString());

        // Extra: increment hour rollover
        System.out.println("\n=== Test: Hour Roll ===");
        Exercise8_7 time4 = new Exercise8_7(23, 0, 0);
        System.out.println("Before: " + time4.toUniversalString());
        time4.incrementHour();
        System.out.println("After increment hour: " + time4.toUniversalString());
    }
}