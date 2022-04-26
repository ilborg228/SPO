package com.example.spo.presenter;

import com.example.spo.HelloApplication;
import com.example.spo.model.CSV;
import com.example.spo.view.FileView;
import com.example.spo.view.InputDeleteNumberView;
import com.example.spo.view.InputView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class FilePresenterCsv {
    private List<CSV> openedCSVFile;

    public static void Launch(FileView fileView, TextArea Logger) {
        ObservableList<String> ComboBoxList = FXCollections.observableArrayList("CSV", "Binary");
        fileView.getComboBox().setItems(ComboBoxList);
        FilePresenterCsv filePresenterCsv = new FilePresenterCsv();
        CSV csv = new CSV();
        FilePresenterBinary filePresenterBinary = new FilePresenterBinary();
        filePresenterBinary.initialize();
        TableView tableView = fileView.getGridTable();
        tableView.setEditable(true);
        fileView.getOpenButton().setOnAction(actionEvent -> filePresenterCsv.OpenButton(fileView.getComboBox(), tableView, filePresenterBinary, csv));
        fileView.getAddButton().setOnAction(actionEvent -> filePresenterCsv.AddButton(fileView.getComboBox(), tableView, filePresenterBinary, csv));
        fileView.getDeleteButton().setOnAction(actionEvent -> filePresenterCsv.DeleteButton(fileView.getComboBox(), tableView, filePresenterBinary, csv));
        fileView.getSaveButton().setOnAction(actionEvent -> filePresenterCsv.SaveButton(fileView.getComboBox(), filePresenterBinary, csv));
    }

    public void OpenButton(ChoiceBox ComboBox, TableView tableView, FilePresenterBinary filePresenterBinary, CSV csv) {
        FileChooser fileChooser = new FileChooser();
        if (ComboBox.getValue() == "CSV") {
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showOpenDialog(new Stage());
            if (file != null) {
                TableColumn<CSV,String> FirstField = new TableColumn<>("File name");
                TableColumn<CSV,String> SecondField = new TableColumn<>("Version");
                TableColumn<CSV,String> ThirdField = new TableColumn<>("Creation");
                FirstField.setCellValueFactory(
                        new PropertyValueFactory<>("fileName")
                );
                SecondField.setCellValueFactory(
                        new PropertyValueFactory<>("version")
                );
                ThirdField.setCellValueFactory(
                        new PropertyValueFactory<>("creation")
                );
                tableView.getItems().clear();
                tableView.getColumns().clear();
                tableView.getColumns().addAll(FirstField,SecondField,ThirdField);
                openedCSVFile = csv.open(file.getPath());
                for (int i = 0; i < openedCSVFile.size(); i++) {
                    CSV openedFileElement = openedCSVFile.get(i);
                    tableView.getItems().add(openedFileElement);
                }
            }
        } else if (ComboBox.getValue() == "Binary") {
            filePresenterBinary.OpenButton(ComboBox, tableView);
        }
    }

    public void AddButton(ChoiceBox ComboBox, TableView tableView,FilePresenterBinary filePresenterBinary,CSV csv){
        if (ComboBox.getValue() == "CSV") {
            if (openedCSVFile != null) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("InputUI.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 600, 108);
                    Stage stage = new Stage();
                    stage.setTitle("Input");
                    stage.setScene(scene);
                    InputView inputView = fxmlLoader.getController();
                    inputView.getLabelOne().setText("File name");
                    inputView.getLabelTwo().setText("Version");
                    inputView.getLabelThree().setText("Creation");
                    InputPresenter.Launch(inputView);
                    InputPresenter inputPresenter = inputView.getInputPresenter();
                    stage.showAndWait();
                    if (ComboBox.getValue() == "CSV") {
                        csv.add(inputPresenter,tableView,openedCSVFile);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (ComboBox.getValue() == "Binary") {
            filePresenterBinary.AddButton(ComboBox,tableView);
        }

    }

    public void DeleteButton(ChoiceBox ComboBox, TableView tableView,FilePresenterBinary filePresenterBinary,CSV csv){
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
                    if(deleteThisNumber != -1 && deleteThisNumber<openedCSVFile.size()){
                        if (ComboBox.getValue() == "CSV") {
                            csv.delete(deleteThisNumber,tableView,openedCSVFile);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (ComboBox.getValue() == "Binary") {
            filePresenterBinary.DeleteButton(ComboBox,tableView);
        }
    }

    public void SaveButton(ChoiceBox ComboBox, FilePresenterBinary filePresenterBinary, CSV csv) {
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
