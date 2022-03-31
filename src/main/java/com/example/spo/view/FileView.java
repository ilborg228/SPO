package com.example.spo.view;

import com.example.spo.HelloApplication;
import com.example.spo.model.Binary;
import com.example.spo.model.CSV;
import com.example.spo.presenter.InputDeleteNumberPresenter;
import com.example.spo.presenter.InputPresenter;
import com.example.spo.utils.BinaryFileUtil;
import com.example.spo.utils.CsvFileUtil;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileView {
    private List<CSV> openedCSVFile;
    private List<Binary> openedBinaryFile;
    public void OpenButton(CsvFileUtil csvFileUtil, BinaryFileUtil binaryFileUtil, ChoiceBox ComboBox, TextArea ResultTextField){
        FileChooser fileChooser = new FileChooser();
        if (ComboBox.getValue() == "CSV") {
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showOpenDialog(new Stage());
            if (file != null) {
                openedCSVFile = csvFileUtil.open(file.getPath());
                String out = "№|Имя файла|Версия файла|Дата создания\n";
                for (int i = 0; i < openedCSVFile.size(); i++) {
                    CSV openedFileElement = openedCSVFile.get(i);
                    int Fixer = i + 1;
                    out = out + Fixer + "|" + openedFileElement.getFileName() + "|" + openedFileElement.getVersion() + "|" +
                            openedFileElement.getCreation() + "\n";
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
                    Binary openedFileElement = openedBinaryFile.get(i);
                    int Fixer = i + 1;
                    out = out + Fixer + "|" + openedFileElement.getLogin() + "|" + openedFileElement.getHashcode() + "|" +
                            openedFileElement.getEmail() + "\n";
                }
                ResultTextField.setText(out);
            }
        }
    }

    public void AddButton(ChoiceBox ComboBox, TextArea ResultTextField){
        if (openedBinaryFile != null || openedCSVFile != null) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("InputUI.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 600, 108);
                Stage stage = new Stage();
                stage.setTitle("Input");
                stage.setScene(scene);
                InputPresenter inputPresenter = fxmlLoader.getController();
                InputView inputView = inputPresenter.getInputView();
                stage.showAndWait();
                if (ComboBox.getValue() == "CSV") {
                    CSV element = new CSV();
                    element.setFileName(inputView.getFirstField());
                    element.setVersion(inputView.getSecondField());
                    element.setCreation(inputView.getThirdField());
                    if(element.getFileName() != null && element.getVersion() != null &&
                            element.getCreation() != null){
                        openedCSVFile.add(element);
                        String out = "№|Имя файла|Версия файла|Дата создания\n";
                        for (int i = 0; i < openedCSVFile.size(); i++) {
                            CSV openedFileElement = openedCSVFile.get(i);
                            int Fixer = i + 1;
                            out = out + Fixer + "|" + openedFileElement.getFileName() + "|" + openedFileElement.getVersion() + "|" +
                                    openedFileElement.getCreation() + "\n";
                        }
                        ResultTextField.setText(out);
                    }
                } else if (ComboBox.getValue() == "Binary" && isNumeric(inputView.getSecondField())) {
                    Binary element = new Binary();
                    element.setLogin(inputView.getFirstField());
                    element.setHashcode(Long.parseLong(inputView.getSecondField()));
                    element.setEmail(inputView.getThirdField());
                    if(element.getLogin() != null && element.getHashcode() != null &&
                            element.getEmail() != null) {
                        openedBinaryFile.add(element);
                        String out = "№|Логин|Хэш-код пароля|email\n";
                        for (int i = 0; i < openedBinaryFile.size(); i++) {
                            Binary openedFileElement = openedBinaryFile.get(i);
                            int Fixer = i + 1;
                            out = out + Fixer + "|" + openedFileElement.getLogin() + "|" + openedFileElement.getHashcode() + "|" +
                                    openedFileElement.getEmail() + "\n";
                        }
                        ResultTextField.setText(out);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void DeleteButton(ChoiceBox ComboBox, TextArea ResultTextField){
        if (openedBinaryFile != null || openedCSVFile != null) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("InputDeleteNumberUI.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 236, 101);
                Stage stage = new Stage();
                stage.setTitle("Input");
                stage.setScene(scene);
                InputDeleteNumberPresenter inputDeleteNumberUiPresenter = fxmlLoader.getController();
                InputDeleteView inputDeleteView = inputDeleteNumberUiPresenter.getInputDeleteView();
                stage.showAndWait();
                int deleteThisNumber = inputDeleteView.getNumber() - 1;
                if(deleteThisNumber != -1){
                    if (ComboBox.getValue() == "CSV") {
                        openedCSVFile.remove(deleteThisNumber);
                        String out = "№|Имя файла|Версия файла|Дата создания\n";
                        for (int i = 0; i < openedCSVFile.size(); i++) {
                            CSV openedFileElement = openedCSVFile.get(i);
                            int Fixer = i + 1;
                            out = out + Fixer + "|" + openedFileElement.getFileName() + "|" + openedFileElement.getVersion() + "|" +
                                    openedFileElement.getCreation() + "\n";
                        }
                        ResultTextField.setText(out);
                    } else if (ComboBox.getValue() == "Binary") {
                        openedBinaryFile.remove(deleteThisNumber);
                        String out = "№|Логин|Хэш-код пароля|email\n";
                        for (int i = 0; i < openedBinaryFile.size(); i++) {
                            Binary openedFileElement = openedBinaryFile.get(i);
                            int Fixer = i + 1;
                            out = out + Fixer + "|" + openedFileElement.getLogin() + "|" + openedFileElement.getHashcode() + "|" +
                                    openedFileElement.getEmail() + "\n";
                        }
                        ResultTextField.setText(out);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void SaveButton(CsvFileUtil csvFileUtil, BinaryFileUtil binaryFileUtil,
                                  ChoiceBox ComboBox){
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
