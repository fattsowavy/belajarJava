import java.util.Random;

class BankPayment extends PaymentMethod implements FeeCalculator{
    private String trancsactionCode;

    public BankPayment(String methodName, double diamondAmount, String trancsactionCode) {
        super("Bank", diamondAmount);
        this.trancsactionCode = generateTrancsactionCode();
    }

    @Override
    public void processPayment() {
        System.out.println("Payment via Bank with transaction code: " + trancsactionCode);
        System.out.println("Total: " + diamondAmount + " diamond succesfully added.");
        System.out.println("Amount paid: Rp" + totalCost);
    }

    @Override
    public double calculateFee(double diamondAmount) {
        return 5.0;
    }

    private String generateTrancsactionCode() {
        return "BANK" + new Random().nextInt(10000);
    }
}
