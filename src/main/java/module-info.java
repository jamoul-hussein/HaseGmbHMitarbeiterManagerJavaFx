module com.example.hasegmbhmitarbeitermanagerjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
	requires javafx.graphics;

    opens com.example.hasegmbhmitarbeitermanagerjavafx.controller to javafx.fxml;
    opens com.example.hasegmbhmitarbeitermanagerjavafx.view to javafx.fxml;
    opens com.example.hasegmbhmitarbeitermanagerjavafx.model to javafx.fxml;
    exports com.example.hasegmbhmitarbeitermanagerjavafx.controller;
    exports com.example.hasegmbhmitarbeitermanagerjavafx.view;
    exports com.example.hasegmbhmitarbeitermanagerjavafx.model;
    exports com.example.hasegmbhmitarbeitermanagerjavafx;
    opens com.example.hasegmbhmitarbeitermanagerjavafx to javafx.fxml;
}