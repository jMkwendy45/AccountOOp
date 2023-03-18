package BankApp;

import bankApp.Bank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankTest {
    private Bank gtBank;
    @BeforeEach
    public  void StartWithThis(){
        gtBank = new Bank("Guaranteed Trust Bank");
        gtBank.CreateAccountFor("KinzyBoy","Pin");
    }
    @Test
    public void createAccount(){
        gtBank = new Bank("Guaranteed Trust Bank");
        gtBank.CreateAccountFor("KinzyBoy","Pin");
        assertEquals(1,gtBank.CountNumberOfAccounts());

    }
    @Test
    public void  checkBalanceOfNewAccountIsZeroByDefault(){
        assertEquals(0,gtBank.checkBalanceFor(1,"1234"));
    }
    @Test
    public  void depositCheckBalanceTest(){
        gtBank.depositInBank(5000,1);
        assertEquals(5000,gtBank.checkBalanceFor(1,"Pin"));
    }
    @Test
    public void TransferMoneyTest(){
        gtBank.CreateAccountFor("Fb","receiverPin");
        gtBank.depositInBank(4500,1);
       gtBank.transfer(2000,1,2,"Pin");
        assertEquals(2500,gtBank.checkBalanceFor(1,"Pin"));
        assertEquals(2000,gtBank.checkBalanceFor(2,"receiverPin"));
    }

    @Test
    public void cannotDepositAmountZeroAndBelow(){
        int invalidDepositAmountToBank = -200;
        assertThrows(IllegalArgumentException.class,()-> gtBank.depositInBank(invalidDepositAmountToBank, 1));
    }

    @Test
    public void withdrawMoneyTest(){
            gtBank.depositInBank(5000, 1);
            gtBank.withdraw(2000,1,"Pin");
            assertEquals(3000,gtBank.checkBalanceFor(1,"Pin"));
        }


    @Test
    public void cannotWithdrawMoneyBelowBalance(){
        gtBank.depositInBank(5000, 1);
        int invalidWithdrawalRequestFromBank = -2000;
        assertThrows(IllegalArgumentException.class, ()-> gtBank.withdraw(invalidWithdrawalRequestFromBank,
                1, "1234"));
    }

    @Test
    public void cannotWithdrawMoneyAboveBalance(){
        gtBank.depositInBank(5000, 1);
        int invalidWithdrawalRequestFromBank = 7000;
        assertThrows(IllegalArgumentException.class, ()-> gtBank.withdraw(invalidWithdrawalRequestFromBank, 1, "1234"));
    }





}
