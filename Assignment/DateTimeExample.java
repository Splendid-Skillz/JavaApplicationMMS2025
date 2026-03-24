import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeExample {
    public static void main(String[] args) {
        // Get current date and time
        LocalDateTime now = LocalDateTime.now();

        // Format 1: Default pattern
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println("Formatted (dd/MM/yyyy): " + now.format(format1));

        // Format 2: Month name
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        System.out.println("Formatted (Month name): " + now.format(format2));

        // Format 3: Day of year
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("DDD yyyy");
        System.out.println("Formatted (Day of year): " + now.format(format3));
    }
}