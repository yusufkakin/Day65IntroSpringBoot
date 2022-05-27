package com.example.restservice;

public record Greeting2(long id, String content) {

    public Long getId() {
        return id;
    }
}