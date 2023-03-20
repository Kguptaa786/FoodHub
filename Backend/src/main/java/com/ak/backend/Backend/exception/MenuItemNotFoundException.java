package com.ak.backend.Backend.exception;

public class MenuItemNotFoundException extends Exception {
    public MenuItemNotFoundException(String message, long itemId) {
        super(message);
    }
}
