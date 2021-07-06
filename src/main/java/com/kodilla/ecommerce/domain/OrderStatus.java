package com.kodilla.ecommerce.domain;

import lombok.Getter;

@Getter
public enum OrderStatus {
    NOT_PAID("Waiting for payment"),
    PAID("Received payment, order in queue"),
    PROCESSING("Preparing items for shipment, parcel will be dispatched soon"),
    SEND_TO_CUSTOMER("Parcel in delivery service"),
    ACCOMPLISHED("Parcel delivered");

    private String statusDescription;

    OrderStatus(String statusDescription) {
        this.statusDescription = statusDescription;
    }
}
