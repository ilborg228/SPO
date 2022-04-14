package com.example.spo.presenter;

import com.example.spo.view.InputDeleteNumberView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InputDeletePresenter {
    private int Number;

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public void OKButton(TextField FirstField, InputDeleteNumberView inputDeleteNumberView){
        try{
            Integer.parseInt(FirstField.getText());
            setNumber(Integer.parseInt(FirstField.getText()));
        }
        catch (NumberFormatException e){
            //inputDeleteNumberView.getExceptionTextField().setText("Число введено не корректно");//TODO
        }
    }
    public static void Launch(InputDeleteNumberView inputDeleteNumberView){
        inputDeleteNumberView.setInputDeletePresenter(new InputDeletePresenter());
        inputDeleteNumberView.getOKButton().setOnAction(actionEvent ->
                inputDeleteNumberView.getInputDeletePresenter().OKButton(inputDeleteNumberView.getFirstField(),inputDeleteNumberView));
    }
}
