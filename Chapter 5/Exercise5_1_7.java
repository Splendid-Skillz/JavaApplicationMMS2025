import java.util.Scanner;

public class Exercise5_1_7 {

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int num;

        System.out.print("Enter an integer (0 to stop): ");
        num = input.nextInt();

        while (num != 0) {

            if (isEven(num))
                System.out.println(num + " is Even");
            else
                System.out.println(num + " is Odd");

            System.out.println();

            System.out.print("Enter an integer (0 to stop): ");
            num = input.nextInt();
        }

        input.close();
    }
}