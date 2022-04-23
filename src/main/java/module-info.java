module com.example.spo {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires compiler;
    requires org.slf4j;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;

    opens com.example.spo to javafx.fxml;
    exports com.example.spo;
    exports com.example.spo.view;
    opens com.example.spo.view to javafx.fxml;
    exports com.example.spo.utils;
    opens com.example.spo.utils to javafx.fxml,javafx.controls;
    opens com.example.spo.model to javafx.fxml;
    exports com.example.spo.model;
    exports com.example.spo.analyzer;
    opens com.example.spo.analyzer to javafx.controls, javafx.fxml;
    exports com.example.spo.exception;
}