module com.mycompany.casino {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.casino to javafx.fxml;
    exports com.mycompany.casino;
}
