import java.util.Random;

public class Exercise6_2_5 {

    static final int SIZE = 8;
    static int[] queens = new int[SIZE]; // index = row, value = column
    static Random rand = new Random();

    public static void main(String[] args) {

        int attempts = 0;

        while (true) {
            attempts++;

            // random placement
            for (int i = 0; i < SIZE; i++) {
                queens[i] = rand.nextInt(SIZE);
            }

            if (isValid()) {
                System.out.println("Solution found after " + attempts + " attempts:");
                printBoard();
                break;
            }
        }
    }

    // check if no queens attack each other
    public static boolean isValid() {

        for (int i = 0; i < SIZE; i++) {
            for (int j = i + 1; j < SIZE; j++) {

                // same column
                if (queens[i] == queens[j])
                    return false;

                // same diagonal
                if (Math.abs(queens[i] - queens[j]) == Math.abs(i - j))
                    return false;
            }
        }
        return true;
    }

    public static void printBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (queens[row] == col)
                    System.out.print(" Q ");
                else
                    System.out.print(" . ");
            }
            System.out.println();
        }
    }
}