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
import javafx.scene.text.Text;


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
    
    @FXML
    private ImageView RouletteRad;
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        for(User user : App.getAllUsers()){
            
            if(user.getLoggedIn() == true){
                CoinsUser.setText("Coins: " + String.valueOf(user.getCoins()));
            
                 RouletteUser = user;
            }
            
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
    public Text tfRandomNumber;
    
    public void random1(){
       Random randomNumber1 = new Random();
       int rouletteNumber;
       rouletteNumber = 0 + randomNumber1.nextInt(37);
       System.out.println(rouletteNumber);
       tfRandomNumber.setText(String.valueOf(rouletteNumber)); // int Wert wird als String in das Textfeld geschrieben
       
       if(rouletteNumber == 00){
           
       }
       else if(rouletteNumber == 0){
           
       }
       else if(rouletteNumber == 1){
           RouletteRad.setRotate(10);
       }
       else if(rouletteNumber == 2){
           RouletteRad.setRotate(-120);
       }
       else if(rouletteNumber == 3){
           RouletteRad.setRotate(35);
       }
       else if(rouletteNumber == 4){
           RouletteRad.setRotate(-75);
       }
       else if(rouletteNumber == 5){
           RouletteRad.setRotate(85);
       }
       else if(rouletteNumber == 6){
           RouletteRad.setRotate(-50);
       }
       else if(rouletteNumber == 7){
           RouletteRad.setRotate(75);
       }
       else if(rouletteNumber == 8){
           RouletteRad.setRotate(-35);
       }
       else if(rouletteNumber == 9){
           
       }
       else if(rouletteNumber == 10){
           
       }
       else if(rouletteNumber == 11){
           
       }
       else if(rouletteNumber == 12){
           
       }
       else if(rouletteNumber == 13){
           
       }
       else if(rouletteNumber == 14){
           
       }
       else if(rouletteNumber == 15){
           
       }
       else if(rouletteNumber == 16){
           
       }
       else if(rouletteNumber == 17){
           
       }
       else if(rouletteNumber == 18){
           
       }
       else if(rouletteNumber == 19){
           
       }
       else if(rouletteNumber == 20){
           
       }
       else if(rouletteNumber == 21){
           
       }
       else if(rouletteNumber == 22){
           
       }
       else if(rouletteNumber == 23){
           
       }
       else if(rouletteNumber == 24){
           
       }
       else if(rouletteNumber == 25){
           
       }
       else if(rouletteNumber == 26){
           
       }
       else if(rouletteNumber == 27){
           
       }
       else if(rouletteNumber == 28){
           
       }
       else if(rouletteNumber == 29){
           
       }
       else if(rouletteNumber == 30){
           
       }
       else if(rouletteNumber == 31){
           
       }
       else if(rouletteNumber == 32){
           
       }
       else if(rouletteNumber == 33){
           
       }
       else if(rouletteNumber == 34){
           
       }
       else if(rouletteNumber == 35){
           
       }
       
       
       
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
        
        
    public void refreshCoins(){
        
        CoinsUser.setText("Coins: " + String.valueOf(RouletteUser.getCoins()));
        
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