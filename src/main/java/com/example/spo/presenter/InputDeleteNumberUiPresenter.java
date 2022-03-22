package com.example.spo.presenter;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class InputDeleteNumberUiPresenter {

    private int Number;

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    @FXML
    private TextField FirstField;

    @FXML
    private Button OKButton;

    public void initialize() {
        OKButton.setOnAction(actionEvent -> {
            if(!FirstField.getText().equals("")){
                setNumber(Integer.parseInt(FirstField.getText()));
            }
        });
    }
}
