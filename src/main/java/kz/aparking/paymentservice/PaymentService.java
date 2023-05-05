package kz.aparking.paymentservice;

import java.util.List;

public interface PaymentService {
    PaymentResult payForParking(long userId, String carNumber, int minutes, String parkingSpotNumber);
    List<Payment> getPayments(long userId);
}


