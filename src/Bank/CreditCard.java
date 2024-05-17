package Bank;

public class CreditCard extends BankAccount{
    private double creditLimit;

    public CreditCard(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public void withdraw(double amount){
        if (checkCurrentBalance() - amount < (creditLimit * -1))
            throw new IllegalArgumentException("Can't do that");

        Transaction withdrawing = new Transaction(-amount);
        withdrawing.setType("Withdraw");
        transactions.add(withdrawing);
    }
}
