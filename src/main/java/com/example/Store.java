package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.UUID;

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

    // Сортування за брендом
    public void sortByBrand() {

        if (phones.isEmpty()) {

            System.out.println("Список порожній.");
            return;
        }

        ArrayList<Phone> sortedPhones =
                new ArrayList<>(phones);

        Comparator<Phone> comparator =
                (o1, o2) ->
                        o1.getBrand()
                                .compareToIgnoreCase(
                                        o2.getBrand()
                                );

        sortedPhones.sort(comparator);

        System.out.println("\nСортування за брендом:");

        for (Phone phone : sortedPhones) {

            System.out.println(phone);
        }
    }

    // Сортування за ціною
    public void sortByPrice() {

        if (phones.isEmpty()) {

            System.out.println("Список порожній.");
            return;
        }

        ArrayList<Phone> sortedPhones =
                new ArrayList<>(phones);

        Comparator<Phone> comparator =
                (o1, o2) ->
                        Double.compare(
                                o1.getPrice(),
                                o2.getPrice()
                        );

        sortedPhones.sort(comparator);

        System.out.println("\nСортування за ціною:");

        for (Phone phone : sortedPhones) {

            System.out.println(phone);
        }
    }

    // Сортування за пам'яттю
    public void sortByStorage() {

        if (phones.isEmpty()) {

            System.out.println("Список порожній.");
            return;
        }

        ArrayList<Phone> sortedPhones =
                new ArrayList<>(phones);

        Comparator<Phone> comparator =
                (o1, o2) ->
                        Integer.compare(
                                o1.getStorage(),
                                o2.getStorage()
                        );

        sortedPhones.sort(comparator);

        System.out.println("\nСортування за пам'яттю:");

        for (Phone phone : sortedPhones) {

            System.out.println(phone);
        }
    }

    // Геттер для FileManager
    public ArrayList<Phone> getPhones() {

        return phones;
    }

    // Геттер кількостей
    public ArrayList<Integer> getQuantities() {

        return quantities;
    }

    // Пошук за UUID
    public void searchByUuid(String uuidText) {

        try {

            UUID uuid =
                    UUID.fromString(uuidText);

            for (Phone phone : phones) {

                if (phone.getUuid().equals(uuid)) {

                    System.out.println(phone);
                    return;
                }
            }

            throw new StoreException(
                    "Телефон не знайдено."
            );
        }
        catch (IllegalArgumentException e) {

            System.out.println(
                    "Некоректний UUID!"
            );
        }
        catch (StoreException e) {

            System.out.println(
                    e.getMessage()
            );
        }
    }

    // Оновлення телефону
    public boolean update(
            Phone existingPhone,
            Phone newPhone
    ) {

        int index =
                phones.indexOf(existingPhone);

        if (index == -1) {

            throw new StoreException(
                    "Телефон не знайдено."
            );
        }

        phones.set(index, newPhone);

        return true;
    }

    // Видалення телефону
    public boolean delete(
            Phone existingPhone
    ) {

        int index =
                phones.indexOf(existingPhone);

        if (index == -1) {

            throw new StoreException(
                    "Телефон не знайдено."
            );
        }

        phones.remove(index);
        quantities.remove(index);

        return true;
    }
}