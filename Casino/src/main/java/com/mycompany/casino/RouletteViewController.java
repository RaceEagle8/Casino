package com.mycompany.casino;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;


/**
 * FXML Controller class
 *
 * @author janik
 */

public class RouletteViewController implements Initializable {

    @FXML
    private TextField tfEinsatz;
    @FXML
    private Label CoinsUser;
    
    public User RouletteUser;
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        for(User user : App.getAllUsers()){
            
            CoinsUser.setText("Coins: " + String.valueOf(user.getCoins()));
            
            RouletteUser = user;
            
        }
        
    }    
    
    
    
    
    @FXML
    private void btnGoBackToHome(ActionEvent event) throws IOException {
        App.setRoot("RHomeScreenView");
    }

    @FXML
    private void btnStartRoulette(ActionEvent event) {
        random1();
        random2();
        test();
    }
    
   
    
    @FXML
    public TextField tfRandomNumber;
    
    public void random1(){
       Random randomNumber1 = new Random();
       int rouletteNumber;
       rouletteNumber = 0 + randomNumber1.nextInt(37);
       System.out.println(rouletteNumber);
       tfRandomNumber.setText(String.valueOf(rouletteNumber)); // int Wert wird als String in das Textfeld geschrieben
    }


    @FXML
    public ImageView imgRedCircle;
    public ImageView imgBlackCircle;
   
    
    public void random2(){
        Random randomNumber2 = new Random();
        int blackOrRed;
        blackOrRed = 0 + randomNumber2.nextInt(2);
        //System.out.println(blackOrRed);

        if(blackOrRed == 1){
            System.out.println("ROT"); 
            imgRedCircle.setVisible(true);
            imgBlackCircle.setVisible(false);
        }
        else{
            System.out.println("SCHWARZ");
            imgBlackCircle.setVisible(true);
            imgRedCircle.setVisible(false);
        }
    }
        
    public void test(){
        if(imgRedCircle.isVisible() == true){
            System.out.println("test erfolgreich");
            
        }
    }
        
        
        
    

    @FXML
    private void keyEinsatz(KeyEvent event) {
        int Max = IntCheckEinsatz();
        
        if(Max == 0){
            tfEinsatz.setText("");
        }
        
        if(Max >= 10000){
            tfEinsatz.setText("10000");
        }
        
        
        if((RouletteUser.getCoins() - Max) < 0){
                    tfEinsatz.setText(String.valueOf(RouletteUser.getCoins()));
                }
        
        
    }
    

    
    public int IntCheckEinsatz(){
        
        try{
            String sEinsatz = tfEinsatz.getText();
                
            int iEinsatz = Integer.parseInt(sEinsatz);
            
            int Einsatz = iEinsatz;
            
            return Einsatz;
        }
        catch(NumberFormatException error)
        {
            int Kapazitaet = 0;
            return Kapazitaet;
        }
    }
  
}