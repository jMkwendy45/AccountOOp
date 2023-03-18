package bankApp;

import javax.swing.*;

public class ATMmachine {
    private static Bank gtBank = new Bank("Gtbank");
    public static void main(String[] args) {
        displayMainMenu();

    }

    private static void displayMainMenu(){
        String mainMenu = """
                Welcome to GTB bank
                1 --> Create Account
                2 --> Deposit
                3 --> Withdraw
                4 --> Transfer
                5 --> Check Balance
                """;
        System.out.println(mainMenu);
        String userInput = input(mainMenu);
        switch (userInput.charAt(0)){
            case '1': {
                createAccount();
                break;
            }
            case '2': {
                deposit();
                break;
            }
            case '3': {
                withdraw();
            }
            case '4': {
                transfer();
            }
            case '5': {
                checkBalance();
                break;
            }
            default:
                errorMessage();
                displayMainMenu();
        }
    }

    private static void errorMessage() {
        display("Invalid input. Pick a number from those displayed in the menu");
    }

    private static void display(String message){
        JOptionPane.showMessageDialog(null, message);
    }

    private static String input(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }

    private static void transfer() {
        int amount = Integer.parseInt(input("How much do you want to transfer"));
        int senderAccountNumber = Integer.parseInt(input("What is your account number"));
        int receiverAccountNumber = Integer.parseInt(input("What is the receivers bank account number"));
        String senderPin = input("Enter your pin");

        gtBank.transfer(amount, senderAccountNumber, receiverAccountNumber, senderPin);
        System.out.printf("You have successfully transferred %d to %d", amount, receiverAccountNumber);
        displayMainMenu();
    }

    private static void withdraw() {
        int amount = Integer.parseInt(input("How much do you want to withdraw"));
        int accountNumber = Integer.parseInt(input("What is your account number"));
        String pin = input("Enter your pin");

        gtBank.withdraw(amount, accountNumber, pin);
        display("Collect your cash. Transaction successful");
        displayMainMenu();
    }

    private static void checkBalance() {
        int accountNumber = Integer.parseInt(input("What is our account number"));
        String pin = input("Oya type ya pin");
        int balance = gtBank.checkBalanceFor(accountNumber, pin);
        display("Your balance is "+balance);
        displayMainMenu();
    }

    private static void deposit() {
        int accountNumber = Integer.parseInt(input("What is your account number"));
        int amount = Integer.parseInt(input("How much do you want to deposit"));

        gtBank.depositInBank(amount, accountNumber);
        display("Deposited successfully");
        displayMainMenu();
    }

    private static void createAccount() {
//        Scanner scanner = new Scanner(System.in);
        String accountName = input("What is your account name"); // create account name
        String accountPin = input("What is your account pin");// create account pin

        gtBank.CreateAccountFor(accountName, accountPin); //create account from bank
        display("Account created successfully");
        displayMainMenu(); // return to main menu
    }
}


