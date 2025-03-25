import java.util.Random;

class EWalletPayment extends PaymentMethod implements  FeeCalculator {
    private String otp;

    public EWalletPayment(String methodName, double diamondAmount, String otp) {
        super("E-Wallet", diamondAmount);
        this.otp = generateOtp();
    }

    @Override
    public void processPayment() {
        System.out.println("Payment via E-Wallet with OTP: " + otp);
        System.out.println("Total " + diamondAmount + " diamonds successfully processed.");
        System.out.println("Amount to pay: Rp" + totalCost);
    }

    @Override
    public double calculateFee(double diamondAmount) {
        return diamondAmount * 0.02;
    }

    private String generateOtp() {
        return String.valueOf(new Random().nextInt(9000) + 1000);
    }
}
