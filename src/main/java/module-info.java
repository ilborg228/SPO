module com.example.spo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.spo.presenter to javafx.fxml;
    exports com.example.spo.presenter;
}