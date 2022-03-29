package com.example.spo.presenter;

import com.example.spo.model.MyCode;
import com.example.spo.utils.ForAnalyzer;
import com.example.spo.utils.ForCompiler;
import com.example.spo.utils.IfAnalyzer;
import com.example.spo.utils.IfCompiler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnalyzerUiPresenter {

    ObservableList<String> ComboBoxList = FXCollections.observableArrayList("IF", "FOR");
    private int value = 0;
    @FXML
    private ChoiceBox<String> ComboBox;

    @FXML
    private TextArea InputTextField;

    @FXML
    private Button LaunchButton;

    @FXML
    private TextField ResultTextField;

    public void initialize() {
        ComboBox.setItems(ComboBoxList);
        ComboBox.setOnAction(actionEvent -> {
            if (ComboBox.getValue() == "IF") {
                InputTextField.setText("if(5<9){int b;}");
            } else if (ComboBox.getValue() == "FOR") {
                InputTextField.setText("for(int i=0;i<8;i++){}");
            }
        });
        LaunchButton.setOnAction(actionEvent -> {
            MyCode myCode = null;
            if (ComboBox.getValue() == "IF") {
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
                    ResultTextField.setText(e.getMessage());
                }
            } else if (ComboBox.getValue() == "FOR") {
                try {
                    myCode = ForAnalyzer.getTargetCode(InputTextField.getText());
                    int i = ForCompiler.execute(myCode,value);
                    value++;
                    ResultTextField.setText("Цикл выполнился: " + i + " раз");
                } catch (Exception e) {
                    ResultTextField.setText(e.getMessage());
                }
            }
        });
    }
}
