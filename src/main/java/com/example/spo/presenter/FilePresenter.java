package com.example.spo.presenter;

import com.example.spo.HelloApplication;
import com.example.spo.model.Binary;
import com.example.spo.model.CSV;
import com.example.spo.view.FileView;
import com.example.spo.view.InputDeleteNumberView;
import com.example.spo.view.InputView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FilePresenter {
    private List<CSV> openedCSVFile;

    public static void Launch(FileView fileView){
        ObservableList<String> ComboBoxList = FXCollections.observableArrayList("CSV", "Binary");
        fileView.getComboBox().setItems(ComboBoxList);
        FilePresenter filePresenter = new FilePresenter();
        CSV csv = new CSV();
        FilePresenterBinary filePresenterBinary = new FilePresenterBinary();
        filePresenterBinary.initialize();
        fileView.getOpenButton().setOnAction(actionEvent -> filePresenter.OpenButton(fileView.getComboBox(), fileView.getResultTextField(),filePresenterBinary,csv));
        fileView.getAddButton().setOnAction(actionEvent -> filePresenter.AddButton(fileView.getComboBox(), fileView.getResultTextField(),filePresenterBinary,csv));
        fileView.getDeleteButton().setOnAction(actionEvent -> filePresenter.DeleteButton(fileView.getComboBox(), fileView.getResultTextField(),filePresenterBinary,csv));
        fileView.getSaveButton().setOnAction(actionEvent -> filePresenter.SaveButton(fileView.getComboBox(),filePresenterBinary,csv));
    }

    public void OpenButton(ChoiceBox ComboBox, TextArea ResultTextField,FilePresenterBinary filePresenterBinary,CSV csv) {
        FileChooser fileChooser = new FileChooser();
        if (ComboBox.getValue() == "CSV") {
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showOpenDialog(new Stage());
            if (file != null) {
                openedCSVFile = csv.open(file.getPath());
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
            filePresenterBinary.OpenButton(ComboBox, ResultTextField);
        }
    }

    public void AddButton(ChoiceBox ComboBox, TextArea ResultTextField,FilePresenterBinary filePresenterBinary,CSV csv){
        if (ComboBox.getValue() == "CSV") {
            if (openedCSVFile != null) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("InputUI.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 600, 108);
                    Stage stage = new Stage();
                    stage.setTitle("Input");
                    stage.setScene(scene);
                    InputView inputView = fxmlLoader.getController();
                    InputPresenter.Launch(inputView);
                    InputPresenter inputPresenter = inputView.getInputPresenter();
                    stage.showAndWait();
                    if (ComboBox.getValue() == "CSV") {
                        csv.add(inputPresenter,ResultTextField,openedCSVFile);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (ComboBox.getValue() == "Binary") {
            filePresenterBinary.AddButton(ComboBox,ResultTextField);
        }

    }

    public void DeleteButton(ChoiceBox ComboBox, TextArea ResultTextField,FilePresenterBinary filePresenterBinary,CSV csv){
        if (ComboBox.getValue() == "CSV") {
            if ( openedCSVFile != null) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("InputDeleteNumberUI.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 236, 101);
                    Stage stage = new Stage();
                    stage.setTitle("Input");
                    stage.setScene(scene);
                    InputDeleteNumberView inputDeleteNumberView = fxmlLoader.getController();
                    InputDeletePresenter.Launch(inputDeleteNumberView);
                    InputDeletePresenter inputDeletePresenter= inputDeleteNumberView.getInputDeleteView();
                    stage.showAndWait();
                    int deleteThisNumber = inputDeletePresenter.getNumber() - 1;
                    if(deleteThisNumber != -1){
                        if (ComboBox.getValue() == "CSV") {
                            csv.delete(deleteThisNumber,ResultTextField,openedCSVFile);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (ComboBox.getValue() == "Binary") {
            filePresenterBinary.DeleteButton(ComboBox,ResultTextField);
        }

    }

    public void SaveButton(ChoiceBox ComboBox,FilePresenterBinary filePresenterBinary,CSV csv){
        FileChooser fileChooser = new FileChooser();
        try {
            if (ComboBox.getValue() == "CSV") {
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
                fileChooser.getExtensionFilters().add(extFilter);
                File file = fileChooser.showSaveDialog(new Stage());
                if (file != null) {
                    csv.save(openedCSVFile, file.getPath());
                }
            } else if (ComboBox.getValue() == "Binary") {
                filePresenterBinary.SaveButton(ComboBox);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
