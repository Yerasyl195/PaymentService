package kz.aparking.paymentservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentRepositoryImpl implements PaymentRepository {

    private Map<Long, List<Payment>> payments = new HashMap<>();
    private long paymentId = 0;

    @Override
    public Payment save(Payment payment) {
        if (payment.getId() == null) {
            payment.setId(++paymentId);
        }
        List<Payment> userPayments = payments.get(payment.getUserId());
        if (userPayments == null) {
            userPayments = new ArrayList<>();
            payments.put(payment.getUserId(), userPayments);
        }
        userPayments.add(payment);
        return payment;
    }

    @Override
    public List<Payment> findByUserId(Long userId) {
        return payments.getOrDefault(userId, new ArrayList<>());
    }
}

