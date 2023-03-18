package bankApp;

public class Accounts {
    private String accountName;
    private String pin;
    private int accountNumber;
    private int balance;

    public Accounts(String accountName, String pin, int accountNumber) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.pin = pin;
    }

    public void deposit(int amount) {
            if (amount <= 0) {
                throw  new IllegalArgumentException("Deposit amount must be greater than zero");
            }
            else balance += amount;
    }

    public int checkBalance(String pin) {
        if (pinIsCorrect(pin)) return balance;
        return 0;
    }
    private  boolean pinIsCorrect(String pin){
        return this.pin.equals(pin);
    }
    public void withdraw(int amount,String pin){
        if (pinIsCorrect(pin))balance -= amount;
    }
    public int getAccountNumber(){
        return  accountNumber;
    }
}
