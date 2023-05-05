package kz.aparking.paymentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/pay")
    public PaymentResult payForParking(@RequestParam("userId") Long userId,
                                       @RequestParam("carNumber") String carNumber,
                                       @RequestParam("minutes") int minutes,
                                       @RequestParam("parkingSpotNumber") String parkingSpotNumber) {
        return paymentService.payForParking(userId, carNumber, minutes, parkingSpotNumber);
    }

    @GetMapping("/history")
    public List<Payment> getPayments(@RequestParam("userId") Long userId) {
        return paymentService.getPayments(userId);
    }
}

