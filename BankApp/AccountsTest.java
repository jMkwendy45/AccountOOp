package BankApp;

import bankApp.Accounts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountsTest {
    private  Accounts accounts;
    @BeforeEach
    void setUP(){
        accounts = new Accounts("Duru","1234",234567908);
    }
    @Test
    public  void depositTest(){
      accounts.deposit(1500);
      assertEquals(1500,accounts.checkBalance("1234"));
    }
    @Test
    public  void CheckBalancePinWithWrongPinReturnZeroTest(){
        accounts.deposit(1500);
        assertEquals(0,accounts.checkBalance("1258"));
    }
    @Test
    public  void WithdrawMoneyTest(){
        accounts.deposit(8000);
        accounts.withdraw(4000,"1234");
        assertEquals(4000,accounts.checkBalance("1234"));
    }
    @Test
    public  void WithdrawWithWrongPinDoesntWork(){
        accounts.deposit(8000);
        accounts.withdraw(4000,"2312");
        assertEquals(8000,accounts.checkBalance("1234"));
    }
}
