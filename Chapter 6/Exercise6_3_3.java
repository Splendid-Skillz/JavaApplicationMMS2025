import java.util.Scanner;

public class Exercise6_3_3 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Topics
        String[] topics = {
            "Climate Change",
            "Education",
            "Healthcare",
            "Poverty",
            "Cybersecurity"
        };

        // responses[topic][rating-1]
        int[][] responses = new int[5][10];

        char choice;

        // Collect responses
        do {
            System.out.println("\nPlease rate the following issues (1 = least important, 10 = most important):");

            for (int i = 0; i < topics.length; i++) {
                int rating;

                do {
                    System.out.print(topics[i] + ": ");
                    rating = input.nextInt();
                } while (rating < 1 || rating > 10);

                responses[i][rating - 1]++;
            }

            System.out.print("\nAnother user? (y/n): ");
            choice = input.next().charAt(0);

        } while (choice == 'y' || choice == 'Y');

        // Display table header
        System.out.println("\nSummary Report:");
        System.out.print("Topic\t\t");

        for (int i = 1; i <= 10; i++) {
            System.out.print(i + "\t");
        }
        System.out.println("Avg");

        int highestTotal = Integer.MIN_VALUE;
        int lowestTotal = Integer.MAX_VALUE;
        String highestTopic = "";
        String lowestTopic = "";

        // Display results
        for (int i = 0; i < topics.length; i++) {

            System.out.print(topics[i] + "\t");

            int total = 0;
            int count = 0;

            for (int j = 0; j < 10; j++) {
                System.out.print(responses[i][j] + "\t");
                total += responses[i][j] * (j + 1);
                count += responses[i][j];
            }

            double average = (count == 0) ? 0 : (double) total / count;
            System.out.printf("%.2f%n", average);

            // Track highest & lowest totals
            if (total > highestTotal) {
                highestTotal = total;
                highestTopic = topics[i];
            }

            if (total < lowestTotal) {
                lowestTotal = total;
                lowestTopic = topics[i];
            }
        }

        // Display highest & lowest
        System.out.println("\nHighest Rated Topic: " + highestTopic +
                           " (Total Points: " + highestTotal + ")");

        System.out.println("Lowest Rated Topic: " + lowestTopic +
                           " (Total Points: " + lowestTotal + ")");
    }
}