import Bank.CreditCard;
import Bank.Transaction;

public class Main {
    public static void main(String[] args) {
        CreditCard account = new CreditCard();

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

        account.withdraw(20_000);
    }
}