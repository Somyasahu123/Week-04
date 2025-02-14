package checked_custom;

class InsufficientBalanceException extends Exception { // Custom exception for insufficient balance
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) { // Initialize account with balance
        this.balance = initialBalance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException, IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!"); // Handle negative amount
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!"); // Handle low balance
        }
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }
}

public class BankTransactionSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000); // Create account with initial balance

        try {
            account.withdraw(6000); // Attempt to withdraw
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage() + " InsufficientBalanceException");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " IllegalArgumentException");
        }

        try {
            account.withdraw(-20); // Attempt to withdraw
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage() + " InsufficientBalanceException");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " IllegalArgumentException");
        }
    }
}


