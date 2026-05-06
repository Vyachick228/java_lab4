package com.example;

public class BusinessPhone extends Phone {

    private boolean hasSecurity;

    public BusinessPhone() {
        super("", "", 1, 1, PhoneType.SMARTPHONE);
        this.classType = "BusinessPhone";
    }

    public BusinessPhone(String brand, String model, double price, int storage, PhoneType type, boolean hasSecurity) {
        super(brand, model, price, storage, type);

        this.classType = "BusinessPhone";
        this.hasSecurity = hasSecurity;
    }

    @Override
    public String toString() {
        return "BusinessPhone: " + getBrand() + " " + getModel() +
                " | " + getPrice() + "$ | " + getStorage() + "GB | " + getType() +
                " | Security: " + (hasSecurity ? "Yes" : "No");
    }
}