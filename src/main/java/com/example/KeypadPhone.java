package com.example;

public class KeypadPhone extends Phone {

    private int buttons;

    public KeypadPhone() {
        super("", "", 1, 1, PhoneType.BUTTON);
        this.classType = "KeypadPhone";
    }

    public KeypadPhone(String brand, String model, double price, int storage, PhoneType type, int buttons) {
        super(brand, model, price, storage, type);

        this.classType = "KeypadPhone";
        if (buttons <= 0) {
            throw new IllegalArgumentException("Buttons must be > 0");
        }

        this.buttons = buttons;
    }

    @Override
    public String toString() {
        return "KeypadPhone: " + getBrand() + " " + getModel() +
                " | " + getPrice() + "$ | " + getStorage() + "GB | " + getType() +
                " | Buttons: " + buttons;
    }
}