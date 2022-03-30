package com.example.spo.presenter;

import com.example.spo.HelloApplication;
import com.example.spo.model.Binary;
import com.example.spo.model.CSV;
import com.example.spo.utils.BinaryFileUtil;
import com.example.spo.utils.CsvFileUtil;
import com.example.spo.view.FileView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FilePresenter {
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
        CsvFileUtil csvFileUtil = new CsvFileUtil();
        BinaryFileUtil binaryFileUtil = new BinaryFileUtil();
        FileView fileView = new FileView();
        OpenButton.setOnAction(actionEvent -> fileView.OpenButton(csvFileUtil,binaryFileUtil,ComboBox,ResultTextField));
        AddButton.setOnAction(actionEvent -> fileView.AddButton(ComboBox,ResultTextField));
        DeleteButton.setOnAction(actionEvent -> fileView.DeleteButton(ComboBox,ResultTextField));
        SaveButton.setOnAction(actionEvent -> fileView.SaveButton(csvFileUtil,binaryFileUtil,ComboBox));
    }
}
