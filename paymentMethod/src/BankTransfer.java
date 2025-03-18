public class BankTransfer implements PaymentMethod {
    private String bankName;
    private String accountNumber;

    public BankTransfer(String bankName, String accountNumber) {
        this.bankName = bankName;
        this.accountNumber = accountNumber;
    }

    @Override
    public boolean proccessPayment(double amount) {
        System.out.println("Bank Transfer " + bankName + " " + accountNumber + " " + amount);
        // Payment succeed if amount <= 1000000
        return amount < 1000000;
    }

    @Override
    public void confirmPayment() {
        System.out.println("Bank Transfer " + bankName + " " + accountNumber + " has been confirmed");
    }
}
