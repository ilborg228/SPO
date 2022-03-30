package com.example.spo.presenter;

import com.example.spo.view.InputDeleteView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class InputDeleteNumberPresenter {

    private InputDeleteView inputDeleteView;

    public InputDeleteView getInputDeleteView() {
        return inputDeleteView;
    }

    @FXML
    private TextField FirstField;

    @FXML
    private Button OKButton;

    public void initialize() {
        inputDeleteView = new InputDeleteView();
        OKButton.setOnAction(actionEvent -> inputDeleteView.OKButton(FirstField));
    }
}
