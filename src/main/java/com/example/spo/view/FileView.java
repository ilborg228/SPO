package com.example.spo.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FileView {

    @FXML
    private ChoiceBox<String> ComboBox;

    @FXML
    private TableColumn<?, ?> Column1;

    @FXML
    private TableColumn<?, ?> Column2;

    @FXML
    private TableColumn<?, ?> Column3;

    @FXML
    private TableColumn<?, ?> Column4;

    @FXML
    private Button OpenButton;

    @FXML
    private Button SaveButton;

    @FXML
    private Button DeleteButton;

    @FXML
    private Button AddButton;

    @FXML
    private TableView<?> GridTable;

    public TableView<?> getGridTable() {
        return GridTable;
    }

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
