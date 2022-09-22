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
