/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.casino;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author guido
 */
public class MainGameController implements Initializable {
    
    
    
    @FXML
    public Text Coins;
    
    @FXML
    public Text LoggedInUser;
    @FXML
    private TextField inputEinsatz;
    @FXML
    private Text LevelAn;
    @FXML
    public ImageView XDslot2;
    @FXML
    public ImageView XDslot3;
    @FXML
    public ImageView XDslot1;
    @FXML
    public ImageView TraubeSlot1;
    @FXML
    public ImageView TraubeSlot2;
    @FXML
    public ImageView TraubeSlot3;
    @FXML
    public ImageView KleeSlot1;
    @FXML
    public ImageView KLeeSlot2;
    @FXML
    public ImageView KleeSlot3;
    @FXML
    public ImageView KirscheSlot1;
    @FXML
    public ImageView KirschSlot2;
    @FXML
    public ImageView KirschSlot3;
    @FXML
    public ImageView HufSlot1;
    @FXML
    public ImageView HufSlot2;
    @FXML
    public ImageView HufSlot3;
    @FXML
    public ImageView GlockeSlot1;
    @FXML
    public ImageView GlockeSlot2;
    @FXML
    public ImageView GlockeSlot3;
    @FXML
    public ImageView HerzSlot1;
    @FXML
    public ImageView HerzSlot2;
    @FXML
    public ImageView HerzSlot3;
    @FXML
    public ImageView sevenSlot1;
    @FXML
    public ImageView sevenSlot2;
    @FXML
    public ImageView sevenSlot3;
    @FXML
    public ImageView DiaSlot2;
    @FXML
    public ImageView DiaSlot3;
    @FXML
    public ImageView DiaSlot1;
    @FXML
    public Text Erreicht;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
            
