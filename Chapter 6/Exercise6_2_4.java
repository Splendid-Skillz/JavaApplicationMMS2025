public class Exercise6_2_4 {

    static final int SIZE = 8;
    static int[][] board = new int[SIZE][SIZE];

    public static void main(String[] args) {

        int queensPlaced = 0;

        while (queensPlaced < 8) {

            int bestRow = -1;
            int bestCol = -1;
            int minElimination = Integer.MAX_VALUE;

            for (int row = 0; row < SIZE; row++) {
                for (int col = 0; col < SIZE; col++) {

                    if (board[row][col] == 0 && isSafe(row, col)) {

                        int elimination = calculateElimination(row, col);

                        if (elimination < minElimination) {
                            minElimination = elimination;
                            bestRow = row;
                            bestCol = col;
                        }
                    }
                }
            }

            if (bestRow == -1) {
                System.out.println("No solution found.");
                return;
            }

            board[bestRow][bestCol] = 1;
            queensPlaced++;
        }

        printBoard();
    }

    // Check if placing queen is safe
    public static boolean isSafe(int row, int col) {

        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == 1 || board[i][col] == 1)
                return false;
        }

        for (int i = -SIZE; i < SIZE; i++) {
            int r = row + i;
            int c = col + i;
            if (r >= 0 && r < SIZE && c >= 0 && c < SIZE)
                if (board[r][c] == 1)
                    return false;

            r = row + i;
            c = col - i;
            if (r >= 0 && r < SIZE && c >= 0 && c < SIZE)
                if (board[r][c] == 1)
                    return false;
        }

        return true;
    }

    // Count how many squares get eliminated
    public static int calculateElimination(int row, int col) {

        int count = 0;

        for (int i = 0; i < SIZE; i++) {
            if (i != col) count++; // row
            if (i != row) count++; // column
        }

        for (int i = 1; i < SIZE; i++) {
            if (inBounds(row+i, col+i)) count++;
            if (inBounds(row-i, col-i)) count++;
            if (inBounds(row+i, col-i)) count++;
            if (inBounds(row-i, col+i)) count++;
        }

        return count;
    }

    public static boolean inBounds(int r, int c) {
        return r >= 0 && r < SIZE && c >= 0 && c < SIZE;
    }

    public static void printBoard() {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell == 1 ? " Q " : " . ");
            }
            System.out.println();
        }
    }
}