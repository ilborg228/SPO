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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FilePresenterBinary {
    private List<Binary> openedBinaryFile;
    private Binary binary;

    public void initialize(){
        this.binary = new Binary();
    }

    public void OpenButton(ChoiceBox ComboBox, TableView tableView,TextArea Logger){
        FileChooser fileChooser = new FileChooser();
        if (ComboBox.getValue() == "Binary") {
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            StringBuilder stringBuilder = new StringBuilder(Logger.getText());
            stringBuilder.append(dateTime.format(formatter));
            stringBuilder.append(" Окно работы с файлами. Запуск открытия файла.\n");
            Logger.setText(stringBuilder.toString());
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Binary files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showOpenDialog(new Stage());
            if (file != null) {
                TableColumn<Binary,String> FirstField = new TableColumn<>("Login");
                TableColumn<Binary,Long> SecondField = new TableColumn<>("Hashcode");
                TableColumn<Binary,String> ThirdField = new TableColumn<>("Email");
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
                dateTime = LocalDateTime.now();
                stringBuilder = new StringBuilder(Logger.getText());
                stringBuilder.append(dateTime.format(formatter));
                stringBuilder.append(" Окно работы с файлами. Файл открыт.\n");
                Logger.setText(stringBuilder.toString());
            }else{
                dateTime = LocalDateTime.now();
                stringBuilder = new StringBuilder(Logger.getText());
                stringBuilder.append(dateTime.format(formatter));
                stringBuilder.append(" Окно работы с файлами. Ошибка: Файл не найден.\n");
                Logger.setText(stringBuilder.toString());
            }
        }
    }

    public void AddButton(ChoiceBox ComboBox, TableView tableView,TextArea Logger){
        if (openedBinaryFile != null) {
            try {
                LocalDateTime dateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                StringBuilder stringBuilder = new StringBuilder(Logger.getText());
                stringBuilder.append(dateTime.format(formatter));
                stringBuilder.append(" Окно работы с файлами. Запуск добавления новой записи.\n");
                Logger.setText(stringBuilder.toString());
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("InputUI.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 600, 108);
                Stage stage = new Stage();
                stage.setTitle("Input");
                stage.setScene(scene);
                InputView inputView = fxmlLoader.getController();
                inputView.getLabelOne().setText("Login");
                inputView.getLabelTwo().setText("Hashcode");
                inputView.getLabelThree().setText("Email");
                InputPresenter.Launch(inputView);
                InputPresenter inputPresenter = inputView.getInputPresenter();
                inputPresenter.setLogger(Logger);
                stage.showAndWait();
                if (ComboBox.getValue() == "Binary" && isNumeric(inputPresenter.getSecondField())) {
                    binary.add(inputPresenter,tableView,openedBinaryFile);
                }
            } catch (IOException e) {
                e.printStackTrace();
                LocalDateTime dateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                StringBuilder stringBuilder = new StringBuilder(Logger.getText());
                stringBuilder.append(dateTime.format(formatter));
                stringBuilder.append(" Окно работы с файлами. Ошибка: "+e.getMessage()+"\n");
                Logger.setText(stringBuilder.toString());
            }
        }
    }

    public void DeleteButton(ChoiceBox ComboBox, TableView tableView,TextArea Logger){
        if (openedBinaryFile != null) {
            try {
                LocalDateTime dateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                StringBuilder stringBuilder = new StringBuilder(Logger.getText());
                stringBuilder.append(dateTime.format(formatter));
                stringBuilder.append(" Окно работы с файлами. Запуск удаления записи.\n");
                Logger.setText(stringBuilder.toString());
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("InputDeleteNumberUI.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 236, 101);
                Stage stage = new Stage();
                stage.setTitle("Input");
                stage.setScene(scene);
                InputDeleteNumberView inputDeleteNumberView = fxmlLoader.getController();
                InputDeletePresenter.Launch(inputDeleteNumberView);
                InputDeletePresenter inputDeletePresenter= inputDeleteNumberView.getInputDeleteView();
                inputDeletePresenter.setLogger(Logger);
                stage.showAndWait();
                int deleteThisNumber = inputDeletePresenter.getNumber();
                if(deleteThisNumber >= 0 && deleteThisNumber<=openedBinaryFile.size()){
                    if (ComboBox.getValue() == "Binary") {
                        binary.delete(deleteThisNumber,tableView,openedBinaryFile);
                        dateTime = LocalDateTime.now();
                        stringBuilder = new StringBuilder(Logger.getText());
                        stringBuilder.append(dateTime.format(formatter));
                        stringBuilder.append(" Окно работы с файлами. Удаление завершено.\n");
                        Logger.setText(stringBuilder.toString());
                    }
                }else {
                    dateTime = LocalDateTime.now();
                    stringBuilder = new StringBuilder(Logger.getText());
                    stringBuilder.append(dateTime.format(formatter));
                    stringBuilder.append(" Окно работы с файлами. Ошибка в формате числа!.\n");
                    Logger.setText(stringBuilder.toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
                LocalDateTime dateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                StringBuilder stringBuilder = new StringBuilder(Logger.getText());
                stringBuilder.append(dateTime.format(formatter));
                stringBuilder.append(" Окно работы с файлами. Ошибка: "+e.getMessage()+"\n");
                Logger.setText(stringBuilder.toString());
            }
        }
    }

    public void SaveButton(ChoiceBox ComboBox,TextArea Logger){
        FileChooser fileChooser = new FileChooser();
        try {
            if (ComboBox.getValue() == "Binary") {
                LocalDateTime dateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                StringBuilder stringBuilder = new StringBuilder(Logger.getText());
                stringBuilder.append(dateTime.format(formatter));
                stringBuilder.append(" Окно работы с файлами. Запуск процедуры сохранения файла.\n");
                Logger.setText(stringBuilder.toString());
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Binary files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);
                File file = fileChooser.showSaveDialog(new Stage());
                if (file != null) {
                    binary.save(openedBinaryFile, file.getPath());
                    dateTime = LocalDateTime.now();
                    stringBuilder = new StringBuilder(Logger.getText());
                    stringBuilder.append(dateTime.format(formatter));
                    stringBuilder.append(" Окно работы с файлами. Файл сохранен.\n");
                    Logger.setText(stringBuilder.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            StringBuilder stringBuilder = new StringBuilder(Logger.getText());
            stringBuilder.append(dateTime.format(formatter));
            stringBuilder.append(" Окно работы с файлами. Ошибка: "+e.getMessage()+"\n");
            Logger.setText(stringBuilder.toString());
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
