package com.example.spo.presenter;

import javafx.scene.control.TextField;

public class InputDeletePresenter {
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
