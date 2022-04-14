package com.example.spo.view;

import com.example.spo.presenter.InputDeletePresenter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class InputDeleteNumberView {

    public void setInputDeletePresenter(InputDeletePresenter inputDeletePresenter) {
        this.inputDeletePresenter = inputDeletePresenter;
    }

    public Label getErrorLabel() {
        return ErrorLabel;
    }

    @FXML
    private Label ErrorLabel;

    private InputDeletePresenter inputDeletePresenter;

    public InputDeletePresenter getInputDeleteView() {
        return inputDeletePresenter;
    }

    public InputDeletePresenter getInputDeletePresenter() {
        return inputDeletePresenter;
    }

    public TextField getFirstField() {
        return FirstField;
    }

    public Button getOKButton() {
        return OKButton;
    }

    @FXML
    private TextField FirstField;

    @FXML
    private Button OKButton;

    public void initialize() {
    }
}
