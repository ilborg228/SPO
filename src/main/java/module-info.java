module com.example.spo {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires compiler;
    requires org.slf4j;

    opens com.example.spo to javafx.fxml;
    exports com.example.spo;
    exports com.example.spo.presenter;
    opens com.example.spo.presenter to javafx.fxml;
    requires org.hibernate.orm.core;
    requires java.sql;
    requires java.persistence;
    exports com.example.spo.utils;
    opens com.example.spo.utils to javafx.fxml,javafx.controls;
    opens com.example.spo.model to javafx.fxml;
    exports com.example.spo.model;
}