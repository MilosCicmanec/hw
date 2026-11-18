package Payment;

public interface RefundablePayment extends Payment {
    void refund();
}
