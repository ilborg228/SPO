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

    ObservableList<String> ComboBoxList = FXCollections.observableArrayList("IF", "FOR");
    @FXML
    private ChoiceBox<String> ComboBox;

    @FXML
    private TextArea InputTextField;

    @FXML
    private Button LaunchButton;

    @FXML
    private TextField ResultTextField;

    public void initialize() {
        ComboBox.setItems(ComboBoxList);
        ComboBox.setOnAction(actionEvent -> AnalyzerPresenter.comboboxAction(InputTextField, ComboBox));
        LaunchButton.setOnAction(actionEvent -> AnalyzerPresenter.launchButtonAction(ComboBox,InputTextField,ResultTextField));
    }
}
