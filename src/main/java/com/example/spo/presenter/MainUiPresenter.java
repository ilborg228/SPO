package com.example.spo.presenter;

import com.example.spo.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainUiPresenter {

    @FXML
    private Button Analyze_Button;

    @FXML
    private Button Author_Button;

    @FXML
    private Button C_Button;

    @FXML
    private Button File_Button;

    public void initialize() {
        Author_Button.setOnAction(actionEvent -> {
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
        });
        C_Button.setOnAction(actionEvent -> {
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
        });
        File_Button.setOnAction(actionEvent -> {
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
        });
        Analyze_Button.setOnAction(actionEvent -> {
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
        });
    }
}
