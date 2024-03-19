package Bank;

public class CreditCard extends BankAccount{
    private final double creditLimit = 25000;

    @Override
    public void withdraw(double amount){
        if (checkCurrentBalance() - amount < (creditLimit * -1))
            System.out.println("Cannot withdraw that amount");
        else {
            Transaction withdrawing = new Transaction(-amount);
            withdrawing.setType("Withdraw");
            transactions.add(withdrawing);
        }
    }
}
