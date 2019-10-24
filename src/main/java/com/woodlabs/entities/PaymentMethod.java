package com.woodlabs.entities;

public enum PaymentMethod {
    CARD("card"),
    CASH("cash");
    private final String paymentMethod;
    private PaymentMethod(String paymentMethod){
        this.paymentMethod=paymentMethod;
    }
}
