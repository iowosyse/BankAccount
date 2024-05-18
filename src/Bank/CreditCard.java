package Bank;

import AuxExceptions.InsufficientFundsException;

public class CreditCard extends BankAccount{
    private double creditLimit;

    public CreditCard(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public void withdraw(double amount){
        if (checkCurrentBalance() - amount < (creditLimit * -1))
            throw new InsufficientFundsException("Can't let you go broke lol");

        Transaction withdrawing = new Transaction(-amount);
        withdrawing.setType("Withdraw");
        transactions.add(withdrawing);
    }
}
