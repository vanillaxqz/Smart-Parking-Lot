package com.smartparkinglot.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Timestamp;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    @Column(name = "ownerID", nullable = true)
    private Long ownerUserID;  // Stores the ID of the User that made the reservation

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "plate", referencedColumnName = "plate", foreignKey = @ForeignKey(name = "fk_plate"))
    private Car car;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "parking_spot_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_parking_spot"))
    private ParkingSpot parkingSpot;

    @Column(name = "start_time")
    private Timestamp startTime;

    @Column(name = "stop_time")
    private Timestamp stopTime;

    @Column(name = "payment_confirmation", length = 500)
    private String paymentConfirmation;

    @Column(name = "status", length = 15)
    private String status;

    public Reservation() {
    }

    public Reservation(Long ownerUserID, Car car, ParkingSpot parkingSpot, Timestamp startTime, Timestamp stopTime) {
        this.ownerUserID = ownerUserID;
        this.car = car;
        this.parkingSpot = parkingSpot;
        this.startTime = startTime;
        this.stopTime = stopTime;
    }
    public Reservation(Long ownerUserID, ParkingSpot parkingSpot, Timestamp startTime, Timestamp stopTime) {
        this.ownerUserID = ownerUserID;
        this.parkingSpot = parkingSpot;
        this.startTime = startTime;
        this.stopTime = stopTime;
    }
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getStopTime() {
        return stopTime;
    }

    public void setStopTime(Timestamp stopTime) {
        this.stopTime = stopTime;
    }

    public String getPaymentConfirmation() {
        return paymentConfirmation;
    }

    public void setPaymentConfirmation(String paymentConfirmation) {
        this.paymentConfirmation = paymentConfirmation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}