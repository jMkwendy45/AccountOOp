package bankApp;

import java.util.ArrayList;

public class Bank {
    private int lastAccountGenerated;
    private String bankName;
    private ArrayList<Accounts> accounts;

    public Bank(String bankName) {
        this.bankName = bankName;
        accounts = new ArrayList<>();
    }
    public void CreateAccountFor(String acctName,String acctPin){
        int accountNumber = generateAccountNumber();
        Accounts newAccount = new Accounts(acctName,acctPin,accountNumber);
        accounts.add(newAccount);
    }
    private int generateAccountNumber(){
        return ++ lastAccountGenerated;
    }
    public int CountNumberOfAccounts(){
        return accounts.size();
    }
    public int checkBalanceFor(int acctNumb,String pin){
        Accounts  foundAccount = findAccountByAccountNumber(acctNumb);
        return foundAccount.checkBalance(pin);
    }
   private Accounts findAccountByAccountNumber(int acctNumb){
        for (Accounts account:accounts){
            boolean accountNumbMatches = account.getAccountNumber() == acctNumb;
            if (accountNumbMatches)return account;

        }
       return null;
   }
    public  void depositInBank(int amount, int acctNumb) {
            Accounts foundAccount = findAccountByAccountNumber(acctNumb);
            if (amount <= 0){
                throw  new IllegalArgumentException("Invalid deposit amount");
            }
            else foundAccount.deposit(amount);
    }

  public  void transfer(int amount,int senderAcct,int receiverAcct,String senderPin){
      Accounts senderAccount = findAccountByAccountNumber(senderAcct);
      Accounts receiverAccount = findAccountByAccountNumber(receiverAcct);
      senderAccount.withdraw(amount,senderPin);
      receiverAccount.deposit(amount);
    }
     public void withdraw(int amount, int accountNumber, String pin) {
        Accounts foundAccount = findAccountByAccountNumber(accountNumber);
        if (amount <= 0){throw  new IllegalArgumentException("Invalid withdrawal amount");}
        if (amount >foundAccount.checkBalance("1234")){
            throw  new IllegalArgumentException("Insufficient funds");
        }
        else foundAccount.withdraw(amount, pin);
    }

}
