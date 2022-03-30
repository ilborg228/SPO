module com.example.spo {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires compiler;
    requires org.slf4j;
    requires hibernate.entitymanager;
    requires hibernate.core;

    opens com.example.spo to javafx.fxml;
    exports com.example.spo;
    exports com.example.spo.presenter;
    opens com.example.spo.presenter to javafx.fxml;
    requires java.sql;
    requires java.persistence;
    exports com.example.spo.utils;
    opens com.example.spo.utils to javafx.fxml,javafx.controls;
    opens com.example.spo.model to javafx.fxml;
    exports com.example.spo.model;
}