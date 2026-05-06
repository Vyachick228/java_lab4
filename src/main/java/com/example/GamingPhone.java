package com.example;

public class GamingPhone extends Phone {

    private int fps;

    public GamingPhone(String brand, String model, double price, int storage, PhoneType type, int fps) {
        super(brand, model, price, storage, type);

        if (fps <= 0) {
            throw new IllegalArgumentException("FPS must be > 0");
        }

        this.fps = fps;
    }

    @Override
    public String toString() {
        return "GamingPhone: " + getBrand() + " " + getModel() +
                " | " + getPrice() + "$ | " + getStorage() + "GB | " + getType() +
                " | FPS: " + fps;
    }
}