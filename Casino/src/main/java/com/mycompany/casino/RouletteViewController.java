package com.mycompany.casino;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

    public User RouletteUser;
    
    @FXML
    private TextField tfEinsatz;
    
    @FXML
    private Label CoinsUser;
    
    @FXML
    private ImageView RouletteRad;
    
    @FXML
    public Text tfRandomNumber;
    
    @FXML
    public ImageView imgRedCircle;
    
    @FXML
    public ImageView imgBlackCircle;
    
    @FXML
    private Button startRoulette;
    
    @FXML
    private Button einsatzButton;
  
    @FXML
    private Button wettenButton;
    
    @FXML
    private TextField tfWetten;
    
    @FXML
    private Text tfBigWin1;
    
    @FXML
    private Text tfBigWin2;
    @FXML
    private Text LevelAn;
    @FXML
    private ImageView imgGreenCircle;
    @FXML
    private Text Ersatz;
    @FXML
    private Button leave;
    
    
  
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        leave.setVisible(true);
        imgGreenCircle.setVisible(false);
        Ersatz.setText("");
        
        
        for(User user : App.getAllUsers()){
            
            if(user.getLoggedIn() == true){
                CoinsUser.setText("Coins: " + String.valueOf(user.getCoins()));
            
                 RouletteUser = user;
            }
            
        }
        
    }    
    
    
    
    
    @FXML
    private void btnGoBackToHome(ActionEvent event) throws IOException {
        App.setRoot("ShopView");
    }

    @FXML
    private void btnStartRoulette(ActionEvent event) {
        leave.setVisible(true);
        random1();
        test();
        imgGreenCircle.setVisible(false);
        
        
        RouletteUser.setLevel(RouletteUser.getLevel() + 1);
        
        int I = 0;
        if(RouletteUser.getLevel() >= 10 && RouletteUser.getLevel() < 20){
            I = 1;
        }
        else if(RouletteUser.getLevel() >= 20 && RouletteUser.getLevel() < 30){
            I = 2;
        }
        else if(RouletteUser.getLevel() >= 30){
            I = 3;
        }
        LevelAn.setText("Level: " + String.valueOf(I));
        
        
        startRoulette.setVisible(false);
        einsatzButton.setVisible(true);
        tfEinsatz.setEditable(true);
        tfWetten.setEditable(true);
    }
   
    

    
    
    public void random1(){
       Random randomNumber1 = new Random();
       int rouletteNumber;
       rouletteNumber = 0 + randomNumber1.nextInt(36);
       System.out.println(rouletteNumber);
       tfRandomNumber.setText(String.valueOf(rouletteNumber)); // int Wert wird als String in das Textfeld 
       
       
    
       if(rouletteNumber == 0){
           RouletteRad.setRotate(180);
           imgRedCircle.setVisible(false);
           imgBlackCircle.setVisible(false);
           imgGreenCircle.setVisible(true);
       }
       else if(rouletteNumber == 1){
           RouletteRad.setRotate(10);
           imgRedCircle.setVisible(true);
           imgBlackCircle.setVisible(false);
       }
       else if(rouletteNumber == 2){
           RouletteRad.setRotate(-170);
           imgBlackCircle.setVisible(true);
           imgRedCircle.setVisible(false);
       }
       else if(rouletteNumber == 3){
           RouletteRad.setRotate(48);
           imgRedCircle.setVisible(true);
           imgBlackCircle.setVisible(false);
       }
       else if(rouletteNumber == 4){
           RouletteRad.setRotate(-132);
           imgBlackCircle.setVisible(true);
           imgRedCircle.setVisible(false);
       }
       else if(rouletteNumber == 5){
           RouletteRad.setRotate(85);
           imgRedCircle.setVisible(true);
           imgBlackCircle.setVisible(false);
       }
       else if(rouletteNumber == 6){
           RouletteRad.setRotate(-94);
           imgBlackCircle.setVisible(true);
           imgRedCircle.setVisible(false);
       }
       else if(rouletteNumber == 7){
           RouletteRad.setRotate(124);
           imgRedCircle.setVisible(true);
           imgBlackCircle.setVisible(false);
       }
       else if(rouletteNumber == 8){
           RouletteRad.setRotate(-57);
           imgBlackCircle.setVisible(true);
           imgRedCircle.setVisible(false);
       }
       else if(rouletteNumber == 9){
           RouletteRad.setRotate(162);
           imgRedCircle.setVisible(true);
           imgBlackCircle.setVisible(false);
       }
       else if(rouletteNumber == 10){
           RouletteRad.setRotate(-18);
           imgBlackCircle.setVisible(true);
           imgRedCircle.setVisible(false);
       }
       else if(rouletteNumber == 11){
           RouletteRad.setRotate(133);
           imgBlackCircle.setVisible(true);
           imgRedCircle.setVisible(false);
       }
       else if(rouletteNumber == 12){
           RouletteRad.setRotate(-46);
           imgRedCircle.setVisible(true);
           imgBlackCircle.setVisible(false);
       }
       else if(rouletteNumber == 13){
           RouletteRad.setRotate(20);
           imgBlackCircle.setVisible(true);
           imgRedCircle.setVisible(false);
           
       }
       else if(rouletteNumber == 14){
           RouletteRad.setRotate(-161);
           imgRedCircle.setVisible(true);
           imgBlackCircle.setVisible(false);
       }
       else if(rouletteNumber == 15){
           RouletteRad.setRotate(57);
           imgBlackCircle.setVisible(true);
       }
       else if(rouletteNumber == 16){
           RouletteRad.setRotate(-123);
           imgRedCircle.setVisible(true);
           imgBlackCircle.setVisible(false);
       }
       else if(rouletteNumber == 17){
           RouletteRad.setRotate(95);
           imgBlackCircle.setVisible(true);
           imgRedCircle.setVisible(false);
       }
       else if(rouletteNumber == 18){
           RouletteRad.setRotate(-85);
           imgRedCircle.setVisible(true);
           imgBlackCircle.setVisible(false);
       }
       else if(rouletteNumber == 19){
           RouletteRad.setRotate(-66);
           imgRedCircle.setVisible(true);
           imgBlackCircle.setVisible(false);
       }
       else if(rouletteNumber == 20){
           RouletteRad.setRotate(114);
           imgBlackCircle.setVisible(true);
           imgRedCircle.setVisible(false);
       }
       else if(rouletteNumber == 21){
           RouletteRad.setRotate(-104);
           imgRedCircle.setVisible(true);
           imgBlackCircle.setVisible(false);
       }
       else if(rouletteNumber == 22){
           RouletteRad.setRotate(76);
           imgBlackCircle.setVisible(true);
           imgRedCircle.setVisible(false);
       }
       else if(rouletteNumber == 23){
           RouletteRad.setRotate(-142);
           imgRedCircle.setVisible(true);
           imgBlackCircle.setVisible(false);
       }
       else if(rouletteNumber == 24){
           RouletteRad.setRotate(38); 
           imgBlackCircle.setVisible(true);
           imgRedCircle.setVisible(false);
       }
       else if(rouletteNumber == 25){
           RouletteRad.setRotate(-28);
           imgRedCircle.setVisible(true);
           imgBlackCircle.setVisible(false);
       }
       else if(rouletteNumber == 26){
           RouletteRad.setRotate(152);
           imgBlackCircle.setVisible(true);
           imgRedCircle.setVisible(false);
       }
       else if(rouletteNumber == 27){
           RouletteRad.setRotate(-10);
           imgRedCircle.setVisible(true);
           imgBlackCircle.setVisible(false);
       }
       else if(rouletteNumber == 28){
           RouletteRad.setRotate(171);
           imgBlackCircle.setVisible(true);
           imgRedCircle.setVisible(false);
       }
       else if(rouletteNumber == 29){
           RouletteRad.setRotate(-38);
           imgBlackCircle.setVisible(true);
           imgRedCircle.setVisible(false);
       }
       else if(rouletteNumber == 30){
           RouletteRad.setRotate(143);
           imgRedCircle.setVisible(true);
           imgBlackCircle.setVisible(false);
       }
       else if(rouletteNumber == 31){
           RouletteRad.setRotate(-75);
           imgBlackCircle.setVisible(true);
           imgRedCircle.setVisible(false);
       }
       else if(rouletteNumber == 32){
           RouletteRad.setRotate(104);
           imgRedCircle.setVisible(true);
           imgBlackCircle.setVisible(false);
       }
       else if(rouletteNumber == 33){
           RouletteRad.setRotate(-113);
           imgBlackCircle.setVisible(true);
           imgRedCircle.setVisible(false);
       }
       else if(rouletteNumber == 34){
           RouletteRad.setRotate(67);
           imgRedCircle.setVisible(true);
           imgBlackCircle.setVisible(false);
       }
       else if(rouletteNumber == 35){
           RouletteRad.setRotate(-151);
           imgBlackCircle.setVisible(true);
           imgRedCircle.setVisible(false);
       }
       else if(rouletteNumber == 36){
           RouletteRad.setRotate(30);
           imgRedCircle.setVisible(true);
           imgBlackCircle.setVisible(false);
       }
       
        int einsatzCheckt = intCheckerEinsatz();
        if(einsatzCheckt == -1){
            return;
        }
       
        int wetteCheckt = intCheckerWetten();
        if(wetteCheckt == -1){
            return;
        }
       
        int einsatz = einsatzCheckt;
        int zahlWette = wetteCheckt;
        if((rouletteNumber - zahlWette) == 0){
            
            if(rouletteNumber == 0 && zahlWette == 0){
                RouletteUser.setCoins(RouletteUser.getCoins() + (einsatz * 10));
            }
            else{
                
                RouletteUser.setCoins(RouletteUser.getCoins() + (einsatz * 3)); 
                
            }
           
           System.out.println("Gewinn!");
           tfBigWin1.setVisible(true);
           tfBigWin2.setVisible(true);
           refreshCoins();
       }   
        else{
            tfBigWin1.setVisible(false);
            tfBigWin2.setVisible(false);
        }

    }
    
    
    
    public int intCheckerEinsatz(){
        try{
          String sEinsatz = tfEinsatz.getText();

          int iEinsatz = Integer.parseInt(sEinsatz);

          int einsatz = iEinsatz;

          return einsatz;
      }
      catch(NumberFormatException error)
      {
          int Kapazitaet = -1;
          return Kapazitaet;
      }
    }
    
    
    public int intCheckerWetten(){
        try{
          String sWetten = tfWetten.getText();

          int iWetten = Integer.parseInt(sWetten);

          int Wetten = iWetten;

          return Wetten;
      }
      catch(NumberFormatException error)
      {
          int Kapazitaet = -1;
          return Kapazitaet;
      }
    }


    
   
    
        
    public void test(){
        if(imgRedCircle.isVisible() == true){
            System.out.println("test erfolgreich");
            
        }
    }
    
    
    
    
    @FXML
    private void keyWetten(KeyEvent event) {
        tfBigWin1.setVisible(false);
        tfBigWin2.setVisible(false);
        
        int Max = IntCheckWetten();
        
        if(Max > 36){
            return;
        }
        
        if(Max == -1){
            tfWetten.setText("");
            return;
        }
        
    }
    
    
    
    public int IntCheckWetten(){

       try{
           String sWetten = tfWetten.getText();

           int iWetten = Integer.parseInt(sWetten);

           int Wetten = iWetten;

           if(Wetten > 36){
               tfWetten.clear();
           }
           
           
           return Wetten;
       }
       catch(NumberFormatException error)
       {
           int Kapazitaet = -1;
           return Kapazitaet;
       }
    }

   

    

    @FXML
    private void keyEinsatz(KeyEvent event) {
        tfBigWin1.setVisible(false);
        tfBigWin2.setVisible(false);
            
        int Max = IntCheckEinsatz();
        
        if(Max <= 0){
            tfEinsatz.setText("");
            einsatzButton.setVisible(false);
        }
        else{
            einsatzButton.setVisible(true);
        }
        
        if(Max >= 10000){
            tfEinsatz.setText("10000");
        }
        
        
        if((RouletteUser.getCoins() - Max) < 0){
            tfEinsatz.setText(String.valueOf(RouletteUser.getCoins()));
            
            
            if(tfEinsatz.getText().equals("0")){
                tfEinsatz.clear();
            }
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
    
    
    
     //Refresh die Coin Anzeige  
    public void refreshCoins(){
        CoinsUser.setText("Coins: " + String.valueOf(RouletteUser.getCoins()));
        einsatzButton.setVisible(true);
        Ersatz.setText("");
    }
    
    

    @FXML
    private void btnEinsatz(ActionEvent event) {
        imgBlackCircle.setVisible(false);
        imgRedCircle.setVisible(false);
        imgGreenCircle.setVisible(false);
        tfRandomNumber.setText("");
        
        
        
        wettenButton.setVisible(true);
        tfBigWin1.setVisible(false);
        tfBigWin2.setVisible(false);
        
        if(tfEinsatz.getText().equals("0")||tfEinsatz.getText().equals("")){
            return;
        }
    
        int Max = IntCheckEinsatz();
        
        if((RouletteUser.getCoins() - Max) < 0){
            tfEinsatz.setText(String.valueOf(RouletteUser.getCoins()));

            if(tfEinsatz.getText().equals("0")){
                tfEinsatz.setText("");
            }
            
            return;
        }

        
        CoinsAbzug();
        einsatzButton.setVisible(false);
        
        leave.setVisible(false);
        
        tfEinsatz.setEditable(false);
  
    }
    
    @FXML
    private void btnWette(ActionEvent event) {

        

        
        int Max = IntCheckWetten();
        
        if(Max > 36 || Max < 0){
            tfWetten.setText("");
            return;
        }
        
        
        if(tfWetten.getText().equals("")){
            return;
        }
        
        tfWetten.setEditable(false);
        startRoulette.setVisible(true);
        wettenButton.setVisible(false);
    }

    
    
    
    public void CoinsAbzug(){
        String sEinsatz = tfEinsatz.getText();
        int iEinsatz = Integer.parseInt(sEinsatz);
        
        int UserCoins = RouletteUser.getCoins();
        
        int coins = UserCoins - iEinsatz;
        System.out.println(coins);
        
        int coins2 = coins;
        
        if(coins < 50){
            coins = coins2 + 1000;
            
            Ersatz.setText(" + 1000 COINS FREE!");
        }
        
        RouletteUser.setCoins(coins); 
        System.out.println(RouletteUser.getCoins());
        
        refreshCoins();
        
        if(UserCoins == 0){
            einsatzButton.setVisible(false);
            wettenButton.setVisible(false);
            startRoulette.setVisible(false);
        }  
        
    }
    
} 