package com.mycompany.casino;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainScreenController {

    

    @FXML
    private void btnLogin(ActionEvent event) throws IOException {
        App.setRoot("Login");
    }

    @FXML
    private void btnRegistrieren(ActionEvent event) throws IOException {
        App.setRoot("Registration");
    }
}
