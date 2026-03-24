import java.util.Scanner;

public class Exercise6_1_8 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean[] seats = new boolean[10]; // all initialized to false

        while (true) {

            System.out.println("Please type 1 for First Class or 2 for Economy:");
            int choice = input.nextInt();

            if (choice == 1) { // First Class
                boolean assigned = false;

                for (int i = 0; i < 5; i++) {
                    if (!seats[i]) {
                        seats[i] = true;
                        System.out.println("First Class");
                        System.out.println("Seat number: " + (i + 1));
                        assigned = true;
                        break;
                    }
                }

                if (!assigned) {
                    System.out.println("First Class is full. Would you like Economy? (1 = Yes, 2 = No)");
                    int response = input.nextInt();

                    if (response == 1) {
                        for (int i = 5; i < 10; i++) {
                            if (!seats[i]) {
                                seats[i] = true;
                                System.out.println("Economy");
                                System.out.println("Seat number: " + (i + 1));
                                break;
                            }
                        }
                    } else {
                        System.out.println("Next flight leaves in 3 hours.");
                    }
                }

            } else if (choice == 2) { // Economy
                boolean assigned = false;

                for (int i = 5; i < 10; i++) {
                    if (!seats[i]) {
                        seats[i] = true;
                        System.out.println("Economy");
                        System.out.println("Seat number: " + (i + 1));
                        assigned = true;
                        break;
                    }
                }

                if (!assigned) {
                    System.out.println("Economy is full. Would you like First Class? (1 = Yes, 2 = No)");
                    int response = input.nextInt();

                    if (response == 1) {
                        for (int i = 0; i < 5; i++) {
                            if (!seats[i]) {
                                seats[i] = true;
                                System.out.println("First Class");
                                System.out.println("Seat number: " + (i + 1));
                                break;
                            }
                        }
                    } else {
                        System.out.println("Next flight leaves in 3 hours.");
                    }
                }
            }

            // Optional: stop when all seats are full
            boolean full = true;
            for (boolean seat : seats) {
                if (!seat) {
                    full = false;
                    break;
                }
            }

            if (full) {
                System.out.println("Plane is full. No more seats available.");
                break;
            }

            System.out.println(); // spacing for readability
        }

        input.close();
    }
}