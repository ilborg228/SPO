package com.example.spo.presenter;

import com.example.spo.model.Element;
import com.example.spo.utils.BinaryFileUtil;
import com.example.spo.utils.CsvFileUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileUiPresenter {
    ObservableList<String> ComboBoxList = FXCollections.observableArrayList("CSV", "Binary");
    List<Element> openedCSVFile;
    List<Element> openedBinaryFile;

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
        OpenButton.setOnAction(actionEvent -> {
            FileChooser fileChooser = new FileChooser();
            if (ComboBox.getValue() == "CSV") {
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
                fileChooser.getExtensionFilters().add(extFilter);
                File file = fileChooser.showOpenDialog(new Stage());
                if(file != null){
                    openedCSVFile = csvFileUtil.open(file.getPath());
                    String out = "№|Имя файла|Версия файла|Дата создания\n";
                    for (int i = 0; i < openedCSVFile.size(); i++) {
                        Element openedFileElement = openedCSVFile.get(i);
                        out = out + i + "|" + openedFileElement.getFirstField() + "|" + openedFileElement.getSecondField() + "|" +
                                openedFileElement.getThirdField() + "\n";
                    }
                    ResultTextField.setText(out);
                }
            } else if (ComboBox.getValue() == "Binary") {
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Binary files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);
                File file = fileChooser.showOpenDialog(new Stage());
                if(file != null){
                    openedBinaryFile = binaryFileUtil.open(file.getPath());
                    String out = "№|Логин|Хэш-код пароля|email\n";
                    for (int i = 0; i < openedBinaryFile.size(); i++) {
                        Element openedFileElement = openedBinaryFile.get(i);
                        out = out + i + "|" + openedFileElement.getFirstField() + "|" + openedFileElement.getSecondField() + "|" +
                                openedFileElement.getThirdField() + "\n";
                    }
                    ResultTextField.setText(out);
                }
            }
        });
        AddButton.setOnAction(actionEvent -> {
            if (ComboBox.getValue() == "CSV") {

            } else if (ComboBox.getValue() == "Binary") {

            }
        });
        DeleteButton.setOnAction(actionEvent -> {
            if (ComboBox.getValue() == "CSV") {

            } else if (ComboBox.getValue() == "Binary") {

            }
        });
        SaveButton.setOnAction(actionEvent -> {
            FileChooser fileChooser = new FileChooser();
            try{
                if (ComboBox.getValue() == "CSV") {
                    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
                    fileChooser.getExtensionFilters().add(extFilter);
                    File file = fileChooser.showOpenDialog(new Stage());
                    if(file != null){
                        csvFileUtil.save(openedCSVFile,file.getPath());
                    }
                } else if (ComboBox.getValue() == "Binary") {
                    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Binary files (*.txt)", "*.txt");
                    fileChooser.getExtensionFilters().add(extFilter);
                    File file = fileChooser.showOpenDialog(new Stage());
                    if(file != null){
                        binaryFileUtil.save(openedBinaryFile, file.getPath());
                    }
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        });
    }
}
