package com.example;

public class CameraPhone extends Phone {

    private int megapixels;

    public CameraPhone() {
        super("", "", 1, 1, PhoneType.SMARTPHONE);
        this.classType = "CameraPhone";
    }

    public CameraPhone(String brand, String model, double price, int storage, PhoneType type, int megapixels) {
        super(brand, model, price, storage, type);

        this.classType = "CameraPhone";
        if (megapixels <= 0) {
            throw new IllegalArgumentException("Megapixels must be > 0");
        }

        this.megapixels = megapixels;
    }

    @Override
    public String toString() {
        return "CameraPhone: " + getBrand() + " " + getModel() +
                " | " + getPrice() + "$ | " + getStorage() + "GB | " + getType() +
                " | Camera: " + megapixels + "MP";
    }
}