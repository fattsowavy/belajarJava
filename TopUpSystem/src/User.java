class User {
    private String userId;

    public User(String userId) {
        this.userId = userId;
    }

    public void topUpDiamond(PaymentMethod method) {
        System.out.println("Processing top-up for User IDs: " + userId + " via " + method.getMethodName());
        method.processPayment();
        System.out.println();
    }
}
