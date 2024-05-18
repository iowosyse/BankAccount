package Bank;

import AuxExceptions.InsufficientFundsException;
import AuxExceptions.NoNegativeOperationException;

import java.util.ArrayList;

public class BankAccount {
    private double balance = 0;
    public ArrayList<Transaction> transactions = new ArrayList<>();
    public ArrayList<Transaction> oldTransactions = new ArrayList<>();

    public double getBalance(){
        return balance;
    }

    public double checkCurrentBalance() {
        double amount = 0;

        for (Transaction theTransaction : transactions) {
            amount += theTransaction.getAmount();
        }

        return amount + balance;
    }

    public void deposit(double amount) {
        if (amount < 0)
            throw new NoNegativeOperationException("Can't do that");

        Transaction depositing = new Transaction(amount);
        depositing.setType("Deposit");
        transactions.add(depositing);

    }

    public void withdraw(double amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Can't do that");

        if ( checkCurrentBalance() - amount < 0)
            throw new InsufficientFundsException("Can't let you go broke lol");

        Transaction withdrawing = new Transaction(-amount);
        withdrawing.setType("Withdraw");
        transactions.add(withdrawing);

    }

    public void cutOffDate() {
        oldTransactions.addAll(transactions);

        for (Transaction toAdd : oldTransactions) {
            balance += toAdd.getAmount();
        }
    }

    public void showTransactions() {
        cutOffDate();

        System.out.printf("| %-8s | %-6s |%n", "Type", "Amount");
        System.out.println("----------------------");
        for (Transaction transaction : oldTransactions) {
            if (transaction.getType().equals("Withdraw"))
                transaction.setAmount(transaction.getAmount() * -1);
            System.out.printf("| %-8s | %-6s |%n", transaction.getType(), transaction.getAmount());
            if (transaction.getType().equals("Withdraw"))
                transaction.setAmount(transaction.getAmount() * -1);
        }
    }
}