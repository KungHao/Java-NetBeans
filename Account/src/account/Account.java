package account;


public class Account {
    private int balance;
    
    public void account(int initialAmount) {
        if(initialAmount>0)
            this.balance = initialAmount;
        else{
            System.out.println("Balance cannot be negative.");
            System.exit(0);}
    }
    
    public int getBalance() {
        return balance;
    }
    
    public void add(int amount) {
        this.balance += amount;
    }
    
    public void minus(int amount){
        this.balance -= amount;
    }
    
    public void check(int balance){
        if (balance < 0){
            System.out.println("未開戶!\n");
        }
    }
    
}
