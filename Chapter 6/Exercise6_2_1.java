public class Exercise6_2_1 {

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
        System.out.println("Total moves: " + moves);
    }

    public static int knightTour(int currentRow, int currentCol) {

        board[currentRow][currentCol] = 1;

        for (int move = 2; move <= 64; move++) {

            int bestMove = -1;
            int minAccess = Integer.MAX_VALUE;

            // Find best move (with tie-break lookahead)
            for (int i = 0; i < 8; i++) {

                int newRow = currentRow + vertical[i];
                int newCol = currentCol + horizontal[i];

                if (isValid(newRow, newCol)) {

                    int access = accessibility[newRow][newCol];

                    // Lookahead value
                    int nextMin = getNextAccessibility(newRow, newCol);

                    if (access < minAccess ||
                       (access == minAccess && nextMin < getNextAccessibility(
                           currentRow + vertical[bestMove],
                           currentCol + horizontal[bestMove]))) {

                        minAccess = access;
                        bestMove = i;
                    }
                }
            }

            if (bestMove == -1) {
                return move - 1; // stuck
            }

            // Move knight
            currentRow += vertical[bestMove];
            currentCol += horizontal[bestMove];
            board[currentRow][currentCol] = move;

            // Update accessibility
            updateAccessibility(currentRow, currentCol);
        }

        return 64;
    }

    public static boolean isValid(int row, int col) {
        return (row >= 0 && row < SIZE &&
                col >= 0 && col < SIZE &&
                board[row][col] == 0);
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

    // Lookahead function
    public static int getNextAccessibility(int row, int col) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 8; i++) {
            int r = row + vertical[i];
            int c = col + horizontal[i];

            if (isValid(r, c)) {
                min = Math.min(min, accessibility[r][c]);
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
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