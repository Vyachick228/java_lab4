package com.example;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Головний клас програми з консольним меню
 */
public class Main {

     // Метод пошуку телефонів за брендом

    public static void searchByBrand(ArrayList<Phone> phones, String brand) {

        boolean found = false;

        for (Phone p : phones) {
            if (p.getBrand().equalsIgnoreCase(brand)) {
                System.out.println(p);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Телефони не знайдені.");
        }
    }

     // Метод пошуку телефонів за типом

    public static void searchByType(ArrayList<Phone> phones, String type) {

        boolean found = false;

        for (Phone p : phones) {
            if (p.getClass().getSimpleName().equalsIgnoreCase(type)) {
                System.out.println(p);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Телефони не знайдені.");
        }
    }
    
    // Метод пошуку телефонів за максимальною ціною

    public static void searchByMaxPrice(ArrayList<Phone> phones, double maxPrice) {

        boolean found = false;

        for (Phone p : phones) {
            if (p.getPrice() <= maxPrice) {
                System.out.println(p);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Телефони не знайдені.");
        }
    }

    public static void main(String[] args) {

        // Завантаження даних з JSON файлу
        ArrayList<Phone> phones = FileManager.loadFromJson("input.json");

        Scanner scanner = new Scanner(System.in);

        // Головний цикл програми
        while (true) {

            // Головне меню
            System.out.println("\n МЕНЮ ");
            System.out.println("1 - Додати телефон");
            System.out.println("2 - Показати всі телефони");
            System.out.println("3 - Пошук телефону");
            System.out.println("0 - Вийти");
            System.out.print("Оберіть: ");

            int choice;

            // Перевірка коректності введення
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Некоректне введення!");
                continue;
            }

            // Додавання нового телефону
            if (choice == 1) {

                try {

                    // Меню вибору типу телефону
                    System.out.println("Оберіть тип:");
                    System.out.println("1 - SmartPhone");
                    System.out.println("2 - KeypadPhone");
                    System.out.println("3 - GamingPhone");
                    System.out.println("4 - CameraPhone");
                    System.out.println("5 - BusinessPhone");

                    int typeChoice = Integer.parseInt(scanner.nextLine());

                    // Введення спільних параметрів
                    System.out.print("Бренд: ");
                    String brand = scanner.nextLine();

                    System.out.print("Модель: ");
                    String model = scanner.nextLine();

                    System.out.print("Ціна: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    System.out.print("Пам'ять: ");
                    int storage = Integer.parseInt(scanner.nextLine());

                    Phone phone;

                    // Створення SmartPhone
                    if (typeChoice == 1) {

                        System.out.print("OS: ");
                        String os = scanner.nextLine();

                        phone = new SmartPhone(
                                brand, model, price, storage,
                                PhoneType.SMARTPHONE, os
                        );
                    }

                    // Створення KeypadPhone
                    else if (typeChoice == 2) {

                        System.out.print("Кнопки: ");
                        int buttons = Integer.parseInt(scanner.nextLine());

                        phone = new KeypadPhone(
                                brand, model, price, storage,
                                PhoneType.BUTTON, buttons
                        );
                    }

                    // Створення GamingPhone
                    else if (typeChoice == 3) {

                        System.out.print("FPS: ");
                        int fps = Integer.parseInt(scanner.nextLine());

                        phone = new GamingPhone(
                                brand, model, price, storage,
                                PhoneType.SMARTPHONE, fps
                        );
                    }

                    // Створення CameraPhone
                    else if (typeChoice == 4) {

                        System.out.print("Мегапікселі: ");
                        int mp = Integer.parseInt(scanner.nextLine());

                        phone = new CameraPhone(
                                brand, model, price, storage,
                                PhoneType.SMARTPHONE, mp
                        );
                    }

                    // Створення BusinessPhone
                    else if (typeChoice == 5) {

                        System.out.print("Є захист? (true/false): ");
                        boolean hasSecurity = Boolean.parseBoolean(scanner.nextLine());

                        phone = new BusinessPhone(
                                brand, model, price, storage,
                                PhoneType.SMARTPHONE, hasSecurity
                        );
                    }

                    // Обробка неправильного вибору
                    else {
                        System.out.println("Невірний вибір!");
                        continue;
                    }

                    // Додавання телефону в колекцію
                    phones.add(phone);

                    System.out.println("Додано!");

                } catch (IllegalArgumentException e) {

                    System.out.println("Помилка: " + e.getMessage());

                } catch (Exception e) {

                    System.out.println("Невірний формат даних!");
                }
            }

            // Виведення всіх телефонів
            else if (choice == 2) {

                if (phones.isEmpty()) {

                    System.out.println("Список порожній.");

                } else {

                    for (Phone p : phones) {

                        System.out.println("Тип: " + p.getClass().getSimpleName());
                        System.out.println(p);
                    }
                }
            }

            // Меню пошуку
            else if (choice == 3) {

                System.out.println("\nПОШУК");
                System.out.println("1 - Пошук за брендом");
                System.out.println("2 - Пошук за типом");
                System.out.println("3 - Пошук за максимальною ціною");
                System.out.println("0 - Назад");

                int searchChoice = Integer.parseInt(scanner.nextLine());

                // Пошук за брендом
                if (searchChoice == 1) {

                    System.out.print("Введіть бренд: ");
                    String brand = scanner.nextLine();

                    searchByBrand(phones, brand);
                }

                // Пошук за типом
                else if (searchChoice == 2) {

                    System.out.print("Введіть тип телефону: ");
                    String type = scanner.nextLine();

                    searchByType(phones, type);
                }

                // Пошук за ціною
                else if (searchChoice == 3) {

                    System.out.print("Введіть максимальну ціну: ");
                    double maxPrice = Double.parseDouble(scanner.nextLine());

                    searchByMaxPrice(phones, maxPrice);
                }
            }

            // Завершення роботи програми
            else if (choice == 0) {

                // Збереження даних у JSON файл
                FileManager.saveToJson(phones, "input.json");

                System.out.println("Дані збережено!");
                System.out.println("Завершення роботи...");
                break;
            }

            // Обробка невідомої команди
            else {

                System.out.println("Невідома команда!");
            }
        }

        scanner.close();
    }
}