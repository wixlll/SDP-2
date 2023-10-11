package composite_design_pattern; // Package declaration

import java.util.ArrayList;
import java.util.List;

// Abstract class representing an Account
abstract class Account {
  public abstract float getBalance(); // Abstract method to get the account balance
}

// Concrete class for Deposit Account, extends Account
class DepositAccount extends Account {
  private String accountNo;
  private float accountBalance;

  public DepositAccount(String accountNo, float accountBalance) {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  public float getBalance() {
    return accountBalance;
  }
}

// Concrete class for Savings Account, extends Account
class SavingsAccount extends Account {
  private String accountNo;
  private float accountBalance;

  public SavingsAccount(String accountNo, float accountBalance) {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  public float getBalance() {
    return accountBalance;
  }
}

// Composite Account class that can hold multiple accounts, extends Account
class CompositeAccount extends Account {
  private float totalBalance;
  private List<Account> accountList = new ArrayList<Account>();

  public float getBalance() {
    totalBalance = 0;
    for (Account account : accountList) {
      totalBalance += account.getBalance();
    }
    return totalBalance;
  }

  public void addAccount(Account acc) {
    accountList.add(acc);
  }

  public void removeAccount(Account acc) {
    accountList.remove(acc);
  }
}

public class CompositePattern {
  public static void main(String[] args) {
    CompositeAccount component = new CompositeAccount();

    component.addAccount(new DepositAccount("DA001", 100));
    component.addAccount(new DepositAccount("DA002", 150));
    component.addAccount(new SavingsAccount("SA001", 200));

    float totalBalance = component.getBalance();
    System.out.println("Total Balance : " + totalBalance);
  }
}
