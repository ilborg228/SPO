package com.example.spo.view;

import com.example.spo.jni.JNI;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class LowLevelFunctionsView {
    public static void LaunchButton(TextField FirstTextField, TextField SecondTextField, TextField ResultTextField, ChoiceBox comboBox){
        JNI jni = new JNI();
        if (!FirstTextField.getText().equals("") && !SecondTextField.getText().equals("")) {
            if (comboBox.getValue() == "OR") {
                ResultTextField.setText(Integer.toString(jni.OR(Integer.parseInt(FirstTextField.getText()),
                        Integer.parseInt(SecondTextField.getText()))));
            } else if (comboBox.getValue() == "MULTIPLY") {
                ResultTextField.setText(Integer.toString(jni.MULTIPLY(Integer.parseInt(FirstTextField.getText()),
                        Integer.parseInt(SecondTextField.getText()))));
            }
        }
    }
}
