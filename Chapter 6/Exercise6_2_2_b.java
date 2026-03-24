import java.util.Random;

public class Exercise6_2_2_b {

    static final int SIZE = 8;
    static int[][] board = new int[SIZE][SIZE];

    static int[] horizontal = {2,1,-1,-2,-2,-1,1,2};
    static int[] vertical   = {-1,-2,-2,-1,1,2,2,1};

    static Random rand = new Random();

    public static void main(String[] args) {

        int[] results = new int[65]; // index = tour length

        // Run 1000 tours
        for (int i = 0; i < 1000; i++) {
            resetBoard();
            int moves = randomTour();
            results[moves]++;
        }

        // Display results
        System.out.println("Tour Length | Frequency");
        System.out.println("------------------------");

        for (int i = 1; i <= 64; i++) {
            if (results[i] > 0) {
                System.out.printf("%4d       | %4d%n", i, results[i]);
            }
        }
    }

    public static int randomTour() {

        int row = 0;
        int col = 0;
        board[row][col] = 1;

        for (int move = 2; move <= 64; move++) {

            int[] validMoves = new int[8];
            int count = 0;

            // collect valid moves
            for (int i = 0; i < 8; i++) {
                int r = row + vertical[i];
                int c = col + horizontal[i];

                if (isValid(r, c)) {
                    validMoves[count++] = i;
                }
            }

            // no moves available
            if (count == 0)
                return move - 1;

            // choose random valid move
            int choice = validMoves[rand.nextInt(count)];

            row += vertical[choice];
            col += horizontal[choice];
            board[row][col] = move;
        }

        return 64;
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < SIZE &&
               c >= 0 && c < SIZE &&
               board[r][c] == 0;
    }

    public static void resetBoard() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                board[i][j] = 0;
    }
}