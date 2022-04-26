package com.example.spo.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class MainView {
    public TextArea getLogger() {
        return logger;
    }

    @FXML
    private TextArea logger;

    @FXML
    private Button Analyze_Button;

    public Button getAnalyze_Button(){
        return  this.Analyze_Button;
    }

    @FXML
    private Button Author_Button;

    public Button getAuthor_Button(){
        return  this.Author_Button;
    }

    @FXML
    private Button C_Button;

    public Button getC_Button(){
        return  this.C_Button;
    }

    @FXML
    private Button File_Button;

    public Button getFile_Button(){
        return  this.File_Button;
    }

    public void initialize() {
    }
}
