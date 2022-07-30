package com.example.messagingstompwebsocket.dto;

public class IncomingMessage {

    private String name;

    public IncomingMessage() {
    }

    public IncomingMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
