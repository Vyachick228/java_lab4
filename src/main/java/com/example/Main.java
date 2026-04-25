package com.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Phone> phones = new ArrayList<>();

        phones.add(new Phone("Apple", "iPhone 13", 999));
        phones.add(new Phone("Samsung", "S22", 850));
        phones.add(new Phone("Xiaomi", "Mi 11", 600));
        phones.add(new Phone("Huawei", "P40", 700));
        phones.add(new Phone("Google", "Pixel 7", 750));

        for (Phone p : phones) {
            System.out.println(p);
        }
    }
}