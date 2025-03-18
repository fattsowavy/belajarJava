class OnlineStore {
    private PaymentMethod paymentMethod;

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void checkout(double totalAmount) {
        System.out.println("Total amount: " + totalAmount);
        if (paymentMethod.proccessPayment(totalAmount)) {
            paymentMethod.confirmPayment();
            System.out.println("Confirmed!");
        } else {
            System.out.println("Checkout failed!. Please try again.");
        }
    }
}
