package com.example.spo.view;

import com.example.spo.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainView {
    public static void AuthorsButtonAction(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AuthorsUI.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 352, 181);
            Stage stage = new Stage();
            stage.setTitle("Authors");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void CButton(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LowLevelFunctionsUI.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 171);
            Stage stage = new Stage();
            stage.setTitle("Low Level Functions");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void FileButton(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FileUI.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 331, 400);
            Stage stage = new Stage();
            stage.setTitle("File Handler");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void AnalyzerButton(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AnalyzerUI.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 302, 400);
            Stage stage = new Stage();
            stage.setTitle("Analyzer");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
