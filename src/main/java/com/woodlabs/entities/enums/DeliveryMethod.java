package com.woodlabs.entities.enums;

public enum DeliveryMethod {
    PICKUP("pickup"),
    DEPENDING_ON_WEIGHT("Depending on weight"),
    DEPENDING_ON_DISTANCE("Depending on DISTANCE");
    private final String deliveryMethod;

    private DeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }
}
