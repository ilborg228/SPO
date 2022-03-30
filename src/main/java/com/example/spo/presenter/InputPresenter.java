package com.example.spo.presenter;

import com.example.spo.view.InputView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.persistence.criteria.CriteriaBuilder;

public class InputPresenter {

    private InputView inputView;

    public InputView getInputView() {
        return inputView;
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
        inputView = new InputView();
        OKButton.setOnAction(actionEvent -> inputView.OKButton(FieldOne,FieldTwo,FieldThree));
    }
}
