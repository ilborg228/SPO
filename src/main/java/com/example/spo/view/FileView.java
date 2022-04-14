package com.example.spo.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FileView {


    @FXML
    private Button AddButton;

    @FXML
    private ChoiceBox<String> ComboBox;

    @FXML
    private Button DeleteButton;

    @FXML
    private Button OpenButton;

    @FXML
    private Button SaveButton;

    public TableView<?> getGridTable() {
        return GridTable;
    }

    @FXML
    private TableView<?> GridTable;

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


    public void initialize() {
    }
}
