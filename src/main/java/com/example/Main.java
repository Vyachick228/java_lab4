package com.example;

import java.util.Scanner;

/**
 * Головний клас програми з консольним меню
 */
public class Main {

    // Метод вибору телефону
    private static Phone choosePhone(
            Store store,
            Scanner scanner
    ) {

        if (store.getPhones().isEmpty()) {

            System.out.println("Список порожній.");
            return null;
        }

        System.out.println("\nСписок телефонів:");

        for (int i = 0; i < store.getPhones().size(); i++) {

            System.out.println(
                    (i + 1) + " - " +
                            store.getPhones().get(i)
            );
        }

        System.out.print(
                "Оберіть номер телефону: "
        );

        int index =
                Integer.parseInt(scanner.nextLine()) - 1;

        if (index < 0 ||
                index >= store.getPhones().size()) {

            System.out.println("Невірний номер!");
            return null;
        }

        return store.getPhones().get(index);
    }

    public static void main(String[] args) {

        // Створення магазину
        Store store = new Store();

        // Завантаження даних з JSON
        FileManager.loadFromJson(store, "input.json");

        Scanner scanner = new Scanner(System.in);

        // Головний цикл програми
        while (true) {

            // Головне меню
            System.out.println("\n МЕНЮ ");
            System.out.println("1 - Додати телефон");
            System.out.println("2 - Показати всі телефони");
            System.out.println("3 - Модифікувати телефон");
            System.out.println("4 - Видалити телефон");
            System.out.println("5 - Пошук телефону");
            System.out.println("6 - Вивести відсортовані телефони");
            System.out.println("0 - Вийти");
            System.out.print("Оберіть: ");

            int choice;

            // Перевірка введення
            try {

                choice = Integer.parseInt(scanner.nextLine());
            }
            catch (Exception e) {

                System.out.println("Некоректне введення!");
                continue;
            }

            // Додавання телефону
            if (choice == 1) {

                try {

                    // Меню вибору типу телефону
                    System.out.println("Оберіть тип:");
                    System.out.println("1 - SmartPhone");
                    System.out.println("2 - KeypadPhone");
                    System.out.println("3 - GamingPhone");
                    System.out.println("4 - CameraPhone");
                    System.out.println("5 - BusinessPhone");

                    int typeChoice =
                            Integer.parseInt(scanner.nextLine());

                    // Введення спільних параметрів
                    System.out.print("Бренд: ");
                    String brand = scanner.nextLine();

                    System.out.print("Модель: ");
                    String model = scanner.nextLine();

                    System.out.print("Ціна: ");
                    double price =
                            Double.parseDouble(scanner.nextLine());

                    System.out.print("Пам'ять: ");
                    int storage =
                            Integer.parseInt(scanner.nextLine());

                    System.out.print("Кількість: ");
                    int quantity =
                            Integer.parseInt(scanner.nextLine());

                    Phone phone;

                    // Створення SmartPhone
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

                    // Створення KeypadPhone
                    else if (typeChoice == 2) {

                        System.out.print("Кнопки: ");
                        int buttons =
                                Integer.parseInt(scanner.nextLine());

                        phone = new KeypadPhone(
                                brand,
                                model,
                                price,
                                storage,
                                PhoneType.BUTTON,
                                buttons
                        );
                    }

                    // Створення GamingPhone
                    else if (typeChoice == 3) {

                        System.out.print("FPS: ");
                        int fps =
                                Integer.parseInt(scanner.nextLine());

                        phone = new GamingPhone(
                                brand,
                                model,
                                price,
                                storage,
                                PhoneType.SMARTPHONE,
                                fps
                        );
                    }

                    // Створення CameraPhone
                    else if (typeChoice == 4) {

                        System.out.print("Мегапікселі: ");
                        int megapixels =
                                Integer.parseInt(scanner.nextLine());

                        phone = new CameraPhone(
                                brand,
                                model,
                                price,
                                storage,
                                PhoneType.SMARTPHONE,
                                megapixels
                        );
                    }

                    // Створення BusinessPhone
                    else if (typeChoice == 5) {

                        System.out.print(
                                "Є захист? (true/false): "
                        );

                        boolean hasSecurity =
                                Boolean.parseBoolean(
                                        scanner.nextLine()
                                );

                        phone = new BusinessPhone(
                                brand,
                                model,
                                price,
                                storage,
                                PhoneType.SMARTPHONE,
                                hasSecurity
                        );
                    }

                    // Невірний вибір
                    else {

                        System.out.println("Невірний вибір!");
                        continue;
                    }

                    // Додавання телефону
                    store.addNewPhone(phone, quantity);

                    System.out.println("Телефон додано!");
                }
                catch (PhoneException e) {

                    System.out.println(
                            "Помилка: " + e.getMessage()
                    );
                }
                catch (Exception e) {

                    System.out.println(
                            "Невірний формат даних!"
                    );
                }
            }

            // Виведення всіх телефонів
            else if (choice == 2) {

                store.showAllPhones();
            }

            // Модифікація телефону
            else if (choice == 3) {

                try {

                    Phone oldPhone =
                            choosePhone(store, scanner);

                    if (oldPhone == null) {

                        continue;
                    }

                    System.out.print("Новий бренд: ");
                    String brand = scanner.nextLine();

                    System.out.print("Нова модель: ");
                    String model = scanner.nextLine();

                    System.out.print("Нова ціна: ");
                    double price =
                            Double.parseDouble(scanner.nextLine());

                    System.out.print("Нова пам'ять: ");
                    int storage =
                            Integer.parseInt(scanner.nextLine());

                    Phone newPhone =
                            new SmartPhone(
                                    brand,
                                    model,
                                    price,
                                    storage,
                                    PhoneType.SMARTPHONE,
                                    "Android"
                            );

                    store.update(oldPhone, newPhone);

                    System.out.println(
                            "Телефон змінено!"
                    );
                }
                catch (StoreException e) {

                    System.out.println(
                            e.getMessage()
                    );
                }
                catch (PhoneException e) {

                    System.out.println(
                            e.getMessage()
                    );
                }
                catch (Exception e) {

                    System.out.println(
                            "Некоректне введення!"
                    );
                }
            }

            // Видалення телефону
            else if (choice == 4) {

                try {

                    Phone phoneToDelete =
                            choosePhone(store, scanner);

                    if (phoneToDelete == null) {

                        continue;
                    }

                    System.out.print(
                            "Підтвердити видалення? (yes/no): "
                    );

                    String confirm =
                            scanner.nextLine();

                    if (confirm.equalsIgnoreCase("yes")) {

                        store.delete(phoneToDelete);

                        System.out.println(
                                "Телефон видалено!"
                        );
                    }
                }
                catch (StoreException e) {

                    System.out.println(
                            e.getMessage()
                    );
                }
                catch (Exception e) {

                    System.out.println(
                            "Некоректне введення!"
                    );
                }
            }

            // Меню пошуку
            else if (choice == 5) {

                try {

                    System.out.println("\nПОШУК");
                    System.out.println("1 - Пошук за брендом");
                    System.out.println("2 - Пошук за типом");
                    System.out.println("3 - Пошук за максимальною ціною");
                    System.out.println("4 - Пошук за UUID");
                    System.out.println("0 - Назад");

                    int searchChoice =
                            Integer.parseInt(scanner.nextLine());

                    // Пошук за брендом
                    if (searchChoice == 1) {

                        System.out.print("Введіть бренд: ");
                        String brand = scanner.nextLine();

                        store.searchByBrand(brand);
                    }

                    // Пошук за типом
                    else if (searchChoice == 2) {

                        System.out.print(
                                "Введіть тип телефону: "
                        );

                        String type = scanner.nextLine();

                        store.searchByType(type);
                    }

                    // Пошук за ціною
                    else if (searchChoice == 3) {

                        System.out.print(
                                "Введіть максимальну ціну: "
                        );

                        double maxPrice =
                                Double.parseDouble(
                                        scanner.nextLine()
                                );

                        store.searchByMaxPrice(maxPrice);
                    }

                    // Пошук за UUID
                    else if (searchChoice == 4) {

                        System.out.print(
                                "Введіть UUID: "
                        );

                        String uuid =
                                scanner.nextLine();

                        store.searchByUuid(uuid);
                    }
                }
                catch (Exception e) {

                    System.out.println(
                            "Некоректне введення!"
                    );
                }
            }

            // Сортування телефонів
            else if (choice == 6) {

                try {

                    System.out.println(
                            "\nОберіть критерій сортування:"
                    );

                    System.out.println(
                            "1 - Сортувати за брендом"
                    );

                    System.out.println(
                            "2 - Сортувати за ціною"
                    );

                    System.out.println(
                            "3 - Сортувати за пам'яттю"
                    );

                    System.out.println(
                            "0 - Повернутися"
                    );

                    int sortChoice =
                            Integer.parseInt(
                                    scanner.nextLine()
                            );

                    // Сортування за брендом
                    if (sortChoice == 1) {

                        store.sortByBrand();
                    }

                    // Сортування за ціною
                    else if (sortChoice == 2) {

                        store.sortByPrice();
                    }

                    // Сортування за пам'яттю
                    else if (sortChoice == 3) {

                        store.sortByStorage();
                    }
                }
                catch (Exception e) {

                    System.out.println(
                            "Некоректне введення!"
                    );
                }
            }

            // Завершення роботи
            else if (choice == 0) {

                // Збереження в JSON
                FileManager.saveToJson(
                        store,
                        "input.json"
                );

                System.out.println("Дані збережено!");
                System.out.println("Завершення роботи...");

                break;
            }

            // Невідома команда
            else {

                System.out.println("Невідома команда!");
            }
        }

        scanner.close();
    }
}