import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class Exercise7_22 {

    private String firstName;
    private String lastName;
    private int birthMonth;
    private int birthDay;
    private int birthYear;

    // Constructor
    public Exercise7_22(String firstName, String lastName, int birthMonth, int birthDay, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.birthYear = birthYear;
    }

    // Getters and Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getBirthYear() {
        return birthYear;
    }

    // Calculate age
    public int getAge() {
        LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }

    // Maximum heart rate
    public int getMaximumHeartRate() {
        return 220 - getAge();
    }

    // Target heart rate
    public String getTargetHeartRate() {
        int max = getMaximumHeartRate();
        double min = max * 0.50;
        double maxTarget = max * 0.85;

        return String.format("%.0f - %.0f bpm", min, maxTarget);
    }

    // Main method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        System.out.print("Enter birth month (1-12): ");
        int month = input.nextInt();

        System.out.print("Enter birth day: ");
        int day = input.nextInt();

        System.out.print("Enter birth year: ");
        int year = input.nextInt();

        Exercise7_22 person = new Exercise7_22(firstName, lastName, month, day, year);

        System.out.println("\n--- Person Information ---");
        System.out.println("Name: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Date of Birth: " + person.getBirthMonth() + "/" +
                           person.getBirthDay() + "/" + person.getBirthYear());

        System.out.println("\n--- Health Information ---");
        System.out.println("Age: " + person.getAge() + " years");
        System.out.println("Maximum Heart Rate: " + person.getMaximumHeartRate() + " bpm");
        System.out.println("Target Heart Rate: " + person.getTargetHeartRate());

        input.close();
    }
}