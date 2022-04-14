package com.example.spo.view;

import com.example.spo.presenter.LowLevelFunctionsPresenter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LowLevelFunctionsView {

    public ChoiceBox<String> getComboBox() {
        return ComboBox;
    }

    public TextField getFirstTextField() {
        return FirstTextField;
    }

    public Button getLaunchButton() {
        return LaunchButton;
    }

    public Label getResultTextField() {
        return ResultTextField;
    }

    public TextField getSecondTextField() {
        return SecondTextField;
    }

    @FXML
    private ChoiceBox<String> ComboBox;

    @FXML
    private TextField FirstTextField;

    @FXML
    private Button LaunchButton;

    @FXML
    private Label ResultTextField;

    @FXML
    private TextField SecondTextField;

    public void initialize() {
    }
}
