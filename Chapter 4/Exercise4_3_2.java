public class Exercise4_3_2 {
    public static void main(String[] args) {

        double users = 1_000_000_000; // 1 billion
        double rate = 0.04;
        int months = 0;

        double target1 = 1_500_000_000; // 1.5 billion
        double target2 = 2_000_000_000; // 2 billion

        double currentUsers = users;

        while (currentUsers < target2) {
            currentUsers = currentUsers * (1 + rate);
            months++;

            if (currentUsers >= target1 && currentUsers / (1 + rate) < target1) {
                System.out.println("Months to reach 1.5 billion users: " + months);
            }

            if (currentUsers >= target2) {
                System.out.println("Months to reach 2 billion users: " + months);
            }
        }
    }
}