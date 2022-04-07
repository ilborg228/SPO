package com.example.spo.presenter;

import com.example.spo.model.MyCode;
import com.example.spo.analyzer.ForAnalyzer;
import com.example.spo.analyzer.ForCompiler;
import com.example.spo.analyzer.IfAnalyzer;
import com.example.spo.analyzer.IfCompiler;
import com.example.spo.view.AnalyzerView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Objects;

public class AnalyzerPresenter {

    private static Integer value = 0;

    public static void comboboxAction(TextArea inputTextField, ChoiceBox<String> comboBox)  {
        if (comboBox.getValue() == "IF") {
            inputTextField.setText("if(5<9){int b;}");
        } else if (comboBox.getValue() == "FOR") {
            inputTextField.setText("for(int i=0;i<8;i++){}");
        }
    }

    public static void launchButtonAction(ChoiceBox<String> ComboBox,
                                          TextArea InputTextField, TextField ResultTextField) {
        MyCode myCode = null;
        if (Objects.equals(ComboBox.getValue(), "IF")) {
            try {
                myCode = IfAnalyzer.getTargetCode(InputTextField.getText());
                int i = IfCompiler.execute(myCode,value);
                value++;
                if (i == 0) {
                    ResultTextField.setText(myCode.getCondition());
                } else if (i == 1) {
                    ResultTextField.setText("!" + myCode.getCondition());
                } else {
                    ResultTextField.setText("Никакое условие не выполняется.");
                }
            } catch (Exception e) {
                ResultTextField.setText("Ошибка в коде");
            }
        } else if (Objects.equals(ComboBox.getValue(), "FOR")) {
            try {
                myCode = ForAnalyzer.getTargetCode(InputTextField.getText());
                int i = ForCompiler.execute(myCode,value);
                value++;
                ResultTextField.setText("Цикл выполнился: " + i + " раз");
            } catch (Exception e) {
                ResultTextField.setText("Ошибка в коде");
            }
        }
    }

    public static void Launch(AnalyzerView analyzerView) {
        ObservableList<String> ComboBoxList = FXCollections.observableArrayList("IF", "FOR");
        analyzerView.getComboBox().setItems(ComboBoxList);
        analyzerView.getComboBox().setOnAction(actionEvent -> AnalyzerPresenter.comboboxAction(analyzerView.getInputTextField(), analyzerView.getComboBox()));
        analyzerView.getLaunchButton().setOnAction(actionEvent -> AnalyzerPresenter.launchButtonAction(analyzerView.getComboBox(),
                analyzerView.getInputTextField(), analyzerView.getResultTextField()));
    }
}
