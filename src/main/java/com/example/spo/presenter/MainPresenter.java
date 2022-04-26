package com.example.spo.presenter;

import com.example.spo.HelloApplication;
import com.example.spo.view.MainView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainPresenter {
    public static void AuthorsButtonAction(TextArea Logger){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AuthorsUI.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 352, 181);
            Stage stage = new Stage();
            stage.setTitle("Authors");
            stage.setScene(scene);
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            StringBuilder stringBuilder = new StringBuilder(Logger.getText());
            stringBuilder.append(dateTime.format(formatter));
            stringBuilder.append(" Открыто окно с информацией об авторах.\n");
            Logger.setText(stringBuilder.toString());
            stage.showAndWait();
            dateTime = LocalDateTime.now();
            stringBuilder = new StringBuilder(Logger.getText());
            stringBuilder.append(dateTime.format(formatter));
            stringBuilder.append(" Закрыто окно с информацией об авторах.\n");
            Logger.setText(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void Launch(MainView mainView){
        mainView.getAuthor_Button().setOnAction(actionEvent -> MainPresenter.AuthorsButtonAction(mainView.getLogger()));
        mainView.getC_Button().setOnAction(actionEvent -> MainPresenter.CButton(mainView.getLogger()));
        mainView.getFile_Button().setOnAction(actionEvent -> MainPresenter.FileButton(mainView.getLogger()));
        mainView.getAnalyze_Button().setOnAction(actionEvent -> MainPresenter.AnalyzerButton(mainView.getLogger()));
    }
    public static void CButton(TextArea Logger){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LowLevelFunctionsUI.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 171);
            Stage stage = new Stage();
            stage.setTitle("Low Level Functions");
            stage.setScene(scene);
            LowLevelFunctionsPresenter.Launch(fxmlLoader.getController(),Logger);
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            StringBuilder stringBuilder = new StringBuilder(Logger.getText());
            stringBuilder.append(dateTime.format(formatter));
            stringBuilder.append(" Открыто окно с низкоуровневыми функциями.\n");
            Logger.setText(stringBuilder.toString());
            stage.showAndWait();
            dateTime = LocalDateTime.now();
            stringBuilder = new StringBuilder(Logger.getText());
            stringBuilder.append(dateTime.format(formatter));
            stringBuilder.append(" Закрыто окно с низкоуровневыми функциями.\n");
            Logger.setText(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void FileButton(TextArea Logger){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FileUI.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 331, 400);
            Stage stage = new Stage();
            stage.setTitle("File Handler");
            stage.setScene(scene);
            FilePresenterCsv.Launch(fxmlLoader.getController(),Logger);
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            StringBuilder stringBuilder = new StringBuilder(Logger.getText());
            stringBuilder.append(dateTime.format(formatter));
            stringBuilder.append(" Открыто окно для работы с файлами.\n");
            Logger.setText(stringBuilder.toString());
            stage.showAndWait();
            dateTime = LocalDateTime.now();
            stringBuilder = new StringBuilder(Logger.getText());
            stringBuilder.append(dateTime.format(formatter));
            stringBuilder.append(" Закрыто окно для работы с файлами.\n");
            Logger.setText(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void AnalyzerButton(TextArea Logger){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AnalyzerUI.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 302, 400);
            Stage stage = new Stage();
            stage.setTitle("Analyzer");
            stage.setScene(scene);
            AnalyzerPresenter.Launch(fxmlLoader.getController(),Logger);

            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            StringBuilder stringBuilder = new StringBuilder(Logger.getText());
            stringBuilder.append(dateTime.format(formatter));
            stringBuilder.append(" Открыто окно с анализатором.\n");
            Logger.setText(stringBuilder.toString());
            stage.showAndWait();
            dateTime = LocalDateTime.now();
            stringBuilder = new StringBuilder(Logger.getText());
            stringBuilder.append(dateTime.format(formatter));
            stringBuilder.append(" Закрыто окно с анализатором.\n");
            Logger.setText(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
