abstract class Account {
    private String accountNumber;
    private double balance;
    private Customer owner;

    public Account(String accountNumber, Customer owner, double initialBalance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public Customer getOwner() {
        return owner;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Setor $" + amount + " ke " + accountNumber + ". Saldo: " + balance);
        } else {
            System.out.println("Jumlah setor tidak boleh negatif!");
        }
    }

    public abstract boolean withdraw(double amount);

    public void showInfo() {
        System.out.println("Account number: " + accountNumber ", Owner: " + owner.getName() + ", Saldo: $" + balance);

    }
}
