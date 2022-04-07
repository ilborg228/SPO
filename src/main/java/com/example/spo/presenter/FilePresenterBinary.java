package com.example.spo.presenter;

import com.example.spo.HelloApplication;
import com.example.spo.model.Binary;
import com.example.spo.view.InputDeleteNumberView;
import com.example.spo.view.InputView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
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

    public void OpenButton(ChoiceBox ComboBox, TextArea ResultTextField){
        FileChooser fileChooser = new FileChooser();
        if (ComboBox.getValue() == "Binary") {
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Binary files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showOpenDialog(new Stage());
            if (file != null) {
                openedBinaryFile = binary.open(file.getPath());
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
                    binary.add(inputPresenter,ResultTextField,openedBinaryFile);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void DeleteButton(ChoiceBox ComboBox, TextArea ResultTextField){
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
                int deleteThisNumber = inputDeletePresenter.getNumber() - 1;
                if(deleteThisNumber != -1){
                    if (ComboBox.getValue() == "Binary") {
                        binary.delete(deleteThisNumber,ResultTextField,openedBinaryFile);
                    }
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
