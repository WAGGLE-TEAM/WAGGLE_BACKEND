package com.trip.api.type;

public enum MessageType {
    N("공지사항"),
    M("일반 메세지");

    String type;

    MessageType(String type) {
        this.type = type;
    }
}
