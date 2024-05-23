module com.example.hasegmbhmitarbeitermanagerjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
	requires javafx.graphics;

    opens com.example.hasegmbhmitarbeitermanagerjavafx to javafx.fxml;
    exports com.example.hasegmbhmitarbeitermanagerjavafx;
}