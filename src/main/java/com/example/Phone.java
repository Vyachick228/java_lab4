package com.example;

import java.util.UUID;

// Абстрактний клас Phone описує мобільний телефон.
public abstract class Phone
        implements Comparable<Phone>, Identifiable {

    protected UUID uuid;

    protected String brand;
    protected String model;
    protected double price;
    protected int storage;
    protected PhoneType type;
    protected String classType;

    public Phone() {

        uuid = UUID.randomUUID();
    }

    // Конструктор з параметрами.
    public Phone(
            String brand,
            String model,
            double price,
            int storage,
            PhoneType type
    ) {

        uuid = UUID.randomUUID();

        setBrand(brand);
        setModel(model);
        setPrice(price);
        setStorage(storage);
        setType(type);
    }

    // Копіюючий конструктор
    public Phone(Phone other) {

        this.uuid = other.uuid;
        this.brand = other.brand;
        this.model = other.model;
        this.price = other.price;
        this.storage = other.storage;
        this.type = other.type;
        this.classType = other.classType;
    }

    @Override
    public UUID getUuid() {

        return uuid;
    }

    // Реалізація Comparable
    @Override
    public int compareTo(Phone other) {

        return this.brand.compareToIgnoreCase(
                other.brand
        );
    }

    public String getBrand() {

        return brand;
    }

    public String getModel() {

        return model;
    }

    public double getPrice() {

        return price;
    }

    public int getStorage() {

        return storage;
    }

    public PhoneType getType() {

        return type;
    }

    public void setBrand(String brand) {

        if (brand == null || brand.isEmpty()) {

            throw new PhoneException(
                    "Brand cannot be empty"
            );
        }

        this.brand = brand;
    }

    public void setModel(String model) {

        if (model == null || model.isEmpty()) {

            throw new PhoneException(
                    "Model cannot be empty"
            );
        }

        this.model = model;
    }

    public void setPrice(double price) {

        if (price <= 0) {

            throw new PhoneException(
                    "Price must be > 0"
            );
        }

        this.price = price;
    }

    public void setStorage(int storage) {

        if (storage <= 0) {

            throw new PhoneException(
                    "Storage must be > 0"
            );
        }

        this.storage = storage;
    }

    public void setType(PhoneType type) {

        if (type == null) {

            throw new PhoneException(
                    "Type cannot be null"
            );
        }

        this.type = type;
    }

    @Override
    public String toString() {

        return "UUID: " + uuid +
                "\n" + brand + " " + model +
                " | " + price + "$ | " +
                storage + "GB | " + type;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {

            return true;
        }

        if (!(obj instanceof Phone other)) {

            return false;
        }

        return brand.equals(other.brand) &&
                model.equals(other.model) &&
                price == other.price &&
                storage == other.storage &&
                type == other.type;
    }
}