package com.example.spo.presenter;

import javafx.scene.control.TextField;

public class InputPresenter {
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

    public void OKButton(TextField FieldOne, TextField FieldTwo, TextField FieldThree){
        if(!FieldOne.getText().equals("") && !FieldTwo.getText().equals("") && !FieldThree.getText().equals("")){
            setFirstField(FieldOne.getText());
            setSecondField(FieldTwo.getText());
            setThirdField(FieldThree.getText());
        }
    }
}
