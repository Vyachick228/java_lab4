package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    private final Store store =
            new Store();

    private final TextArea listArea =
            new TextArea();

    private final TextArea resultArea =
            new TextArea();

    @Override
    public void start(Stage stage) {

        TextField brandField =
                new TextField();

        brandField.setPromptText(
                "Бренд"
        );

        TextField modelField =
                new TextField();

        modelField.setPromptText(
                "Модель"
        );

        TextField priceField =
                new TextField();

        priceField.setPromptText(
                "Ціна"
        );

        Button addButton =
                new Button("Додати");

        addButton.setOnAction(e -> {

            try {

                String brand =
                        brandField.getText();

                String model =
                        modelField.getText();

                double price =
                        Double.parseDouble(
                                priceField.getText()
                        );

                Phone phone =
                        new SmartPhone(
                                brand,
                                model,
                                price,
                                128,
                                PhoneType.SMARTPHONE,
                                "Android"
                        );

                store.addNewPhone(
                        phone,
                        1
                );

                updateList();
            }
            catch (Exception ex) {

                resultArea.setText(
                        "Помилка введення!"
                );
            }
        });

        TextField uuidField =
                new TextField();

        uuidField.setPromptText(
                "UUID"
        );

        Button searchButton =
                new Button("Знайти");

        searchButton.setOnAction(e -> {

            try {

                String uuid =
                        uuidField.getText();

                boolean found = false;

                for (Phone phone :
                        store.getPhones()) {

                    if (phone.getUuid()
                            .toString()
                            .equals(uuid)) {

                        resultArea.setText(
                                phone.toString()
                        );

                        found = true;
                    }
                }

                if (!found) {

                    resultArea.setText(
                            "Не знайдено"
                    );
                }
            }
            catch (Exception ex) {

                resultArea.setText(
                        "Некоректний UUID"
                );
            }
        });

        VBox root = new VBox(
                10,
                brandField,
                modelField,
                priceField,
                addButton,
                listArea,
                uuidField,
                searchButton,
                resultArea
        );

        root.setPadding(
                new Insets(10)
        );

        Scene scene =
                new Scene(root, 500, 600);

        stage.setTitle(
                "Phone Store"
        );

        stage.setScene(scene);

        stage.show();
    }

    private void updateList() {

        listArea.clear();

        for (Phone phone :
                store.getPhones()) {

            listArea.appendText(
                    phone.getBrand() +
                            " " +
                            phone.getModel() +
                            " | UUID: " +
                            phone.getUuid() +
                            "\n"
            );
        }
    }

    public static void main(String[] args) {

        launch(args);
    }
}