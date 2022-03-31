package com.example.spo.view;

import com.example.spo.presenter.InputPresenter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class InputView {

    private InputPresenter inputPresenter;

    public InputPresenter getInputPresenter() {
        return inputPresenter;
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
        inputPresenter = new InputPresenter();
        OKButton.setOnAction(actionEvent -> inputPresenter.OKButton(FieldOne,FieldTwo,FieldThree));
    }
}
