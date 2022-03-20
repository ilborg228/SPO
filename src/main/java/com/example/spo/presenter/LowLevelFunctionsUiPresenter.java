package com.example.spo.presenter;

import com.example.spo.jni.JNI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.util.Scanner;

public class LowLevelFunctionsUiPresenter {

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
        JNI jni = new JNI();
        ComboBox.setItems(ComboBoxList);
        LaunchButton.setOnAction(actionEvent -> {
            if (!FirstTextField.getText().equals("") && !SecondTextField.getText().equals("")) {
                if (ComboBox.getValue() == "OR") {
                    ResultTextField.setText(Integer.toString(jni.OR(Integer.parseInt(FirstTextField.getText()),
                            Integer.parseInt(SecondTextField.getText()))));
                } else if (ComboBox.getValue() == "MULTIPLY") {
                    ResultTextField.setText(Integer.toString(jni.MULTIPLY(Integer.parseInt(FirstTextField.getText()),
                            Integer.parseInt(SecondTextField.getText()))));
                }
            }
        });
    }
}
