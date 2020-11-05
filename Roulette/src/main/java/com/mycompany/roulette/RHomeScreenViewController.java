package com.mycompany.roulette;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class RHomeScreenViewController {
    
    
    @FXML
    public void btnGoToGame(ActionEvent event) throws IOException {
        App.setRoot("RouletteView");
    }
    
}
