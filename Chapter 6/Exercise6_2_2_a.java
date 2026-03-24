import java.util.Random;

public class Exercise6_2_2_a {

    static final int SIZE = 8;
    static int[][] board = new int[SIZE][SIZE];

    static int[] horizontal = {2,1,-1,-2,-2,-1,1,2};
    static int[] vertical   = {-1,-2,-2,-1,1,2,2,1};

    static Random rand = new Random();

    public static void main(String[] args) {
        int moves = randomTour();
        printBoard();
        System.out.println("Moves made: " + moves);
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

            if (count == 0)
                return move - 1;

            int choice = validMoves[rand.nextInt(count)];

            row += vertical[choice];
            col += horizontal[choice];
            board[row][col] = move;
        }

        return 64;
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < SIZE && c >= 0 && c < SIZE && board[r][c] == 0;
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