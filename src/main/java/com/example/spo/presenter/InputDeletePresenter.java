package com.example.spo.presenter;

import com.example.spo.view.InputDeleteNumberView;
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
    public static void Launch(InputDeleteNumberView inputDeleteNumberView){
        inputDeleteNumberView.setInputDeletePresenter(new InputDeletePresenter());
        inputDeleteNumberView.getOKButton().setOnAction(actionEvent ->
                inputDeleteNumberView.getInputDeletePresenter().OKButton(inputDeleteNumberView.getFirstField()));
    }
}
