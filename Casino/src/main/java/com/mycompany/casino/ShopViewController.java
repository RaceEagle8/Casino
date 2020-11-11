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
    @FXML
    private Button btnWuerfelnID;
    @FXML
    private Text Level;
    @FXML
    private Text FehlerMRoulette;
    @FXML
    private Text FehlerMWuerfel;
    
    public User ShopUser;
    @FXML
    private Button KaufenR;
    @FXML
    private Button KaufenW;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        FehlerMRoulette.setText("");
        FehlerMWuerfel.setText("");
        KaufenR.setVisible(false);
        KaufenW.setVisible(false);
        
        for(User user : App.getAllUsers()){
            if(user.getLoggedIn() == true){
                
                ShopUser = user;
                        
                int I = 0;
                if(user.getLevel() >= 10 && user.getLevel() < 20){
                    I = 1;
                }
                else if(user.getLevel() >= 20 && user.getLevel() < 30){
                    I = 2;
                }
                else if(user.getLevel() >= 30){
                    I = 3;
                }
                Level.setText("Level: " + String.valueOf(I));
                
                CoinsShop.setText("COINS: " + String.valueOf(user.getCoins()));
            }
        }
    }    



    @FXML
    private void btnRoulette(ActionEvent event) throws IOException {
        if(ShopUser.getLevel() < 20){
            FehlerMRoulette.setText("Dein Level ist zu gering spiele andere Spiele um es zu erhöhen!");
        }
        else if(ShopUser.getRoulette() == false){
            FehlerMRoulette.setText("Du musst das Spiel frei kaufen für 2500 COINS!");
            KaufenR.setVisible(true);
        }
        else{
            App.setRoot("RouletteView");
        }
        
        
        
    }

    @FXML
    private void btnWuerfln(ActionEvent event) throws IOException {
        
        if(ShopUser.getLevel() < 10){
            FehlerMWuerfel.setText("Dein Level ist zu gering spiele andere Spiele um es zu erhöhen!");
        }
        else if(ShopUser.getWuerfeln() == false){
            FehlerMWuerfel.setText("Du musst das Spiel frei Kaufen für 1000 COINS!");
            KaufenW.setVisible(true);
        }
        else{
            App.setRoot("WuerfelGameView");
        }
        
        
        
    }

    @FXML
    private void btnMainGame(ActionEvent event) throws IOException {
        App.setRoot("MainGame");
    }

    @FXML
    private void btnKaufenR(ActionEvent event) throws IOException {
        if((ShopUser.getCoins() -2500) < 100){
            FehlerMRoulette.setText("Bitte erspiele dir Mehr Geld, sonst hast du zu wenig!");
        }
        else{
            ShopUser.setCoins(ShopUser.getCoins() - 2500);
            ShopUser.setRoulette(true);
            App.setRoot("ShopView");
        }
    }

    @FXML
    private void btnKaufenW(ActionEvent event) throws IOException {
        if((ShopUser.getCoins() -1000) < 100){
            FehlerMWuerfel.setText("Bitte erspiele dir Mehr Geld, sonst hast du zu wenig!");
        }
        else{
            ShopUser.setCoins(ShopUser.getCoins() - 1000);
            ShopUser.setWuerfeln(true);
            App.setRoot("ShopView");
        }
    }
    
    
}
