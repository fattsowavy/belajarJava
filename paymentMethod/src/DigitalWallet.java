class DigitalWallet implements PaymentMethod{
    private String walletId;
    private double balance;

    public DigitalWallet(String walletId, double balance){
        this.walletId = walletId;
        this.balance = balance;
    }

    @Override
    public boolean proccessPayment(double amount) {
        if (balance >= amount){
            System.out.println("Processed payment of " + amount + " from " + walletId);
            return true;
        } else {
            System.out.println("Balance not enough to process payment of " + amount + " from " + walletId);
            return false;
        }

    }
}
