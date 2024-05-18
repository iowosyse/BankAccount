import Bank.BankAccount;

import java.util.HashMap;
import java.util.Scanner;

public class BankMenu {
    public static HashMap<Integer, MenuItem> menu = new HashMap<>();


    public static void setMenu() {
        MenuItem deposit = new MenuItem("Deposit", Main.account);
        MenuItem withdraw = new MenuItem("Withdraw", Main.account);
        MenuItem getBalance = new MenuItem("Get balance", Main.account);
        MenuItem cutoffDate = new MenuItem("Cutoff date", Main.account);
        MenuItem showTransactions = new MenuItem("Show Transactions (This makes a cutoff date automatically)", Main.account);

        menu.put(1, deposit);
        menu.put(2, withdraw);
        menu.put(3, getBalance);
        menu.put(4, cutoffDate);
        menu.put(5, showTransactions);

    }

    public static void display() {
        Scanner sc =  new Scanner(System.in);

        System.out.println("-------------------------");

        for (Integer key : menu.keySet()) {
            MenuItem item = menu.get(key);
            System.out.printf("%s: %s.%n", key, item.getText());
        }
        System.out.println("0: Finish.");

        System.out.print("Select an option: ");
        int opt = sc.nextInt();
        sc.nextLine();

        if (opt == 0) {
            Main.flag = false;
        } else {
            if (!menu.containsKey(opt))
                System.out.println("Invalid option");
            else
                menu.get(opt).execute();
        }

        System.out.println("-------------------------");
        System.out.println();
    }
}

@FunctionalInterface
interface iMenuItem {
    void execute();
}

class MenuItem implements iMenuItem{
    Scanner sc = new Scanner(System.in);
    String text;
    BankAccount acc;

    public MenuItem(String text, BankAccount acc) {
        this.text = text;
        this.acc = acc;
    }

    public String getText() {
        return text;
    }

    @Override
    public void execute() {
        switch (text) {
            case "Show Transactions" -> acc.showTransactions();
            case "Cutoff date" -> acc.cutOffDate();
            case "Get balance" -> System.out.println("Your balance is: " + acc.checkCurrentBalance());
            default -> {
                int amount;

                System.out.print("Enter the amount: ");
                amount = sc.nextInt();
                sc.nextLine();
                if (text.equals("Deposit"))
                    acc.deposit(amount);
                else
                    acc.withdraw(amount);
            }
        }

        System.out.println("Success!");
    }
}