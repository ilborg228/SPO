package com.example.spo.view;

import com.example.spo.presenter.FilePresenter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

public class FileView {
    ObservableList<String> ComboBoxList = FXCollections.observableArrayList("CSV", "Binary");

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

    public void initialize() {
        ComboBox.setItems(ComboBoxList);
        FilePresenter filePresenter = new FilePresenter();
        OpenButton.setOnAction(actionEvent -> filePresenter.OpenButton(ComboBox,ResultTextField));
        AddButton.setOnAction(actionEvent -> filePresenter.AddButton(ComboBox,ResultTextField));
        DeleteButton.setOnAction(actionEvent -> filePresenter.DeleteButton(ComboBox,ResultTextField));
        SaveButton.setOnAction(actionEvent -> filePresenter.SaveButton(ComboBox));
    }
}
