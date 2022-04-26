package com.example.spo.presenter;

import com.example.spo.view.InputDeleteNumberView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InputDeletePresenter {
    private int Number;

    public void setLogger(TextArea logger) {
        Logger = logger;
    }

    private TextArea Logger;

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
            inputDeleteNumberView.getErrorLabel().setText("Число введено не корректно");
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            StringBuilder stringBuilder = new StringBuilder(Logger.getText());
            stringBuilder.append(dateTime.format(formatter));
            stringBuilder.append(" Окно работы с файлами. Ошибка: "+e.getMessage()+"\n");
            Logger.setText(stringBuilder.toString());
        }
        inputDeleteNumberView.getOKButton().getScene().getWindow().hide();
    }
    public static void Launch(InputDeleteNumberView inputDeleteNumberView){
        inputDeleteNumberView.setInputDeletePresenter(new InputDeletePresenter());
        inputDeleteNumberView.getOKButton().setOnAction(actionEvent ->
                inputDeleteNumberView.getInputDeletePresenter().OKButton(inputDeleteNumberView.getFirstField(),inputDeleteNumberView));
    }
}
