package com.example.spo.presenter;

import com.example.spo.HelloApplication;
import com.example.spo.model.Binary;
import com.example.spo.model.CSV;
import com.example.spo.view.InputDeleteNumberView;
import com.example.spo.view.InputView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FilePresenterBinary {
    private List<Binary> openedBinaryFile;
    private Binary binary;

    public void initialize(){
        this.binary = new Binary();
    }

    public void OpenButton(ChoiceBox ComboBox, TableView tableView){
        FileChooser fileChooser = new FileChooser();
        if (ComboBox.getValue() == "Binary") {
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Binary files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showOpenDialog(new Stage());
            if (file != null) {
                TableColumn<Binary,String> FirstField = new TableColumn<>("First Field");
                TableColumn<Binary,Long> SecondField = new TableColumn<>("Second Field");
                TableColumn<Binary,String> ThirdField = new TableColumn<>("Third Field");
                FirstField.setCellValueFactory(
                        new PropertyValueFactory<>("login")
                );
                SecondField.setCellValueFactory(
                        new PropertyValueFactory<>("hashcode")
                );
                ThirdField.setCellValueFactory(
                        new PropertyValueFactory<>("email")
                );
                tableView.getItems().clear();
                tableView.getColumns().clear();
                tableView.getColumns().addAll(FirstField,SecondField,ThirdField);
                openedBinaryFile = binary.open(file.getPath());
                for (int i = 0; i < openedBinaryFile.size(); i++) {
                    Binary openedFileElement = openedBinaryFile.get(i);
                    tableView.getItems().add(openedFileElement);
                }
            }
        }
    }

    public void AddButton(ChoiceBox ComboBox, TableView tableView){
        if (openedBinaryFile != null) {
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
                if (ComboBox.getValue() == "Binary" && isNumeric(inputPresenter.getSecondField())) {
                    binary.add(inputPresenter,tableView,openedBinaryFile);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void DeleteButton(ChoiceBox ComboBox, TableView tableView){
        if (openedBinaryFile != null) {
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
                int deleteThisNumber = inputDeletePresenter.getNumber();
                if (ComboBox.getValue() == "Binary") {
                    binary.delete(deleteThisNumber,tableView,openedBinaryFile);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void SaveButton(ChoiceBox ComboBox){
        FileChooser fileChooser = new FileChooser();
        try {
            if (ComboBox.getValue() == "Binary") {
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Binary files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);
                File file = fileChooser.showSaveDialog(new Stage());
                if (file != null) {
                    binary.save(openedBinaryFile, file.getPath());
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
