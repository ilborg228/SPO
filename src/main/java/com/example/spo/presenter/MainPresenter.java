package com.example.spo.presenter;

import com.example.spo.HelloApplication;
import com.example.spo.view.MainView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPresenter {

    @FXML
    private Button Analyze_Button;

    @FXML
    private Button Author_Button;

    @FXML
    private Button C_Button;

    @FXML
    private Button File_Button;

    public void initialize() {
        Author_Button.setOnAction(actionEvent -> MainView.AuthorsButtonAction());
        C_Button.setOnAction(actionEvent -> MainView.CButton());
        File_Button.setOnAction(actionEvent -> MainView.FileButton());
        Analyze_Button.setOnAction(actionEvent -> MainView.AnalyzerButton());
    }
}
