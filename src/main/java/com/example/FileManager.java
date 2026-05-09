package com.example;

import com.google.gson.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Клас для збереження та завантаження об'єктів Phone у JSON файл
 */
public class FileManager {

    /**
     * Внутрішній клас для JSON
     */
    private static class PhoneData {

        Phone phone;
        int quantity;

        public PhoneData(Phone phone, int quantity) {

            this.phone = phone;
            this.quantity = quantity;
        }
    }

    /**
     * Зберігає список телефонів у JSON файл
     */
    public static void saveToJson(Store store, String fileName) {

        Gson gson =
                new GsonBuilder()
                        .setPrettyPrinting()
                        .create();

        ArrayList<PhoneData> data =
                new ArrayList<>();

        ArrayList<Phone> phones =
                store.getPhones();

        ArrayList<Integer> quantities =
                store.getQuantities();

        for (int i = 0; i < phones.size(); i++) {

            data.add(
                    new PhoneData(
                            phones.get(i),
                            quantities.get(i)
                    )
            );
        }

        try (FileWriter writer =
                     new FileWriter(fileName)) {

            gson.toJson(data, writer);

        } catch (IOException e) {

            System.out.println(
                    "Помилка запису: "
                            + e.getMessage()
            );
        }
    }

    /**
     * Завантажує список телефонів з JSON файлу
     */
    public static void loadFromJson(
            Store store,
            String fileName
    ) {

        try (Reader reader =
                     new FileReader(fileName)) {

            JsonArray array =
                    JsonParser.parseReader(reader)
                            .getAsJsonArray();

            for (JsonElement element : array) {

                JsonObject wrapper =
                        element.getAsJsonObject();

                JsonObject obj =
                        wrapper.getAsJsonObject("phone");

                int quantity =
                        wrapper.get("quantity")
                                .getAsInt();

                String type =
                        obj.get("classType")
                                .getAsString();

                Phone phone = null;

                switch (type) {

                    case "SmartPhone":

                        phone = new Gson().fromJson(
                                obj,
                                SmartPhone.class
                        );
                        break;

                    case "KeypadPhone":

                        phone = new Gson().fromJson(
                                obj,
                                KeypadPhone.class
                        );
                        break;

                    case "GamingPhone":

                        phone = new Gson().fromJson(
                                obj,
                                GamingPhone.class
                        );
                        break;

                    case "CameraPhone":

                        phone = new Gson().fromJson(
                                obj,
                                CameraPhone.class
                        );
                        break;

                    case "BusinessPhone":

                        phone = new Gson().fromJson(
                                obj,
                                BusinessPhone.class
                        );
                        break;
                }

                if (phone != null) {

                    store.addNewPhone(
                            phone,
                            quantity
                    );
                }
            }

        } catch (FileNotFoundException e) {

            System.out.println(
                    "Файл не знайдено, буде створено новий."
            );

        } catch (Exception e) {

            System.out.println(
                    "Помилка читання JSON: "
                            + e.getMessage()
            );
        }
    }
}