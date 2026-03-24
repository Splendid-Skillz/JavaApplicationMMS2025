public class Exercise4_1_4 {
    public static void main(String[] args) {

        double principal = 1000.0; // initial amount
        int years = 10;

        for (int rate = 5; rate <= 10; rate++) {

            System.out.println("\nInterest Rate: " + rate + "%");
            System.out.println("Year\tAmount on Deposit");

            for (int year = 1; year <= years; year++) {
                double amount = principal * Math.pow(1.0 + rate / 100.0, year);
                System.out.printf("%d\t%.2f\n", year, amount);
            }
        }
    }
}