public class Exercise6_2_5_b {

    static final int SIZE = 8;
    static int[] queens = new int[SIZE]; // index = row, value = column
    static int solutionCount = 0;

    public static void main(String[] args) {
        solve(0);
        System.out.println("\nTotal solutions: " + solutionCount);
    }

    // Try placing a queen row by row
    public static void solve(int row) {

        // Base case: all 8 queens placed
        if (row == SIZE) {
            solutionCount++;
            System.out.println("\nSolution " + solutionCount + ":");
            printBoard();
            return;
        }

        // Try all columns in current row
        for (int col = 0; col < SIZE; col++) {

            queens[row] = col;

            if (isValid(row)) {
                solve(row + 1); // move to next row
            }
        }
    }

    // Check if current placement is valid
    public static boolean isValid(int currentRow) {

        for (int i = 0; i < currentRow; i++) {

            // same column
            if (queens[i] == queens[currentRow])
                return false;

            // same diagonal
            if (Math.abs(queens[i] - queens[currentRow]) == currentRow - i)
                return false;
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