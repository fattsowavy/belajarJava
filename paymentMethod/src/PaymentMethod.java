interface PaymentMethod {

    boolean proccessPayment(double amount);

    default void confirmPayment(){
        System.out.println("Payment has been confirmed!");
    }

    static void paymentInfo(){
        System.out.println("The system supports various payment methods.");
    }
}
