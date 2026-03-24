import java.util.Scanner;

public class Exercise6_2_0 {
    private static final int SIZE = 20;

    public static void main(String[] args) {
        int[][] floor = new int[SIZE][SIZE];

        int row = 0;
        int col = 0;

        boolean penDown = false;
        int direction = 0; // 0=right, 1=down, 2=left, 3=up

        Scanner input = new Scanner(System.in);

        System.out.println("Enter commands (9 to stop):");

        while (true) {
            int command = input.nextInt();

            if (command == 1) {
                penDown = false;
            } 
            else if (command == 2) {
                penDown = true;
                floor[row][col] = 1;
            } 
            else if (command == 3) {
                direction = (direction + 1) % 4;
            } 
            else if (command == 4) {
                direction = (direction + 3) % 4;
            } 
            else if (command == 5) {
                int steps = input.nextInt();

                for (int i = 0; i < steps; i++) {
                    int newRow = row;
                    int newCol = col;

                    if (direction == 0) newCol++;
                    else if (direction == 1) newRow++;
                    else if (direction == 2) newCol--;
                    else if (direction == 3) newRow--;

                    // Check boundaries
                    if (newRow < 0 || newRow >= SIZE || newCol < 0 || newCol >= SIZE) {
                        System.out.println("Movement stopped: boundary reached.");
                        break;
                    }

                    row = newRow;
                    col = newCol;

                    if (penDown) {
                        floor[row][col] = 1;
                    }
                }
            } 
            else if (command == 6) {
                displayFloor(floor);
            } 
            else if (command == 9) {
                break;
            } 
        }

        input.close();
    }

    public static void displayFloor(int[][] floor) {
        for (int[] row : floor) {
            for (int cell : row) {
                System.out.print(cell == 1 ? "*" : " ");
            }
            System.out.println();
        }
    }
}