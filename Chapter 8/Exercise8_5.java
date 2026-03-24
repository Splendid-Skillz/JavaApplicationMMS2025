public class Exercise8_5 {

    // ===== Time2 CLASS (modified) =====
    private int totalSeconds;

    // Constructors
    public Exercise8_5() {
        this(0, 0, 0);
    }

    public Exercise8_5(int hour) {
        this(hour, 0, 0);
    }

    public Exercise8_5(int hour, int minute) {
        this(hour, minute, 0);
    }

    public Exercise8_5(int hour, int minute, int second) {
        setTime(hour, minute, second);
    }

    public Exercise8_5(Exercise8_5 time) {
        this(time.getHour(), time.getMinute(), time.getSecond());
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

    // Setters
    public void setHour(int hour) {
        if (hour < 0 || hour >= 24)
            throw new IllegalArgumentException("hour must be 0-23");

        totalSeconds = (hour * 3600) + (getMinute() * 60) + getSecond();
    }

    public void setMinute(int minute) {
        if (minute < 0 || minute >= 60)
            throw new IllegalArgumentException("minute must be 0-59");

        totalSeconds = (getHour() * 3600) + (minute * 60) + getSecond();
    }

    public void setSecond(int second) {
        if (second < 0 || second >= 60)
            throw new IllegalArgumentException("second must be 0-59");

        totalSeconds = (getHour() * 3600) + (getMinute() * 60) + second;
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

    // Universal time
    public String toUniversalString() {
        return String.format("%02d:%02d:%02d",
                getHour(), getMinute(), getSecond());
    }

    // Standard time
    @Override
    public String toString() {
        return String.format("%d:%02d:%02d %s",
                ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
                getMinute(),
                getSecond(),
                (getHour() < 12 ? "AM" : "PM"));
    }

    // ===== MAIN METHOD (TEST PROGRAM) =====
    public static void main(String[] args) {

        Exercise8_5 time1 = new Exercise8_5(13, 27, 45);

        System.out.println("Initial time:");
        System.out.println("Universal: " + time1.toUniversalString());
        System.out.println("Standard: " + time1.toString());

        time1.setHour(9);
        time1.setMinute(5);
        time1.setSecond(30);

        System.out.println("\nAfter modification:");
        System.out.println("Universal: " + time1.toUniversalString());
        System.out.println("Standard: " + time1.toString());

        Exercise8_5 time2 = new Exercise8_5(time1);

        System.out.println("\nCopied time:");
        System.out.println("Universal: " + time2.toUniversalString());
        System.out.println("Standard: " + time2.toString());
    }
}