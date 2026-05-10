package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneTest {

    @Test
    public void testPhoneCreation() {

        Phone phone = new SmartPhone(
                "Samsung",
                "S24",
                50000,
                256,
                PhoneType.SMARTPHONE,
                "Android"
        );

        assertEquals(
                "Samsung",
                phone.getBrand()
        );
    }

    @Test
    public void testPhoneEquals() {

        Phone p1 = new SmartPhone(
                "Apple",
                "iPhone 15",
                70000,
                128,
                PhoneType.SMARTPHONE,
                "iOS"
        );

        Phone p2 = new SmartPhone(
                "Apple",
                "iPhone 15",
                70000,
                128,
                PhoneType.SMARTPHONE,
                "iOS"
        );

        assertEquals(p1, p2);
    }
}