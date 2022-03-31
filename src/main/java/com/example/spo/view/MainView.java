package com.example.spo.view;

import com.example.spo.presenter.MainPresenter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainView {

    @FXML
    private Button Analyze_Button;

    @FXML
    private Button Author_Button;

    @FXML
    private Button C_Button;

    @FXML
    private Button File_Button;

    public void initialize() {
        Author_Button.setOnAction(actionEvent -> MainPresenter.AuthorsButtonAction());
        C_Button.setOnAction(actionEvent -> MainPresenter.CButton());
        File_Button.setOnAction(actionEvent -> MainPresenter.FileButton());
        Analyze_Button.setOnAction(actionEvent -> MainPresenter.AnalyzerButton());
    }
}
