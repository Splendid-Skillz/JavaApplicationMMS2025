public class Exercise6_1_4 {

    // method with variable-length argument list
    public static int product(int... numbers) {
        int result = 1;

        for (int num : numbers) {
            result *= num;
        }

        return result;
    }

    public static void main(String[] args) {

        // testing with different number of arguments
        System.out.println("Product of 2 numbers: " + product(2, 3));

        System.out.println("Product of 3 numbers: " + product(2, 3, 4));

        System.out.println("Product of 4 numbers: " + product(1, 2, 3, 4));

        System.out.println("Product of 5 numbers: " + product(5, 2, 1, 3, 2));
    }
}