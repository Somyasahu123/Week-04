package implement_a_banking_system;

import java.util.*;

class BankingSystem {
    private Map<Integer, Double> accounts = new HashMap<>(); // AccountNumber -> Balance
    private Queue<Integer> withdrawalQueue = new LinkedList<>(); // Queue for withdrawal requests

    // Create an account
    public void createAccount(int accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
    }

    // Deposit money
    public void deposit(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, accounts.get(accountNumber) + amount);
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    // Request a withdrawal
    public void requestWithdrawal(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    // Process withdrawals
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            if (accounts.get(accountNumber) >= 100) { // Ensuring minimum balance
                accounts.put(accountNumber, accounts.get(accountNumber) - 100);
                System.out.println("Withdrawal of $100 processed for Account " + accountNumber);
            } else {
                System.out.println("Insufficient balance for Account " + accountNumber);
            }
        }
    }

    // Display accounts sorted by balance
    public void displaySortedAccounts() {
        TreeMap<Double, Integer> sortedByBalance = new TreeMap<>();

        for (var entry : accounts.entrySet()) {
            sortedByBalance.put(entry.getValue(), entry.getKey());
        }

        System.out.println("\nAccounts Sorted by Balance:");
        for (var entry : sortedByBalance.entrySet()) {
            System.out.println("Account " + entry.getValue() + " -> Balance: $" + entry.getKey());
        }
    }
}

public class BankingSystemApp {
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // Creating accounts
        bank.createAccount(1001, 500);
        bank.createAccount(1002, 1500);
        bank.createAccount(1003, 800);

        // Depositing money
        bank.deposit(1001, 200);
        bank.deposit(1002, 300);

        // Requesting withdrawals
        bank.requestWithdrawal(1001);
        bank.requestWithdrawal(1002);
        bank.requestWithdrawal(1003);

        bank.processWithdrawals();
        bank.displaySortedAccounts();
    }
}

