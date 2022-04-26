package com.example.spo.presenter;

import com.example.spo.jni.JNI;
import com.example.spo.view.LowLevelFunctionsView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LowLevelFunctionsPresenter {

    private static LowLevelFunctionsView lowLevelFunctionsView;

    public static void LaunchButton(TextField FirstTextField, TextField SecondTextField, Label ResultTextField, ChoiceBox comboBox,TextArea Logger){
        boolean ex = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        StringBuilder stringBuilder = new StringBuilder(Logger.getText());
        LocalDateTime localDateTime = LocalDateTime.now();
        stringBuilder.append(localDateTime.format(formatter));
        stringBuilder.append(" Окно низкоуровневых функций. Начато выполнение.\n");
        if(comboBox.getValue() != null){
            Logger.setText(stringBuilder.toString());
        }
        try {
            Integer.parseInt(FirstTextField.getText());
        }catch (NumberFormatException e){
            LowLevelFunctionsPresenter.lowLevelFunctionsView.getResultTextField().setText("В первом поле не введено число");
            LocalDateTime dateTime = LocalDateTime.now();
            stringBuilder.append(dateTime.format(formatter));
            stringBuilder.append(" Окно низкоуровневых функций. Ошибка: В первом поле не введено число.\n");
            Logger.setText(stringBuilder.toString());
            ex = true;
        }
        try {
            Integer.parseInt(SecondTextField.getText());
        }catch (NumberFormatException e){
            LowLevelFunctionsPresenter.lowLevelFunctionsView.getResultTextField().setText("Во втором поле не введено число");
            LocalDateTime dateTime = LocalDateTime.now();
            stringBuilder.append(dateTime.format(formatter));
            stringBuilder.append(" Окно низкоуровневых функций. Ошибка: Во втором поле не введено число.\n");
            Logger.setText(stringBuilder.toString());
            ex = true;
        }

        if (!ex) {
            JNI jni = new JNI();
            if (comboBox.getValue() == "OR") {
                ResultTextField.setText(Integer.toString(jni.OR(Integer.parseInt(FirstTextField.getText()),
                        Integer.parseInt(SecondTextField.getText()))));
                LocalDateTime dateTime = LocalDateTime.now();
                stringBuilder.append(dateTime.format(formatter));
                stringBuilder.append(" Окно низкоуровневых функций. Успешное выполнение\n");
                Logger.setText(stringBuilder.toString());
            } else if (comboBox.getValue() == "MULTIPLY") {
                ResultTextField.setText(Integer.toString(jni.MULTIPLY(Integer.parseInt(FirstTextField.getText()),
                        Integer.parseInt(SecondTextField.getText()))));
                LocalDateTime dateTime = LocalDateTime.now();
                stringBuilder.append(dateTime.format(formatter));
                stringBuilder.append(" Окно низкоуровневых функций. Успешное выполнение\n");
                Logger.setText(stringBuilder.toString());
            }
        } else{
            LocalDateTime dateTime = LocalDateTime.now();
            stringBuilder.append(dateTime.format(formatter));
            stringBuilder.append(" Окно низкоуровневых функций. Ошибка при выполнении!\n");
            Logger.setText(stringBuilder.toString());
        }
    }

    public static void Launch(LowLevelFunctionsView lowLevelFunctionsView, TextArea Logger){
        LowLevelFunctionsPresenter.lowLevelFunctionsView = lowLevelFunctionsView;
        ObservableList<String> ComboBoxList = FXCollections.observableArrayList("OR", "MULTIPLY");
        lowLevelFunctionsView.getComboBox().setItems(ComboBoxList);
        lowLevelFunctionsView.getLaunchButton().setOnAction(actionEvent ->
                LowLevelFunctionsPresenter.LaunchButton(lowLevelFunctionsView.getFirstTextField(),
                        lowLevelFunctionsView.getSecondTextField(), lowLevelFunctionsView.getResultTextField(), lowLevelFunctionsView.getComboBox(), Logger));
    }
}
