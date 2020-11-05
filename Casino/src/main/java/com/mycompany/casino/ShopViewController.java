/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.casino;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Karin
 */
public class ShopViewController implements Initializable {

    @FXML
    private Text CoinsShop;
    @FXML
    private Button btnRouletteID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for(User user : App.getAllUsers()){
            if(user.getLoggedIn() == true){
                CoinsShop.setText(String.valueOf(user.getCoins()));
            }
        }
    }    

    @FXML
    private void btnBackShop(ActionEvent event) throws IOException {
        App.setRoot("MainGame");
    }

    @FXML
    private void btnRoulette(ActionEvent event) throws IOException {
        App.setRoot("RHomeScreenView");
    }
    
    
}
