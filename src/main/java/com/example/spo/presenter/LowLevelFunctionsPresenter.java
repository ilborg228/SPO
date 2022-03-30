package com.example.spo.presenter;

import com.example.spo.jni.JNI;
import com.example.spo.view.LowLevelFunctionsView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class LowLevelFunctionsPresenter {

    ObservableList<String> ComboBoxList = FXCollections.observableArrayList("OR", "MULTIPLY");
    @FXML
    private ChoiceBox<String> ComboBox;

    @FXML
    private TextField FirstTextField;

    @FXML
    private Button LaunchButton;

    @FXML
    private TextField ResultTextField;

    @FXML
    private TextField SecondTextField;

    public void initialize() {
        ComboBox.setItems(ComboBoxList);
        LaunchButton.setOnAction(actionEvent -> LowLevelFunctionsView.LaunchButton(FirstTextField,SecondTextField,ResultTextField,ComboBox));
    }
}
