package kz.aparking.paymentservice;

import java.util.List;

public interface PaymentRepository {
    Payment save(Payment payment);
    List<Payment> findByUserId(Long userId);
}
