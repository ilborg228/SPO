package com.example.spo.view;

import com.example.spo.presenter.InputPresenter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    public Label getLabelOne() {
        return LabelOne;
    }

    public Label getLabelTwo() {
        return LabelTwo;
    }

    public Label getLabelThree() {
        return LabelThree;
    }

    public Label getErrorLabel() {
        return ErrorLabel;
    }

    @FXML
    private Label ErrorLabel;

    @FXML
    private TextField FieldOne;

    @FXML
    private TextField FieldThree;

    @FXML
    private TextField FieldTwo;

    @FXML
    private Label LabelOne;

    @FXML
    private Label LabelTwo;

    @FXML
    private Label LabelThree;

    @FXML
    private Button OKButton;

    public void initialize() {
    }
}
