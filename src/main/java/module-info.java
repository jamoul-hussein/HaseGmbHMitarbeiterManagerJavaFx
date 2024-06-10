module com.example.hasegmbhmitarbeitermanagerjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
	requires javafx.graphics;

    opens com.example.hasegmbhmitarbeitermanagerjavafx to javafx.fxml;
    exports com.example.hasegmbhmitarbeitermanagerjavafx;
    exports com.example.hasegmbhmitarbeitermanagerjavafx.pages;
    opens com.example.hasegmbhmitarbeitermanagerjavafx.pages to javafx.fxml;
    exports com.example.hasegmbhmitarbeitermanagerjavafx.employees;
    opens com.example.hasegmbhmitarbeitermanagerjavafx.employees to javafx.fxml;
}