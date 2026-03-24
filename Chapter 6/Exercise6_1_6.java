public class Exercise6_1_6 {
    public static void main(String[] args) {

        double sum = 0.0;

        // enhanced for loop
        for (String value : args) {
            sum += Double.parseDouble(value);
        }

        System.out.println("Sum of values: " + sum);
    }
}