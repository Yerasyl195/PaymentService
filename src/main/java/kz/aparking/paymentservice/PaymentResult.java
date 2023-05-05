package kz.aparking.paymentservice;

public class PaymentResult {
    private boolean success;
    private String message;
    private Long paymentId;

    public PaymentResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public PaymentResult(boolean success, String message, Long paymentId) {
        this.success = success;
        this.message = message;
        this.paymentId = paymentId;
    }

    public Long getPaymentId() {
        return paymentId;
    }


    // Getters and setters
}

