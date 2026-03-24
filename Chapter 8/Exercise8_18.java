import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Exercise8_18 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Account account = new Account("Jane Doe", new BigDecimal("100.00"));

        System.out.println("Initial account:");
        account.displayAccount();

        System.out.print("\nEnter deposit amount: ");
        BigDecimal depositAmount = input.nextBigDecimal();
        account.deposit(depositAmount);

        System.out.print("Enter withdrawal amount: ");
        BigDecimal withdrawalAmount = input.nextBigDecimal();
        account.withdraw(withdrawalAmount);

        System.out.println("\nUpdated account:");
        account.displayAccount();

        input.close();
    }
}

class Account {

    private String name;
    private BigDecimal balance;

    // Constructor
    public Account(String name, BigDecimal balance) {
        this.name = name;
        this.balance = balance.setScale(2, RoundingMode.HALF_EVEN);
    }

    // Deposit
    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Deposit must be positive.");
            return;
        }
        balance = balance.add(amount).setScale(2, RoundingMode.HALF_EVEN);
    }

    // Withdraw
    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Withdrawal must be positive.");
            return;
        }

        if (amount.compareTo(balance) > 0) {
            System.out.println("Withdrawal amount exceeded account balance.");
            return;
        }

        balance = balance.subtract(amount).setScale(2, RoundingMode.HALF_EVEN);
    }

    // Display account details
    public void displayAccount() {
        System.out.printf("Account name: %s%n", name);
        System.out.printf("Balance: $%s%n", balance.toString());
    }

    // Getter (optional)
    public BigDecimal getBalance() {
        return balance;
    }

    // Setter (optional)
    public void setBalance(BigDecimal balance) {
        this.balance = balance.setScale(2, RoundingMode.HALF_EVEN);
    }
}