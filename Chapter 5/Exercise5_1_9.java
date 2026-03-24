import java.util.Scanner;

public class Exercise5_1_9 {

    // Method to display a square using a specified character
    public static void squareOfChar(int side, char fillCharacter) {
        for (int row = 1; row <= side; row++) {
            for (int col = 1; col <= side; col++) {
                System.out.print(fillCharacter);
            }
            System.out.println(); // move to next row
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Read side length
        System.out.print("Enter the side length of the square: ");
        int side = input.nextInt();

        // Read fill character
        System.out.print("Enter the fill character: ");
        char fill = input.next().charAt(0);

        // Call method to display the square
        squareOfChar(side, fill);
    }
}