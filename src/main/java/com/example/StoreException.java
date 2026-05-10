package com.example;

public class StoreException
        extends RuntimeException {

    public StoreException(
            String message
    ) {

        super(message);
    }
}