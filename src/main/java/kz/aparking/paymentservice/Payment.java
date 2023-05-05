package kz.aparking.paymentservice;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "car_number")
    private String carNumber;

    @Column(name = "minutes")
    private int minutes;

    @Column(name = "parking_spot_number")
    private String parkingSpotNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    public Payment() {}

    public Payment(Long userId, String carNumber, int minutes, String parkingSpotNumber) {
        this.userId = userId;
        this.carNumber = carNumber;
        this.minutes = minutes;
        this.parkingSpotNumber = parkingSpotNumber;
        this.createdAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

