package models;

public class Account {
    private String accountHolder;
    private double balance = 0;

    public Account(String account) {
        this.accountHolder = account;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double depositValue){
        balance += depositValue;
        showInformation();
    }

    public void withdraw(double withdrawValue){
        if(withdrawValue > balance) {
            System.out.println("Invalid operation, insufficient balance.");
        }else{
            balance -= withdrawValue;
            showInformation();
        }
    }

    public void showInformation(){
        System.out.printf("Account: %s - Balance: %.2f.\n", accountHolder,balance);
    }
}
