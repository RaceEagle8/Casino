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
    
   
    //Fix
    
    
    @FXML
    public Text tfRandomNumber;
    
    public void random1(){
       Random randomNumber1 = new Random();
       int rouletteNumber;
       rouletteNumber = 0 + randomNumber1.nextInt(37);
       System.out.println(rouletteNumber);
       tfRandomNumber.setText(String.valueOf(rouletteNumber)); // int Wert wird als String in das Textfeld geschrieben
       
       if(rouletteNumber == 00){
           RouletteRad.setRotate(180);
       }
       else if(rouletteNumber == 0){
           RouletteRad.setRotate(180);
       }
       else if(rouletteNumber == 1){
           RouletteRad.setRotate(10);
       }
       else if(rouletteNumber == 2){
           RouletteRad.setRotate(-170);
       }
       else if(rouletteNumber == 3){
           RouletteRad.setRotate(48);
       }
       else if(rouletteNumber == 4){
           RouletteRad.setRotate(-132);
       }
       else if(rouletteNumber == 5){
           RouletteRad.setRotate(85);
       }
       else if(rouletteNumber == 6){
           RouletteRad.setRotate(-94);
       }
       else if(rouletteNumber == 7){
           RouletteRad.setRotate(124);
       }
       else if(rouletteNumber == 8){
           RouletteRad.setRotate(-57);
       }
       else if(rouletteNumber == 9){
           RouletteRad.setRotate(162);
       }
       else if(rouletteNumber == 10){
           RouletteRad.setRotate(-18);
       }
       else if(rouletteNumber == 11){
           RouletteRad.setRotate(133);
       }
       else if(rouletteNumber == 12){
           RouletteRad.setRotate(-46);
       }
       else if(rouletteNumber == 13){
           RouletteRad.setRotate(20);
       }
       else if(rouletteNumber == 14){
           RouletteRad.setRotate(-161);
       }
       else if(rouletteNumber == 15){
           RouletteRad.setRotate(57);
       }
       else if(rouletteNumber == 16){
           RouletteRad.setRotate(-123);
       }
       else if(rouletteNumber == 17){
           RouletteRad.setRotate(95);
       }
       else if(rouletteNumber == 18){
           RouletteRad.setRotate(-85);
       }
       else if(rouletteNumber == 19){
           RouletteRad.setRotate(-66);
       }
       else if(rouletteNumber == 20){
           RouletteRad.setRotate(114);
       }
       else if(rouletteNumber == 21){
           RouletteRad.setRotate(-104);
       }
       else if(rouletteNumber == 22){
           RouletteRad.setRotate(76);
       }
       else if(rouletteNumber == 23){
           RouletteRad.setRotate(-142);
       }
       else if(rouletteNumber == 24){
           RouletteRad.setRotate(38); 
       }
       else if(rouletteNumber == 25){
           RouletteRad.setRotate(-28);
       }
       else if(rouletteNumber == 26){
           RouletteRad.setRotate(152);
       }
       else if(rouletteNumber == 27){
           RouletteRad.setRotate(-10);
       }
       else if(rouletteNumber == 28){
           RouletteRad.setRotate(171);
       }
       else if(rouletteNumber == 29){
           RouletteRad.setRotate(-38);
       }
       else if(rouletteNumber == 30){
           RouletteRad.setRotate(143);
       }
       else if(rouletteNumber == 31){
           RouletteRad.setRotate(-75);
       }
       else if(rouletteNumber == 32){
           RouletteRad.setRotate(104);
       }
       else if(rouletteNumber == 33){
           RouletteRad.setRotate(-113);
       }
       else if(rouletteNumber == 34){
           RouletteRad.setRotate(67);
       }
       else if(rouletteNumber == 35){
           RouletteRad.setRotate(-151);
       }
       else if(rouletteNumber == 36){
           RouletteRad.setRotate(30);
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