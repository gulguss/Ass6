package Assign6;

import java.util.Scanner;

public class App {

public static void main(String [] args) {
    int i;
    DepositService ds = new DepositService();
    WithdrawalService ws = new WithdrawalService();
    Customer c1 = new Customer();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the name of the Customer");
    c1.setName(sc.next());
    System.out.println("Enter the current balance of the Customer");
    c1.setBalance(sc.nextDouble());
    System.out.println("1.Deposit");
    System.out.println("2.Withdraw");
    i=sc.nextInt();
    
    switch(i) {
    case 1:System.out.println("Enter the amount to be deposited");
    c1.setAmount(sc.nextDouble());
    ds.deposit(c1, c1.getAmount());
    break;
    
    case 2:System.out.println("Enter the amount to be withdrawn");
    c1.setWithdraw(sc.nextDouble());
        try {
            ws.withdraw(c1, c1.getWithdraw());
        } catch (InsufficiantFundsException e) {
            // TODO Auto-generated catch block
            e.getMessage();
        }catch(OverTheLimitException o) {
            o.getMessage();
        }
        
    break;
    
    default:System.out.println("Invalid option");
    break;
    
    
    
    }
    
    sc.close();
            
 }
}



package Assign6;

public class Customer {
 String name;
 double balance;
 double amount;
 double withdraw;
public Customer() {
    super();
    // TODO Auto-generated constructor stub
}
public Customer(String name, double balance, double amount, double withdraw) {
    super();
    this.name = name;
    this.balance = balance;
    this.amount = amount;
    this.withdraw = withdraw;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public double getBalance() {
    return balance;
}
public void setBalance(double balance) {
    this.balance = balance;
}
public double getAmount() {
    return amount;
}
public void setAmount(double amount) {
    this.amount = amount;
}
public double getWithdraw() {
    return withdraw;
}
public void setWithdraw(double withdraw) {
    this.withdraw = withdraw;
}
@Override
public String toString() {
    return "Customer [name=" + name + ", balance=" + balance + ", amount=" + amount + ", withdraw=" + withdraw + "]";
}

    
    
    
    
}

package Assign6;

public interface Deposit {
 void deposit(Customer customer , double amount);
}




package Assign6;

public class DepositService implements Deposit{

    @Override
    public void deposit(Customer customer, double amount) {
        // TODO Auto-generated method stub
        
        customer.setBalance(customer.getBalance()+amount);
        System.out.println("New balance" +customer.getBalance());
        
    }

    public DepositService() {
        super();
        // TODO Auto-generated constructor stub
    }

}




package Assign6;

public class InsufficiantFundsException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String message;
    public InsufficiantFundsException(String message) {
        super();
        this.message = message;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public String getMessage() {
        return message;
    }
    

}




package Assign6;

public class InsufficiantFundsException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String message;
    public InsufficiantFundsException(String message) {
        super();
        this.message = message;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public String getMessage() {
        return message;
    }
    

}




package Assign6;

public class OverTheLimitException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    String message;
    public OverTheLimitException(String message) {
        super();
        this.message = message;
    }

}





package Assign6;

public interface Withdrawal {
      double limit=50000;
      void withdraw(Customer customer , double withdraw)throws InsufficiantFundsException , OverTheLimitException;
}




package Assign6;

public class WithdrawalService implements Withdrawal {

    public WithdrawalService() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void withdraw(Customer customer, double withdraw)throws InsufficiantFundsException , OverTheLimitException {
        // TODO Auto-generated method stub
        if(withdraw>limit)
            throw new InsufficiantFundsException( "Cannot withdraw more than current balance");
        else if(withdraw>customer.getBalance())
            throw new OverTheLimitException("Cannot withdraw more that " + limit);
        else
            customer.setBalance(customer.getBalance()-withdraw);
        System.out.println("New balance is :" + customer.getBalance());
            
        
        
    }

}
