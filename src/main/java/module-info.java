module com.amdocs.amdd.extractviewer {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;

    opens com.amdocs.amdd.extractviewer to javafx.fxml;
    exports com.amdocs.amdd.extractviewer;
}