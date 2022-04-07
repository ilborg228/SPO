package com.example.spo.view;

import com.example.spo.presenter.InputPresenter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class InputView {

    public void setInputPresenter(InputPresenter inputPresenter) {
        this.inputPresenter = inputPresenter;
    }

    private InputPresenter inputPresenter;

    public InputPresenter getInputPresenter() {
        return inputPresenter;
    }

    public TextField getFieldOne() {
        return FieldOne;
    }

    public TextField getFieldThree() {
        return FieldThree;
    }

    public TextField getFieldTwo() {
        return FieldTwo;
    }

    public Button getOKButton() {
        return OKButton;
    }

    @FXML
    private TextField FieldOne;

    @FXML
    private TextField FieldThree;

    @FXML
    private TextField FieldTwo;

    @FXML
    private Button OKButton;

    public void initialize() {
    }
}
