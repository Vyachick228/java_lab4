package com.example;

/**
 * Клас Phone описує мобільний телефон.
 */
public class Phone {
    private static int count = 0;

    private String brand;
    private String model;
    private double price;
    private int storage;
    private PhoneType type;
    private Manufacturer manufacturer;

    /**
     * Конструктор з параметрами.
     * Використовує сеттери для перевірки коректності даних.
     */
    public Phone(String brand, String model, double price, int storage, PhoneType type, Manufacturer manufacturer) {
        setBrand(brand);
        setModel(model);
        setPrice(price);
        setStorage(storage);

        if (type == null) {
            throw new IllegalArgumentException("Type cannot be null");
        }
        if (manufacturer == null) {
            throw new IllegalArgumentException("Manufacturer cannot be null");
        }

        this.type = type;
        this.manufacturer = manufacturer;

        count++;
    }

    /**
     * Копіюючий конструктор
     */
    public Phone(Phone other) {
        this(other.brand, other.model, other.price, other.storage, other.type, other.manufacturer);
    }

    /**
     * Повертає кількість створених об'єктів
     */
    public static int getCount() {
        return count;
    }

    /**
     * Повертає бренд телефону
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Повертає модель телефону
     */
    public String getModel() {
        return model;
    }

    /**
     * Повертає ціну телефону
     */
    public double getPrice() {
        return price;
    }

    /**
     * Повертає обсяг пам'яті телефону
     */
    public int getStorage() {
        return storage;
    }

    /**
     * Повертає тип телефону
     */
    public PhoneType getType() {
        return type;
    }

    /**
     * Повертає виробника телефону
     */
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    /**
     * Встановлює бренд телефону
     */
    public void setBrand(String brand) {
        if (brand == null || brand.isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be empty");
        }
        this.brand = brand;
    }

    /**
     * Встановлює модель телефону
     */
    public void setModel(String model) {
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Model cannot be empty");
        }
        this.model = model;
    }

    /**
     * Встановлює ціну телефону
     */
    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be > 0");
        }
        this.price = price;
    }

    /**
     * Встановлює обсяг пам'яті телефону
     */
    public void setStorage(int storage) {
        if (storage <= 0) {
            throw new IllegalArgumentException("Storage must be > 0");
        }
        this.storage = storage;
    }

    /**
     * Встановлює тип телефону
     */
    public void setType(PhoneType type) {
        if (type == null) {
            throw new IllegalArgumentException("Type cannot be null");
        }
        this.type = type;
    }

    /**
     * Встановлює виробника телефону
     */
    public void setManufacturer(Manufacturer manufacturer) {
        if (manufacturer == null) {
            throw new IllegalArgumentException("Manufacturer cannot be null");
        }
        this.manufacturer = manufacturer;
    }

    /**
     * Повертає рядкове представлення об'єкта
     */
    @Override
    public String toString() {
        return brand + " " + model + " | " + price + "$ | " + storage + "GB | " + type + " | " + manufacturer;
    }

    /**
     * Порівнює два об'єкти Phone
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Phone)) return false;

        Phone other = (Phone) obj;

        return brand.equals(other.brand) &&
                model.equals(other.model) &&
                price == other.price &&
                storage == other.storage &&
                type == other.type &&
                manufacturer.equals(other.manufacturer);
    }
}