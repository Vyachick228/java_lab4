package com.example;

import java.util.ArrayList;
import java.util.Collections;


// Клас Store зберігає телефони та їх кількість
public class Store {

    // Колекція телефонів
    private final ArrayList<Phone> phones;

    // Колекція кількостей
    private final ArrayList<Integer> quantities;

    // Конструктор
    public Store() {

        phones = new ArrayList<>();
        quantities = new ArrayList<>();
    }

    // Додавання телефону в магазин
    public void addNewPhone(Phone ph, int quantity) {

        for (int i = 0; i < phones.size(); i++) {

            // Якщо телефон вже існує
            if (phones.get(i).equals(ph)) {

                int currentQuantity = quantities.get(i);

                quantities.set(i, currentQuantity + quantity);

                return;
            }
        }

        // Якщо телефон новий
        phones.add(ph);
        quantities.add(quantity);
    }

    // Пошук за брендом
    public void searchByBrand(String brand) {

        boolean found = false;

        for (int i = 0; i < phones.size(); i++) {

            Phone p = phones.get(i);

            if (p.getBrand().equalsIgnoreCase(brand)) {

                System.out.println(p);
                System.out.println("Кількість: " + quantities.get(i));

                found = true;
            }
        }

        if (!found) {

            System.out.println("Телефони не знайдені.");
        }
    }

    // Пошук за типом
    public void searchByType(String type) {

        boolean found = false;

        for (int i = 0; i < phones.size(); i++) {

            Phone p = phones.get(i);

            if (p.getClass().getSimpleName().equalsIgnoreCase(type)) {

                System.out.println(p);
                System.out.println("Кількість: " + quantities.get(i));

                found = true;
            }
        }

        if (!found) {

            System.out.println("Телефони не знайдені.");
        }
    }

    // Пошук за максимальною ціною
    public void searchByMaxPrice(double maxPrice) {

        boolean found = false;

        for (int i = 0; i < phones.size(); i++) {

            Phone p = phones.get(i);

            if (p.getPrice() <= maxPrice) {

                System.out.println(p);
                System.out.println("Кількість: " + quantities.get(i));

                found = true;
            }
        }

        if (!found) {

            System.out.println("Телефони не знайдені.");
        }
    }

    // Виведення всіх телефонів
    public void showAllPhones() {

        if (phones.isEmpty()) {

            System.out.println("Список порожній.");
            return;
        }

        for (int i = 0; i < phones.size(); i++) {

            System.out.println(phones.get(i));
            System.out.println("Кількість: " + quantities.get(i));
        }
    }

    // Сортування телефонів
    public void showSortedPhones() {

        if (phones.isEmpty()) {

            System.out.println("Список порожній.");
            return;
        }

        ArrayList<Phone> sortedPhones =
                new ArrayList<>(phones);

        Collections.sort(sortedPhones);

        System.out.println("\nВідсортовані телефони:");

        for (Phone phone : sortedPhones) {

            System.out.println(phone);
        }
    }

    // Геттер для FileManager
    public ArrayList<Phone> getPhones() {

        return phones;
    }
}