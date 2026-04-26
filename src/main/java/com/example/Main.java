package com.example;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Головний клас програми з консольним меню
 */
public class Main {
    public static void main(String[] args) {

        ArrayList<Phone> phones = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1 - Додати телефон");
            System.out.println("2 - Показати всі телефони");
            System.out.println("3 - Показати кількість телефонів");
            System.out.println("0 - Вийти");
            System.out.print("Оберіть: ");

            int choice;

            // Обробка нечислового вводу
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Некоректне введення! Введіть число.");
                continue;
            }

            if (choice == 1) {
                try {
                    System.out.print("Введіть бренд: ");
                    String brand = scanner.nextLine();

                    System.out.print("Введіть модель: ");
                    String model = scanner.nextLine();

                    System.out.print("Введіть ціну: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    System.out.print("Введіть пам'ять (GB): ");
                    int storage = Integer.parseInt(scanner.nextLine());

                    System.out.println("Оберіть тип телефону:");
                    System.out.println("1 - SMARTPHONE");
                    System.out.println("2 - BUTTON");
                    System.out.println("3 - FOLDABLE");

                    int typeChoice = Integer.parseInt(scanner.nextLine());
                    PhoneType type;

                    if (typeChoice == 1) {
                        type = PhoneType.SMARTPHONE;
                    } else if (typeChoice == 2) {
                        type = PhoneType.BUTTON;
                    } else if (typeChoice == 3) {
                        type = PhoneType.FOLDABLE;
                    } else {
                        throw new IllegalArgumentException("Невірний тип телефону");
                    }

                    System.out.print("Введіть виробника: ");
                    String name = scanner.nextLine();

                    System.out.print("Введіть країну: ");
                    String country = scanner.nextLine();

                    Manufacturer manufacturer = new Manufacturer(name, country);

                    Phone phone = new Phone(brand, model, price, storage, type, manufacturer);
                    phones.add(phone);

                    System.out.println("Телефон додано!");

                } catch (IllegalArgumentException e) {
                    System.out.println("Помилка: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Невірний формат даних!");
                }
            }

            else if (choice == 2) {
                if (phones.isEmpty()) {
                    System.out.println("Список порожній.");
                } else {
                    for (Phone p : phones) {
                        System.out.println(p);
                    }
                }
            }

            else if (choice == 3) {
                System.out.println("Кількість створених телефонів: " + Phone.getCount());
            }

            else if (choice == 0) {
                System.out.println("Завершення роботи...");
                break;
            }

            else {
                System.out.println("Невідома команда!");
            }
        }

        scanner.close();
    }
}