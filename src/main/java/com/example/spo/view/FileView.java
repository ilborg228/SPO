package com.example.spo.view;

import com.example.spo.presenter.FilePresenter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

public class FileView {

    @FXML
    private ChoiceBox<String> ComboBox;

    @FXML
    private Button OpenButton;

    @FXML
    private Button SaveButton;

    @FXML
    private Button DeleteButton;

    @FXML
    private Button AddButton;

    @FXML
    private TextArea ResultTextField;

    public ChoiceBox<String> getComboBox() {
        return ComboBox;
    }

    public Button getOpenButton() {
        return OpenButton;
    }

    public Button getSaveButton() {
        return SaveButton;
    }

    public Button getDeleteButton() {
        return DeleteButton;
    }

    public Button getAddButton() {
        return AddButton;
    }

    public TextArea getResultTextField() {
        return ResultTextField;
    }

    public void initialize() {
    }
}
