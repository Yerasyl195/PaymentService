package kz.aparking.paymentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    //private final ParkingSpotRepository parkingSpotRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public PaymentResult payForParking(long userId, String carNumber, int minutes, String parkingSpotNumber) {

        // Make the payment
        Payment payment = new Payment(userId, carNumber, minutes, parkingSpotNumber);
        paymentRepository.save(payment);


        return new PaymentResult(true, "Payment successful", payment.getId());
    }

    @Override
    public List<Payment> getPayments(long userId) {
        return paymentRepository.findByUserId(userId);
    }
}

