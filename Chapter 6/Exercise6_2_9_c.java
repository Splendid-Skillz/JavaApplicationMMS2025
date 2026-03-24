public class Exercise6_2_9_c {

    public static void main(String[] args) {

        double prev = 0;
        double curr = 1;
        int count = 1;

        while (!Double.isInfinite(curr)) {

            double next = prev + curr;

            prev = curr;
            curr = next;
            count++;
        }

        System.out.println("Largest Fibonacci (double): " + prev);
        System.out.println("Position n: " + (count - 1));
    }
}