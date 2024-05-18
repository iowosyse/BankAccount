import Bank.CreditCard;

public class Main {
    public static CreditCard account = new CreditCard(25_000);
    public static boolean flag = true;

    public static void main(String[] args) {
        BankMenu.setMenu();

        while (flag) {
            BankMenu.display();
        }
    }
}