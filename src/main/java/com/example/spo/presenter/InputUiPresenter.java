package com.example.spo.presenter;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class InputUiPresenter {

    private String FirstField;
    private String SecondField;
    private String ThirdField;

    public String getFirstField() {
        return FirstField;
    }

    public void setFirstField(String firstField) {
        FirstField = firstField;
    }

    public String getSecondField() {
        return SecondField;
    }

    public void setSecondField(String secondField) {
        SecondField = secondField;
    }

    public String getThirdField() {
        return ThirdField;
    }

    public void setThirdField(String thirdField) {
        ThirdField = thirdField;
    }


    @FXML
    private TextField FieldOne;

    @FXML
    private TextField FieldThree;

    @FXML
    private TextField FieldTwo;

    @FXML
    private Button OKButton;

    public void initialize() {
        OKButton.setOnAction(actionEvent -> {
            if(!FieldOne.getText().equals("") && !FieldTwo.getText().equals("") && !FieldThree.getText().equals("")){
                setFirstField(FieldOne.getText());
                setSecondField(FieldTwo.getText());
                setThirdField(FieldThree.getText());
            }
        });
    }
}
