package com.trip.api;

public class JacocoTest {

    public String hello(String name) {
        switch (name) {
            case "바":
                return "보";
            case "hello":
                return "world";
            default:
                return "error";
        }
    }

    public String bye() {
        return "안녕히가세요!";
    }
}
