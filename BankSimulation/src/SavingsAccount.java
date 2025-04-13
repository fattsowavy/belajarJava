class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, Customer owner, double initialBalance, double interestRate) {
        super(accountNumber, owner, initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && getBalance() >= amount) {
            setBalance(getBalance() - amount);
            System.out.println("Tarik $" + amount + " dari " + getAccountNumber() + ". Saldo: $" + getBalance());
            return true;
        } else {
            System.out.println("Saldo tidak cukup / jumlah tidak valid!");
            return false;
        }
    }

    public void addInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
        System.out.println("Bunga $" + interest + " Ditambahkan");
    }
}
