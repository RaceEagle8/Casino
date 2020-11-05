module com.mycompany.roulette {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.roulette to javafx.fxml;
    exports com.mycompany.roulette;
}
