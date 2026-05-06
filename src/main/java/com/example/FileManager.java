package com.example;

import com.google.gson.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Клас для збереження та завантаження об'єктів Phone у JSON файл
 */
public class FileManager {

    /**
     * Зберігає список телефонів у JSON файл
     */
    public static void saveToJson(ArrayList<Phone> phones, String fileName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(phones, writer);
        } catch (IOException e) {
            System.out.println("Помилка запису: " + e.getMessage());
        }
    }

    /**
     * Завантажує список телефонів з JSON файлу
     */
    public static ArrayList<Phone> loadFromJson(String fileName) {
        ArrayList<Phone> phones = new ArrayList<>();

        try (Reader reader = new FileReader(fileName)) {

            JsonArray array = JsonParser.parseReader(reader).getAsJsonArray();

            for (JsonElement element : array) {
                JsonObject obj = element.getAsJsonObject();

                String type = obj.get("classType").getAsString();

                Phone phone = null;

                switch (type) {
                    case "SmartPhone":
                        phone = new Gson().fromJson(obj, SmartPhone.class);
                        break;

                    case "KeypadPhone":
                        phone = new Gson().fromJson(obj, KeypadPhone.class);
                        break;

                    case "GamingPhone":
                        phone = new Gson().fromJson(obj, GamingPhone.class);
                        break;

                    case "CameraPhone":
                        phone = new Gson().fromJson(obj, CameraPhone.class);
                        break;

                    case "BusinessPhone":
                        phone = new Gson().fromJson(obj, BusinessPhone.class);
                        break;
                }

                if (phone != null) {
                    phones.add(phone);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено, буде створено новий.");
        } catch (Exception e) {
            System.out.println("Помилка читання JSON: " + e.getMessage());
        }

        return phones;
    }
}