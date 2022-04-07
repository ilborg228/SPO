package com.example.spo.view;

import com.example.spo.presenter.AnalyzerPresenter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnalyzerView {

    public ChoiceBox<String> getComboBox() {
        return ComboBox;
    }

    public TextArea getInputTextField() {
        return InputTextField;
    }

    public Button getLaunchButton() {
        return LaunchButton;
    }

    public TextField getResultTextField() {
        return ResultTextField;
    }

    @FXML
    private ChoiceBox<String> ComboBox;

    @FXML
    private TextArea InputTextField;

    @FXML
    private Button LaunchButton;

    @FXML
    private TextField ResultTextField;

    public void initialize() {
    }
}
