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
            System.out.println("\n МЕНЮ ");
            System.out.println("1 - Додати телефон");
            System.out.println("2 - Показати всі телефони");
            System.out.println("0 - Вийти");
            System.out.print("Оберіть: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Некоректне введення!");
                continue;
            }

            if (choice == 1) {
                try {
                    System.out.println("Оберіть тип:");
                    System.out.println("1 - SmartPhone");
                    System.out.println("2 - KeypadPhone");

                    int typeChoice = Integer.parseInt(scanner.nextLine());

                    System.out.print("Бренд: ");
                    String brand = scanner.nextLine();

                    System.out.print("Модель: ");
                    String model = scanner.nextLine();

                    System.out.print("Ціна: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    System.out.print("Пам'ять: ");
                    int storage = Integer.parseInt(scanner.nextLine());

                    Phone phone;

                    if (typeChoice == 1) {
                        System.out.print("OS: ");
                        String os = scanner.nextLine();

                        phone = new SmartPhone(
                                brand,
                                model,
                                price,
                                storage,
                                PhoneType.SMARTPHONE,
                                os
                        );
                    }
                    else if (typeChoice == 2) {
                        System.out.print("Кнопки: ");
                        int buttons = Integer.parseInt(scanner.nextLine());

                        phone = new KeypadPhone(
                                brand,
                                model,
                                price,
                                storage,
                                PhoneType.BUTTON,
                                buttons
                        );
                    }
                    else {
                        System.out.println("Невірний вибір!");
                        continue;
                    }

                    phones.add(phone);
                    System.out.println("Додано!");

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
                        System.out.println("Тип: " + p.getClass().getSimpleName());
                        System.out.println(p);
                    }
                }
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