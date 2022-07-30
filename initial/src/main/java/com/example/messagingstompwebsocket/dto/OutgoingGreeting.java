package com.example.messagingstompwebsocket.dto;

public class OutgoingGreeting {

    private String content;

    public OutgoingGreeting() {
    }

    public OutgoingGreeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
