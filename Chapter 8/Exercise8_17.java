import java.util.Scanner;

public class Exercise8_17 {

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner input = new Scanner(System.in);

        boolean gameOver = false;
        TicTacToe.Cell currentPlayer = TicTacToe.Cell.X;

        System.out.println("Tic-Tac-Toe Game");
        game.printBoard();

        while (!gameOver) {
            System.out.printf("Player %s, enter row and column (0-2): ", currentPlayer);

            int row = input.nextInt();
            int col = input.nextInt();

            if (!game.makeMove(row, col, currentPlayer)) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            game.printBoard();

            if (game.checkWin(currentPlayer)) {
                System.out.printf("Player %s wins!%n", currentPlayer);
                gameOver = true;
            } else if (game.isDraw()) {
                System.out.println("Game is a draw!");
                gameOver = true;
            } else {
                // Switch player
                currentPlayer = (currentPlayer == TicTacToe.Cell.X)
                        ? TicTacToe.Cell.O
                        : TicTacToe.Cell.X;
            }
        }

        input.close();
    }
}

class TicTacToe {

    enum Cell { X, O, EMPTY }

    private Cell[][] board = new Cell[3][3];

    // Constructor
    public TicTacToe() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Cell.EMPTY;
            }
        }
    }

    // Make a move
    public boolean makeMove(int row, int col, Cell player) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            return false;
        }

        if (board[row][col] != Cell.EMPTY) {
            return false;
        }

        board[row][col] = player;
        return true;
    }

    // Check win condition
    public boolean checkWin(Cell player) {
        // Rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player &&
                board[i][1] == player &&
                board[i][2] == player) {
                return true;
            }
        }

        // Columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player &&
                board[1][j] == player &&
                board[2][j] == player) {
                return true;
            }
        }

        // Diagonals
        if (board[0][0] == player &&
            board[1][1] == player &&
            board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player &&
            board[1][1] == player &&
            board[2][0] == player) {
            return true;
        }

        return false;
    }

    // Check draw
    public boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == Cell.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    // Print board
    public void printBoard() {
        System.out.println("\nBoard:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (board[i][j]) {
                    case X:
                        System.out.print(" X ");
                        break;
                    case O:
                        System.out.print(" O ");
                        break;
                    default:
                        System.out.print(" . ");
                        break;
                }

                if (j < 2) System.out.print("|");
            }
            System.out.println();

            if (i < 2) System.out.println("---+---+---");
        }
        System.out.println();
    }
}