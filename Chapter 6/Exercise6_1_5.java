public class Exercise6_1_5 {

    public static void main(String[] args) {

        int size = 10; // default size

        // check if command-line argument exists
        if (args.length > 0) {
            size = Integer.parseInt(args[0]);
        }

        int[] array = new int[size];

        // initialize array
        for (int i = 0; i < array.length; i++) {
            array[i] = 2 + 2 * i;
        }

        // display array
        System.out.printf("%s%8s%n", "Index", "Value");

        for (int i = 0; i < array.length; i++) {
            System.out.printf("%5d%8d%n", i, array[i]);
        }
    }
}