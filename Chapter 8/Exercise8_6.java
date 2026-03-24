public class Exercise8_6 {

    public static class SavingsAccount {
        private static double annualInterestRate;
        private double savingsBalance;

        // Constructor
        public SavingsAccount(double balance) {
            this.savingsBalance = balance;
        }

        // Calculate monthly interest and update balance
        public void calculateMonthlyInterest() {
            double monthlyInterest = savingsBalance * (annualInterestRate / 12.0);
            savingsBalance += monthlyInterest;
        }

        // Static method to modify interest rate
        public static void modifyInterestRate(double newRate) {
            annualInterestRate = newRate;
        }

        // Getter
        public double getSavingsBalance() {
            return savingsBalance;
        }
    }

    // Main method (test program)
    public static void main(String[] args) {

        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);

        // Set interest rate to 4%
        SavingsAccount.modifyInterestRate(0.04);

        System.out.println("=== Monthly Balances at 4% Interest ===");

        // 12 months
        for (int i = 1; i <= 12; i++) {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();

            System.out.printf("Month %d:%n", i);
            System.out.printf("Saver1: %.2f%n", saver1.getSavingsBalance());
            System.out.printf("Saver2: %.2f%n%n", saver2.getSavingsBalance());
        }

        // Change interest rate to 5%
        SavingsAccount.modifyInterestRate(0.05);

        // Next month
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.println("=== After Increasing Interest Rate to 5% ===");
        System.out.printf("Saver1: %.2f%n", saver1.getSavingsBalance());
        System.out.printf("Saver2: %.2f%n", saver2.getSavingsBalance());
    }
}