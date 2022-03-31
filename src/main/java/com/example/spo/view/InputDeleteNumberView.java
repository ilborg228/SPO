package com.example.spo.view;

import com.example.spo.presenter.InputDeletePresenter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class InputDeleteNumberView {

    private InputDeletePresenter inputDeletePresenter;

    public InputDeletePresenter getInputDeleteView() {
        return inputDeletePresenter;
    }

    @FXML
    private TextField FirstField;

    @FXML
    private Button OKButton;

    public void initialize() {
        inputDeletePresenter = new InputDeletePresenter();
        OKButton.setOnAction(actionEvent -> inputDeletePresenter.OKButton(FirstField));
    }
}
