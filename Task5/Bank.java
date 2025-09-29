package task5;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private Account account;
    private List<Transaction> transactions;

    public Bank(Account account) {
        this.account = account;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        account.deposit(amount);
        transactions.add(new Transaction("Deposit", amount));
    }

    public void withdraw(double amount) {
        account.withdraw(amount);
        transactions.add(new Transaction("Withdraw", amount));
    }

    public void printTransactionHistory() {
        System.out.println("Transaction history for account " + account.getAccountNumber() + ":");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    public void printBalance() {
        System.out.println("Current balance: " + account.getBalance());
    }
}