        for(User user : App.getAllUsers()){
            if(user.getLoggedIn() == true){
                LoggedInUser.setText(user.getUserName());
                
                Coins.setText(String.valueOf(user.getCoins()));
                
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
                LevelAn.setText("Level: " + String.valueOf(I));
            }
        }
        
        

    }    

    @FXML
    private void btnShop(ActionEvent event) throws IOException {
        App.setRoot("ShopView");
        
        
        
    }

    @FXML
    private void btnLoggOut(ActionEvent event) throws IOException {
        for(User user : App.getAllUsers()){
            if(LoggedInUser.getText().equals(user.getUserName())){
                user.setLoggedIn(false);
            }
        }
        App.setRoot("MainScreen");
        
    }
    
    
    @FXML
    private void btnSpielen(ActionEvent event) throws IOException {
        
        int Einsatz = IntCheckEinsatz();
        
        if(Einsatz <= 0){
            //Fehler
            return;
        }
        
        if(Erreicht.getText().equals("") == false){
            
            try{
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
            Erreicht.setText("");
        }
        
        
        
        
        Spiel(Einsatz);

        
        
    }
    
    
    public void Spiel(int Einsatz) throws IOException{
        
        
        DiaSlot1.setVisible(false);
        DiaSlot2.setVisible(false);
        DiaSlot3.setVisible(false);
        GlockeSlot1.setVisible(false);
        GlockeSlot2.setVisible(false);
        GlockeSlot3.setVisible(false);
        HerzSlot1.setVisible(false);
        HerzSlot2.setVisible(false);
        HerzSlot3.setVisible(false);
        HufSlot1.setVisible(false);
        HufSlot2.setVisible(false);
        HufSlot3.setVisible(false);
        KleeSlot1.setVisible(false);
        KLeeSlot2.setVisible(false);
        KleeSlot3.setVisible(false);
        KirscheSlot1.setVisible(false);
        KirschSlot2.setVisible(false);
        KirschSlot3.setVisible(false);
        TraubeSlot1.setVisible(false);
        TraubeSlot2.setVisible(false);
        TraubeSlot3.setVisible(false);
        XDslot1.setVisible(false);
        XDslot2.setVisible(false);
        XDslot3.setVisible(false);
        sevenSlot1.setVisible(false);
        sevenSlot2.setVisible(false);
        sevenSlot3.setVisible(false);
        
        
        
        
        //Slot1 Final
        Random Slot1 = new Random();
        int slotone;
        
        
        slotone = 1 + Slot1.nextInt(9);
        System.out.println(slotone);
        
        //Slot2 Final
        
        Random Slot2 = new Random();
        int slottwo;
        
        
        slottwo = 1 + Slot2.nextInt(9);
        System.out.println(slottwo);
        
        //Slot3 Final
        
        Random Slot3 = new Random();
        int slotthree;
        
        
        slotthree = 1 + Slot3.nextInt(9);
        System.out.println(slotthree);
        
        //Slot Anzeige
        
        if(slotone == 1){
            KleeSlot1.setVisible(true);
            
        }
        else if(slotone == 2){
            GlockeSlot1.setVisible(true);
            
        } 
        else if(slotone == 3){
            HufSlot1.setVisible(true);
            
        }
        else if(slotone == 4){
            HerzSlot1.setVisible(true);
            
        }
        else if(slotone == 5){
            KirscheSlot1.setVisible(true);
       
        }
        else if(slotone == 6){
            TraubeSlot1.setVisible(true);
           
        }
        else if(slotone == 7){
            sevenSlot1.setVisible(true);
            
        }
        else if(slotone == 8){
            XDslot1.setVisible(true);
            
        }
        else if(slotone == 9){
            DiaSlot1.setVisible(true);
            
        }
        
        
        if(slottwo == 1){
            KLeeSlot2.setVisible(true);
            
        }
        else if(slottwo == 2){
            GlockeSlot2.setVisible(true);
            
        } 
        else if(slottwo == 3){
            HufSlot2.setVisible(true);
           
        }
        else if(slottwo == 4){
            HerzSlot2.setVisible(true);
           
        }
        else if(slottwo == 5){ 
            KirschSlot2.setVisible(true);
            
        }
        else if(slottwo == 6){
            TraubeSlot2.setVisible(true);
            
        }
        else if(slottwo == 7){
            sevenSlot2.setVisible(true);
            
        }
        else if(slottwo == 8){
            XDslot2.setVisible(true);
            
        }
        else if(slottwo == 9){
            DiaSlot2.setVisible(true);
            
        }
        
        
        if(slotthree == 1){
            KleeSlot3.setVisible(true);

        }
        else if(slotthree == 2){
            GlockeSlot3.setVisible(true);

        } 
        else if(slotthree == 3){
            HufSlot3.setVisible(true);

        }
        else if(slotthree == 4){
            HerzSlot3.setVisible(true);

        }
        else if(slotthree == 5){
            KirschSlot3.setVisible(true);

        }
        else if(slotthree == 6){
            TraubeSlot3.setVisible(true);

        }
        else if(slotthree == 7){
            sevenSlot3.setVisible(true);

        }
        else if(slotthree == 8){
            XDslot3.setVisible(true);

        }
        else if(slotthree == 9){
            DiaSlot3.setVisible(true);

        }
        
        
        
        if(slotone == slottwo && slottwo == slotthree && slotone == slotthree){
            
            if(slotone == 1){
                
               int neueCoins = Einsatz * 2;
               
               for(User user : App.getAllUsers()){
                   
                   if(LoggedInUser.getText().equals(user.getUserName())){
                       int CoinsG = user.getCoins();
                       user.setCoins(neueCoins + CoinsG);
                       int NeuesLevel = user.getLevel() + 1;
                       user.setLevel(NeuesLevel);
                       Reload();
                       Erreicht.setText(" +" + String.valueOf(neueCoins) + "COINS  + 5 FREESPINS");
                       FreeSpins(user, Einsatz);
                       System.out.println("Mal 2");
                       return;
                   }
               }
            }
            else if(slotone == 2){
                
                int neueCoins = Einsatz * 2;
               
                for(User user : App.getAllUsers()){
                   
                    if(LoggedInUser.getText().equals(user.getUserName())){
                        int CoinsG = user.getCoins();
                        user.setCoins(neueCoins + CoinsG);
                        int NeuesLevel = user.getLevel() + 1;
                        user.setLevel(NeuesLevel);
                        Reload();
                        Erreicht.setText(" +" + String.valueOf(neueCoins) + "COINS  + 5 FREESPINS");
                        FreeSpins(user, Einsatz);
                        System.out.println("Mal 2");
                        return;
                    }
                }
            }
            else if(slotone == 3){
                
                int neueCoins = Einsatz * 3;
               
                for(User user : App.getAllUsers()){
                   
                    if(LoggedInUser.getText().equals(user.getUserName())){
                        int CoinsG = user.getCoins();
                        user.setCoins(neueCoins + CoinsG);
                        int NeuesLevel = user.getLevel() + 1;
                        user.setLevel(NeuesLevel);
                        Reload();
                        Erreicht.setText(" +" + String.valueOf(neueCoins) + "COINS  + 5 FREESPINS");
                        FreeSpins(user, Einsatz);
                        System.out.println("Mal 3");
                        return;
                    }
                }
                
            }
            else if(slotone == 4){
                
                int neueCoins = Einsatz * 3;
               
                for(User user : App.getAllUsers()){
                   
                    if(LoggedInUser.getText().equals(user.getUserName())){
                        int CoinsG = user.getCoins();
                        user.setCoins(neueCoins + CoinsG);
                        int NeuesLevel = user.getLevel() + 1;
                        user.setLevel(NeuesLevel);
                        Reload();
                        Erreicht.setText(" +" + String.valueOf(neueCoins) + "COINS  + 5 FREESPINS");
                        FreeSpins(user, Einsatz);
                        System.out.println("Mal 3");
                        return;
                    }
                }
            }
            else if(slotone == 5){
                
                int neueCoins = Einsatz * 4;
               
                for(User user : App.getAllUsers()){
                   
                    if(LoggedInUser.getText().equals(user.getUserName())){
                        int CoinsG = user.getCoins();
                        user.setCoins(neueCoins + CoinsG);
                        int NeuesLevel = user.getLevel() + 1;
                        user.setLevel(NeuesLevel);
                        Reload();
                        Erreicht.setText(" +" + String.valueOf(neueCoins) + "COINS  + 5 FREESPINS");
                        FreeSpins(user, Einsatz);
                        System.out.println("Mal 4");
                        return;
                    }
                }
            }
            else if(slotone == 6){
                
                int neueCoins = Einsatz * 5;
               
                for(User user : App.getAllUsers()){
                   
                    if(LoggedInUser.getText().equals(user.getUserName())){
                        int CoinsG = user.getCoins();
                        user.setCoins(neueCoins + CoinsG);
                        int NeuesLevel = user.getLevel() + 1;
                        user.setLevel(NeuesLevel);
                        Reload();
                        Erreicht.setText(" +" + String.valueOf(neueCoins) + "COINS  + 5 FREESPINS");
                        FreeSpins(user, Einsatz);
                        System.out.println("Mal 5");
                        return;
                    }
                }
                
            }
            else if(slotone == 7){
                
                int neueCoins = Einsatz * 6;
               
                for(User user : App.getAllUsers()){
                   
                    if(LoggedInUser.getText().equals(user.getUserName())){
                        int CoinsG = user.getCoins();
                        user.setCoins(neueCoins + CoinsG);
                        int NeuesLevel = user.getLevel() + 1;
                        user.setLevel(NeuesLevel);
                        Reload();
                        Erreicht.setText(" +" + String.valueOf(neueCoins) + "COINS  + 5 FREESPINS");
                        FreeSpins(user, Einsatz);
                        System.out.println("Mal 6");
                        return;
                    }
                }
            }
            else if(slotone == 8){
                
                int neueCoins = Einsatz * 8;
               
                for(User user : App.getAllUsers()){
                   
                    if(LoggedInUser.getText().equals(user.getUserName())){
                        int CoinsG = user.getCoins();
                        user.setCoins(neueCoins + CoinsG);
                        int NeuesLevel = user.getLevel() + 1;
                        user.setLevel(NeuesLevel);
                        Reload();
                        Erreicht.setText(" +" + String.valueOf(neueCoins) + "COINS  + 5 FREESPINS");
                        FreeSpins(user, Einsatz);
                        System.out.println("Mal 8");
                        return;
                    }
                }
            }
            else if(slotone == 9){
                
                int neueCoins = Einsatz * 10;
               
                for(User user : App.getAllUsers()){
                   
                    if(LoggedInUser.getText().equals(user.getUserName())){
                        int CoinsG = user.getCoins();
                        user.setCoins(neueCoins + CoinsG);
                        int NeuesLevel = user.getLevel() + 1;
                        user.setLevel(NeuesLevel);
                        Reload();
                        Erreicht.setText(" +" + String.valueOf(neueCoins) + "COINS  + 5 FREESPINS");
                        FreeSpins(user, Einsatz);
                        System.out.println("Mal 10");
                        return;
                    }
                }
            }
        }
        //Minus
        
        for(User user : App.getAllUsers()){
            if(LoggedInUser.getText().equals(user.getUserName())){
                
                int NeueCoins = user.getCoins() - Einsatz;
                
                user.setCoins(NeueCoins);
                int NeuesLevel = user.getLevel() + 1;
                user.setLevel(NeuesLevel);
                
                Reload();
                if(user.getCoins() <= 0){
                    Erreicht.setText(" + 1000 COINS FREE");
                    user.setCoins(user.getCoins() + 1000);
                    
                }
                System.out.println("Minus");
                return;
                
            }
            
        }
        
    }
    
    
    public void FreeSpins(User user, int Einsatz) throws IOException{
        System.out.println("Freespins");
        user.setCoins(user.getCoins() + (Einsatz * 5));
        
        
        
    }
    
    
    
    //TESTS
    
    

    
    
    
   
    
    
    public void Reload(){
        
        for(User user : App.getAllUsers()){
            if(user.getLoggedIn() == true){
                LoggedInUser.setText(user.getUserName());
                
                Coins.setText(String.valueOf(user.getCoins()));
                
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
                LevelAn.setText("Level: " + String.valueOf(I));
            }
        }
    }
    
    public int IntCheckEinsatz(){
        
        try{
            String sEinsatz = inputEinsatz.getText();
                
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

    @FXML
    private void maxCheck(KeyEvent event) {
        int Max = IntCheckEinsatz();
        
        if(Max == 0){
            inputEinsatz.setText("");
        }
        
        if(Max >= 10000){
            inputEinsatz.setText("10000");
        }
        
        for(User user : App.getAllUsers()){
            if(LoggedInUser.getText().equals(user.getUserName())){
                
                if((user.getCoins() - Max) < 0){
                    inputEinsatz.setText(String.valueOf(user.getCoins()));
                }
                
            }
            
            
        }
    }

    

    
}
