class EWalletPayment extends PaymentMethod implements  FeeCalculator {
    private String otp;

    public EWalletPayment(String methodName, double diamondAmount, String otp) {
        super("E-Wallet", diamondAmount);
        this.otp = generateOtp();
    }

    @Override
    public void processPayment() {
        System.out.println("Payment via E");
    }
}
