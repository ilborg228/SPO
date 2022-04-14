package com.example.spo.presenter;

import com.example.spo.jni.JNI;
import com.example.spo.view.LowLevelFunctionsView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LowLevelFunctionsPresenter {

    private static LowLevelFunctionsView lowLevelFunctionsView;

    public static void LaunchButton(TextField FirstTextField, TextField SecondTextField, Label ResultTextField, ChoiceBox comboBox){
        boolean ex = false;
        try {
            Integer.parseInt(FirstTextField.getText());
        }catch (NumberFormatException e){
            LowLevelFunctionsPresenter.lowLevelFunctionsView.getResultTextField().setText("В первом поле не введено число");
            ex = true;
        }
        try {
            Integer.parseInt(SecondTextField.getText());
        }catch (NumberFormatException e){
            LowLevelFunctionsPresenter.lowLevelFunctionsView.getResultTextField().setText("Во втором поле не введено число");
            ex = true;
        }

        if (!ex) {
            JNI jni = new JNI();
            if (comboBox.getValue() == "OR") {
                ResultTextField.setText(Integer.toString(jni.OR(Integer.parseInt(FirstTextField.getText()),
                        Integer.parseInt(SecondTextField.getText()))));
            } else if (comboBox.getValue() == "MULTIPLY") {
                ResultTextField.setText(Integer.toString(jni.MULTIPLY(Integer.parseInt(FirstTextField.getText()),
                        Integer.parseInt(SecondTextField.getText()))));
            }
        }
    }
    public static void Launch(LowLevelFunctionsView lowLevelFunctionsView){
        LowLevelFunctionsPresenter.lowLevelFunctionsView = lowLevelFunctionsView;
        ObservableList<String> ComboBoxList = FXCollections.observableArrayList("OR", "MULTIPLY");
        lowLevelFunctionsView.getComboBox().setItems(ComboBoxList);
        lowLevelFunctionsView.getLaunchButton().setOnAction(actionEvent ->
                LowLevelFunctionsPresenter.LaunchButton(lowLevelFunctionsView.getFirstTextField(),
                        lowLevelFunctionsView.getSecondTextField(), lowLevelFunctionsView.getResultTextField(), lowLevelFunctionsView.getComboBox()));
    }
}
