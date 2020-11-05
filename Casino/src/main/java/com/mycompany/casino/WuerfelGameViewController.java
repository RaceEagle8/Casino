/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.casino;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author guido
 */
public class WuerfelGameViewController implements Initializable {

    @FXML
    private ImageView sechsR;
    @FXML
    private ImageView sechsL;
    @FXML
    private ImageView fuenfL;
    @FXML
    private ImageView fuenfR;
    @FXML
    private ImageView vierL;
    @FXML
    private ImageView vierR;
    @FXML
    private ImageView dreiL;
    @FXML
    private ImageView dreiR;
    @FXML
    private ImageView zweiL;
    @FXML
    private ImageView zweiR;
    @FXML
    private ImageView einsL;
    @FXML
    private ImageView einsR;
    @FXML
    private Text CoinsWG;
    @FXML
    private TextField inputEinsatzW;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for(User user : App.getAllUsers()){
            
            if(user.getLoggedIn() == true){
                CoinsWG.setText(String.valueOf(user.getCoins()));
            }
        }
    }    
    
    
    
    //Game Methode
    
    
    public void Spiel()
    {
        
        //Einsatz
        
        int Einsatz = IntCheckEinsatz();
        
        if(Einsatz <= 0){
            //Fehler
            return;
        }
        
        
        
        
        //Random
        
        Random randomNummer1 = new Random();
        int wuerfel1;
        Random randomNummer2 = new Random();
        int wuerfel2;
    
        //1 = Links
        wuerfel1 = 1 + randomNummer1.nextInt(6);
        System.out.println(wuerfel1);
        
        //2 = Rechts
        wuerfel2 = 1 + randomNummer2.nextInt(6);
        System.out.println(wuerfel2);
        
        //Ereignisse
        
        if(wuerfel1 == wuerfel2 && wuerfel1 == 1)
        {
            einsR.setVisible(true);
            einsL.setVisible(true);
            //System.out.println("einer Pasch");
        }
        else if(wuerfel1== wuerfel2 && wuerfel1 == 2)
        {
            zweiL.setVisible(true);
            zweiR.setVisible(true);
            //System.out.println("zweier pasch");
        }
        else if(wuerfel1== wuerfel2 && wuerfel1 == 3)
        {
            dreiL.setVisible(true);
            dreiR.setVisible(true);
            //System.out.println("dreier pasch");
        }
        else if(wuerfel1== wuerfel2 && wuerfel1 == 4)
        {
            vierL.setVisible(true);
            vierR.setVisible(true);
            // System.out.println("vierer pasch");
        }
        else if(wuerfel1== wuerfel2 && wuerfel1 == 5)
        {
            fuenfL.setVisible(true);
            fuenfR.setVisible(true);
            // System.out.println("fünfer pasch");
        }
        else if(wuerfel1== wuerfel2 && wuerfel1 == 6)
        {
            sechsL.setVisible(true);
            sechsR.setVisible(true);
            //System.out.println("sechser pasch");
        }
        else if(wuerfel1 != wuerfel2)
        {
            
            for(User user : App.getAllUsers()){
                
                if(user.getLoggedIn() == true){
                    
                    user.setCoins( user.getCoins() - Einsatz );
                    
                    refreshCoins();
                    
                }
                
                
            }
            
            
            //Zeigt immer den Würfel der auch gewürfelt wurde
            
            
            //Show Links
            
            if(wuerfel1 == 1){
                einsL.setVisible(true);
            }
            else if(wuerfel1 == 2){
                zweiL.setVisible(true);
            }
            else if(wuerfel1 == 3){
                dreiL.setVisible(true);
            }
            else if(wuerfel1 == 4){
                vierL.setVisible(true);
            }
            else if(wuerfel1 == 5){
                fuenfL.setVisible(true);
            }
            else if(wuerfel1 == 6){
                sechsL.setVisible(true);
            }
            
            
            //Show Rechts
            
            if(wuerfel2 == 1){
                einsR.setVisible(true);
            }
            else if(wuerfel2 == 2){
                zweiR.setVisible(true);
            }
            else if(wuerfel2 == 3){
                dreiR.setVisible(true);
            }
            else if(wuerfel2 == 4){
                vierR.setVisible(true);
            }
            else if(wuerfel2 == 5){
                fuenfR.setVisible(true);
            }
            else if(wuerfel2 == 6){
                sechsR.setVisible(true);
            }
            
            
            
            //  System.out.println("verloren");
        }
        else
        {
            System.out.println("fehler");
        }
    
    }
    
    
    //Refresht die Coins anzeige
    
    public void refreshCoins(){
        for(User user : App.getAllUsers()){
            
            CoinsWG.setText("Coins: " + String.valueOf(user.getCoins()));
            
        }
    }
    

    //Checkt den Einsatz 
    
    
    public int IntCheckEinsatz(){
        
        try{
            String sEinsatz = inputEinsatzW.getText();
                
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
            inputEinsatzW.setText("");
        }
        
        if(Max >= 10000){
            inputEinsatzW.setText("10000");
        }
        
        for(User user : App.getAllUsers()){
            if(user.getLoggedIn() == true){
                
                if((user.getCoins() - Max) < 0){
                    inputEinsatzW.setText(String.valueOf(user.getCoins()));
                }
                
            }
            
            
        }
    }
    
    
    
    
}
