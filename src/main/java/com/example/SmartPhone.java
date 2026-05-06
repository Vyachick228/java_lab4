package com.example;

public class SmartPhone extends Phone {
    private String os;

    public SmartPhone(String brand, String model, double price, int storage, PhoneType type, String os) {
        super(brand, model, price, storage, type);

        this.classType = "SmartPhone";
        if (os == null || os.isEmpty()) {
            throw new IllegalArgumentException("OS cannot be empty");
        }

        this.os = os;
    }

    @Override
    public String toString() {
        return "SmartPhone: " + getBrand() + " " + getModel() +
                " | " + getPrice() + "$ | " + getStorage() + "GB | " + getType() +
                " | OS: " + os;
    }
}