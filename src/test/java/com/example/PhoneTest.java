package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {

    @Test
    void shouldThrowExceptionWhenInvalidPriceInSetter() {
        Phone phone = new Phone("Apple", "iPhone", 1000, 128);

        assertThrows(IllegalArgumentException.class, () -> {
            phone.setPrice(-1);
        });
    }

    @Test
    void shouldThrowExceptionWhenInvalidConstructorData() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Phone("", "Model", -5, 0);
        });
    }
}