import Bank.CreditCard;
import Bank.Transaction;

public class Main {
    public static void main(String[] args) {
        CreditCard account = new CreditCard(25_000);

        account.deposit(400);
        account.withdraw(200);
        account.cutOffDate();

        System.out.printf("| %-8s | %-6s |%n", "Type", "Amount");
        System.out.println("----------------------");
        for (Transaction transaction : account.oldTransactions) {
            if (transaction.getType().equals("Withdraw"))
                transaction.setAmount(transaction.getAmount() * -1);
            System.out.printf("| %-8s | %-6s |%n", transaction.getType(), transaction.getAmount());
            if (transaction.getType().equals("Withdraw"))
                transaction.setAmount(transaction.getAmount() * -1);
        }
        System.out.println("----------------------");
        System.out.println("Balance after cutoff date: " + account.getBalance());
        System.out.println();

        account.withdraw(200);
        account.withdraw(15_000);

        System.out.printf("| %-8s | %-6s |%n", "Type", "Amount");
        System.out.println("----------------------");
        for (Transaction transaction : account.transactions) {
            if (transaction.getType().equals("Withdraw"))
                transaction.setAmount(transaction.getAmount() * -1);
            System.out.printf("| %-8s | %-6s |%n", transaction.getType(), transaction.getAmount());
            if (transaction.getType().equals("Withdraw"))
                transaction.setAmount(transaction.getAmount() * -1);
        }

        try {
            System.out.println("Try to withdraw $20,000"); //credit limit is 25,000
            account.withdraw(20_000);
        } catch (IllegalArgumentException e) {
            System.out.println("Catch clause.");
        } finally {
            System.out.println("If entered the catch clause the credit limit was exceeded. If not it means everything is good.");
        }
    }
}