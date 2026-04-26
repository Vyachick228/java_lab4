package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {

    @Test
    void shouldThrowExceptionWhenInvalidPriceInSetter() {
        Manufacturer m = new Manufacturer("Apple", "USA");
        Phone phone = new Phone("Apple", "iPhone", 1000, 128, PhoneType.SMARTPHONE, m);

        assertThrows(IllegalArgumentException.class, () -> {
            phone.setPrice(-1);
        });
    }

    @Test
    void shouldThrowExceptionWhenInvalidConstructorData() {
        Manufacturer m = new Manufacturer("Apple", "USA");

        assertThrows(IllegalArgumentException.class, () -> {
            new Phone("", "Model", -5, 0, PhoneType.SMARTPHONE, m);
        });
    }
}