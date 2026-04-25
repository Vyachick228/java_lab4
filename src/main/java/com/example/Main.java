package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Phone> phones = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        phones.add(new Phone("Apple", "iPhone 13", 999));
        phones.add(new Phone("Samsung", "S22", 850));
        phones.add(new Phone("Xiaomi", "Mi 11", 600));

        for (int i = 0; i < 2; i++) {
            System.out.println("Enter brand:");
            String brand = scanner.nextLine();

            System.out.println("Enter model:");
            String model = scanner.nextLine();

            System.out.println("Enter price:");
            double price = scanner.nextDouble();
            scanner.nextLine(); // очистка

            phones.add(new Phone(brand, model, price));
        }

        // вывод
        for (Phone p : phones) {
            System.out.println(p);
        }
    }
}