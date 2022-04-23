package com.example.spo.presenter;

import com.example.spo.HelloApplication;
import com.example.spo.view.MainView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPresenter {
    public static void AuthorsButtonAction(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AuthorsUI.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 352, 181);
            Stage stage = new Stage();
            stage.setTitle("Authors");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void Launch(MainView mainView){
        mainView.getAuthor_Button().setOnAction(actionEvent -> MainPresenter.AuthorsButtonAction());
        mainView.getC_Button().setOnAction(actionEvent -> MainPresenter.CButton());
        mainView.getFile_Button().setOnAction(actionEvent -> MainPresenter.FileButton());
        mainView.getAnalyze_Button().setOnAction(actionEvent -> MainPresenter.AnalyzerButton());
    }
    public static void CButton(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LowLevelFunctionsUI.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 171);
            Stage stage = new Stage();
            stage.setTitle("Low Level Functions");
            stage.setScene(scene);
            LowLevelFunctionsPresenter.Launch(fxmlLoader.getController());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void FileButton(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FileUI.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 331, 400);
            Stage stage = new Stage();
            stage.setTitle("File Handler");
            stage.setScene(scene);
            FilePresenterCsv.Launch(fxmlLoader.getController());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void AnalyzerButton(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AnalyzerUI.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 302, 400);
            Stage stage = new Stage();
            stage.setTitle("Analyzer");
            stage.setScene(scene);
            AnalyzerPresenter.Launch(fxmlLoader.getController());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
