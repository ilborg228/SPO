module com.example.spo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.compiler;
    requires lombok;


    opens com.example.spo to javafx.fxml;
    exports com.example.spo;
    exports com.example.spo.presenter;
    opens com.example.spo.presenter to javafx.fxml;
}