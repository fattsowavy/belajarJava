abstract class PaymentMethod {
    protected String methodName;
    protected double diamondAmount;
    protected double totalCost;

    public PaymentMethod(String methodName, double diamondAmount) {
        this.methodName = methodName;
        this.diamondAmount = diamondAmount;
    }

    public abstract void processPayment();

    public double getDiamondAmount() {
        return diamondAmount;
    }

    public String getMethodName() {
        return methodName;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}

