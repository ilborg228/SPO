package com.example.spo.view;

import javafx.scene.control.TextField;

public class InputDeleteView {
    private int Number;

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public void OKButton(TextField FirstField){
        if(!FirstField.getText().equals("")){
            setNumber(Integer.parseInt(FirstField.getText()));
        }
    }
}
