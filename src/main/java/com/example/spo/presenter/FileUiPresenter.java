package com.example.spo.presenter;

import com.example.spo.HelloApplication;
import com.example.spo.model.Binary;
import com.example.spo.model.CSV;
import com.example.spo.model.Element;
import com.example.spo.utils.BinaryFileUtil;
import com.example.spo.utils.CsvFileUtil;
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
                if (file != null) {
                    openedCSVFile = csvFileUtil.open(file.getPath());
                    String out = "№|Имя файла|Версия файла|Дата создания\n";
                    for (int i = 0; i < openedCSVFile.size(); i++) {
                        Element openedFileElement = openedCSVFile.get(i);
                        int Fixer = i + 1;
                        out = out + Fixer + "|" + openedFileElement.getFirstField() + "|" + openedFileElement.getSecondField() + "|" +
                                openedFileElement.getThirdField() + "\n";
                    }
                    ResultTextField.setText(out);
                }
            } else if (ComboBox.getValue() == "Binary") {
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Binary files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);
                File file = fileChooser.showOpenDialog(new Stage());
                if (file != null) {
                    openedBinaryFile = binaryFileUtil.open(file.getPath());
                    String out = "№|Логин|Хэш-код пароля|email\n";
                    for (int i = 0; i < openedBinaryFile.size(); i++) {
                        Element openedFileElement = openedBinaryFile.get(i);
                        int Fixer = i + 1;
                        out = out + Fixer + "|" + openedFileElement.getFirstField() + "|" + openedFileElement.getSecondField() + "|" +
                                openedFileElement.getThirdField() + "\n";
                    }
                    ResultTextField.setText(out);
                }
            }
        });
        AddButton.setOnAction(actionEvent -> {
            if (openedBinaryFile != null || openedCSVFile != null) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("InputUI.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 600, 108);
                    Stage stage = new Stage();
                    stage.setTitle("Input");
                    stage.setScene(scene);
                    InputUiPresenter inputUiPresenter = fxmlLoader.getController();
                    stage.showAndWait();
                    if (ComboBox.getValue() == "CSV") {
                        Element element = new CSV();
                        element.setFirstField(inputUiPresenter.getFirstField());
                        element.setSecondField(inputUiPresenter.getSecondField());
                        element.setThirdField(inputUiPresenter.getThirdField());
                        if(element.getFirstField() != null && element.getSecondField() != null &&
                                element.getThirdField() != null){
                            openedCSVFile.add(element);
                            String out = "№|Имя файла|Версия файла|Дата создания\n";
                            for (int i = 0; i < openedCSVFile.size(); i++) {
                                Element openedFileElement = openedCSVFile.get(i);
                                int Fixer = i + 1;
                                out = out + Fixer + "|" + openedFileElement.getFirstField() + "|" + openedFileElement.getSecondField() + "|" +
                                        openedFileElement.getThirdField() + "\n";
                            }
                            ResultTextField.setText(out);
                        }
                    } else if (ComboBox.getValue() == "Binary" && isNumeric(inputUiPresenter.getSecondField())) {
                        Element element = new Binary();
                        element.setFirstField(inputUiPresenter.getFirstField());
                        element.setSecondField(Long.parseLong(inputUiPresenter.getSecondField()));
                        element.setThirdField(inputUiPresenter.getThirdField());
                        if(element.getFirstField() != null && element.getSecondField() != null &&
                                element.getThirdField() != null) {
                            openedBinaryFile.add(element);
                            String out = "№|Логин|Хэш-код пароля|email\n";
                            for (int i = 0; i < openedBinaryFile.size(); i++) {
                                Element openedFileElement = openedBinaryFile.get(i);
                                int Fixer = i + 1;
                                out = out + Fixer + "|" + openedFileElement.getFirstField() + "|" + openedFileElement.getSecondField() + "|" +
                                        openedFileElement.getThirdField() + "\n";
                            }
                            ResultTextField.setText(out);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        DeleteButton.setOnAction(actionEvent -> {
            if (openedBinaryFile != null || openedCSVFile != null) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("InputDeleteNumberUI.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 236, 101);
                    Stage stage = new Stage();
                    stage.setTitle("Input");
                    stage.setScene(scene);
                    InputDeleteNumberUiPresenter inputDeleteNumberUiPresenter = fxmlLoader.getController();
                    stage.showAndWait();
                    int deleteThisNumber = inputDeleteNumberUiPresenter.getNumber() - 1;
                    if(deleteThisNumber != -1){
                        if (ComboBox.getValue() == "CSV") {
                            openedCSVFile.remove(deleteThisNumber);
                            String out = "№|Имя файла|Версия файла|Дата создания\n";
                            for (int i = 0; i < openedCSVFile.size(); i++) {
                                Element openedFileElement = openedCSVFile.get(i);
                                int Fixer = i + 1;
                                out = out + Fixer + "|" + openedFileElement.getFirstField() + "|" + openedFileElement.getSecondField() + "|" +
                                        openedFileElement.getThirdField() + "\n";
                            }
                            ResultTextField.setText(out);
                        } else if (ComboBox.getValue() == "Binary") {
                            openedBinaryFile.remove(deleteThisNumber);
                            String out = "№|Логин|Хэш-код пароля|email\n";
                            for (int i = 0; i < openedBinaryFile.size(); i++) {
                                Element openedFileElement = openedBinaryFile.get(i);
                                int Fixer = i + 1;
                                out = out + Fixer + "|" + openedFileElement.getFirstField() + "|" + openedFileElement.getSecondField() + "|" +
                                        openedFileElement.getThirdField() + "\n";
                            }
                            ResultTextField.setText(out);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        SaveButton.setOnAction(actionEvent -> {
            FileChooser fileChooser = new FileChooser();
            try {
                if (ComboBox.getValue() == "CSV") {
                    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
                    fileChooser.getExtensionFilters().add(extFilter);
                    File file = fileChooser.showOpenDialog(new Stage());
                    if (file != null) {
                        csvFileUtil.save(openedCSVFile, file.getPath());
                    }
                } else if (ComboBox.getValue() == "Binary") {
                    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Binary files (*.txt)", "*.txt");
                    fileChooser.getExtensionFilters().add(extFilter);
                    File file = fileChooser.showOpenDialog(new Stage());
                    if (file != null) {
                        binaryFileUtil.save(openedBinaryFile, file.getPath());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
