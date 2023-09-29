package com.trip.api.dto;

public enum MessageType {
    N("N"),
    M("M");

    String type;

    MessageType(String type) {
        this.type = type;
    }
}
