package com.example.q2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Q2 extends Application {
    private ArrayList<Character> firstChar = new ArrayList<>();
    private String password = "";
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane borderPane = new BorderPane();
        GridPane gridPane = new GridPane();
        Label lblInput = new Label("Enter words: ");
        Label lblPassword = new Label("Use This Password: ");
        TextField txtInput = new TextField("");
        TextField txtPassword = new TextField("");
        txtPassword.setEditable(false);
        Button btnGenerate = new Button("Generate Password");
        btnGenerate.setOnAction(event -> {

            txtPassword.clear();


            String text = txtInput.getText();
            String[] items = text.split(" ");
            for(String item:items){
                firstChar.add(item.charAt(0));
            }


            for (Character first:firstChar){
                password += first;
            }

            int count = 0;

            for(int i = 0; i < password.length(); i++) {
                if(password.charAt(i) != ' ')
                    count++;
            }


            while(true){
                String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ01234567891@#$%^&*()";
                Random r = new Random();
                if (count < 8){
                    for(int i = 0 ; i < 3; i++){
                        password += alphabet.charAt(r.nextInt(alphabet.length()));
                        count++;
                    }
                }else if (count > 8 && count < 12){
                    password += alphabet.charAt(r.nextInt(alphabet.length()));
                    count++;
                }else {
                    break;
                }

            }

            txtPassword.setText(password);



        });
        HBox hBoxBtn = new HBox(btnGenerate);
        hBoxBtn.setAlignment(Pos.CENTER_RIGHT);
        gridPane.addColumn(0, lblInput);
        gridPane.addColumn(1, txtInput, hBoxBtn, txtPassword);
        gridPane.add(lblPassword, 0,2,1,1);
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        gridPane.setPadding(new Insets(20));
        borderPane.setCenter(gridPane);
        BorderPane.setMargin(gridPane, new Insets(0,0,0,25));

        Scene scene = new Scene(borderPane, 400, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}