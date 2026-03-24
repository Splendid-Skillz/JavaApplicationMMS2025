public class Exercise6_2_6 {

    static final int SIZE = 8;

    static int[][] board = new int[SIZE][SIZE];

    static int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] vertical   = {-1, -2, -2, -1, 1, 2, 2, 1};

    static int[][] accessibility = {
        {2,3,4,4,4,4,3,2},
        {3,4,6,6,6,6,4,3},
        {4,6,8,8,8,8,6,4},
        {4,6,8,8,8,8,6,4},
        {4,6,8,8,8,8,6,4},
        {4,6,8,8,8,8,6,4},
        {3,4,6,6,6,6,4,3},
        {2,3,4,4,4,4,3,2}
    };

    public static void main(String[] args) {

        int startRow = 0;
        int startCol = 0;

        int moves = knightTour(startRow, startCol);

        printBoard();

        if (moves == 64) {
            System.out.println("Full tour completed!");

            if (isClosedTour(currentRow, currentCol, startRow, startCol)) {
                System.out.println("This is a CLOSED tour.");
            } else {
                System.out.println("This is an OPEN tour.");
            }
        } else {
            System.out.println("Tour ended early at move: " + moves);
        }
    }

    static int currentRow, currentCol;

    public static int knightTour(int startRow, int startCol) {

        currentRow = startRow;
        currentCol = startCol;

        board[currentRow][currentCol] = 1;

        for (int move = 2; move <= 64; move++) {

            int bestMove = -1;
            int minAccess = Integer.MAX_VALUE;

            for (int i = 0; i < 8; i++) {

                int newRow = currentRow + vertical[i];
                int newCol = currentCol + horizontal[i];

                if (isValid(newRow, newCol)) {

                    if (accessibility[newRow][newCol] < minAccess) {
                        minAccess = accessibility[newRow][newCol];
                        bestMove = i;
                    }
                }
            }

            if (bestMove == -1) {
                return move - 1; // stuck
            }

            currentRow += vertical[bestMove];
            currentCol += horizontal[bestMove];
            board[currentRow][currentCol] = move;

            updateAccessibility(currentRow, currentCol);
        }

        return 64;
    }

    public static boolean isValid(int row, int col) {
        return row >= 0 && row < SIZE &&
               col >= 0 && col < SIZE &&
               board[row][col] == 0;
    }

    public static void updateAccessibility(int row, int col) {
        for (int i = 0; i < 8; i++) {
            int r = row + vertical[i];
            int c = col + horizontal[i];

            if (r >= 0 && r < SIZE && c >= 0 && c < SIZE) {
                accessibility[r][c]--;
            }
        }
    }

    // 🔥 Closed Tour Check
    public static boolean isClosedTour(int row, int col,
                                       int startRow, int startCol) {

        for (int i = 0; i < 8; i++) {
            int r = row + vertical[i];
            int c = col + horizontal[i];

            if (r == startRow && c == startCol) {
                return true;
            }
        }
        return false;
    }

    public static void printBoard() {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.printf("%3d ", cell);
            }
            System.out.println();
        }
    }
}