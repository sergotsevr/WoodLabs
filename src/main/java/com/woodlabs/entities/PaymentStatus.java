package com.woodlabs.entities;

public enum PaymentStatus {
    PAID("paid"),
    NOT_PAID("not paid");
    private final String paymentStatus;
    private PaymentStatus(String paymentStatus){
        this.paymentStatus=paymentStatus;
    }
}
