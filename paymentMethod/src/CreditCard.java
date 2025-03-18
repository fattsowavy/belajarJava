class CreditCard implements PaymentMethod {
    private String cardNumber;
    private String cardHolder;

    public CreditCard(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public boolean proccessPayment(double amount) {
        System.out.println("Processing " + amount + " with credit card (" + cardNumber + ")");
        // Payment success if amount > 0
        return amount > 0;
    }
}
