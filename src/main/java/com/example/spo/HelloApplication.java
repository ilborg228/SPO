package com.example.spo;

import com.example.spo.presenter.MainPresenter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 318);
        stage.setTitle("SPO Java Program");
        stage.setScene(scene);
        MainPresenter.Launch(fxmlLoader.getController());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}