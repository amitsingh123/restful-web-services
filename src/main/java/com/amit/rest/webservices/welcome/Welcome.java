package com.amit.rest.webservices.welcome;

public class Welcome {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Welcome(String message) {
        this.message = message;
    }
}
