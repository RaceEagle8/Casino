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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author guido
 */
public class PWVergessenController implements Initializable {

    @FXML
    private TextField inputUserNamePWV;
    @FXML
    private TextField inputEMailPWV;
    @FXML
    private TextField inputPasswordWPWV;
    @FXML
    private TextField inputPasswordPWV;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void btnOKPWVergessen(ActionEvent event) throws IOException {
        
        if(inputPasswordPWV.getText().equals(inputPasswordWPWV.getText())){
            System.out.println("Passwörter stimmen überein!");
            
        }
        else{
            App.setRoot("FehlerPWV3");
            return;
        }
        
        for(User YUsers : App.getAllUsers()){
            
            if(inputPasswordPWV.getText().equals(YUsers.getPassword())){
                App.setRoot("FehlerPWV2");
                return;
            }
            else{
                    System.out.println("Passwort noch nicht existent!");
            }
        }
        
        
        
        //Check ob es den User gibt
        
        for(User TUsers : App.getAllUsers()){
            
            if(inputUserNamePWV.getText().equals(TUsers.getUserName())){
                
                System.out.println("UserName ist existent im System");
                
                User BUser = TUsers;
                
                //Check ob es die EMail gibt
                
                for(User XUsers: App.getAllUsers()){
            
                    if(inputEMailPWV.getText().equals(XUsers.getEMail())){
                
                        System.out.println("EMail ist existent im System");
                
                        User CUser = XUsers;
                        
                        //Checkt ob der User vom Username der selbe wie der User der EMail ist
                        
                        if(BUser == CUser){
                            BUser.setPassword(inputPasswordPWV.getText());
                            clearInputPWV();
                            System.out.print("Login erfolgreich");
                            App.setRoot("Login");
                            return;
                        }
                        else{
                            App.setRoot("FehlerPWV");
                            return;
                        }
                    }
                    else{
                        App.setRoot("FehlerPWV");
                        return;
                    }
                }
                
            }
            else{
                App.setRoot("FehlerPWV");
                return;
            }
            
        }
  
    }

    @FXML
    private void btnBackPWVergessen(ActionEvent event) throws IOException {
        App.setRoot("Login");
    }
    
    public void clearInputPWV(){
        inputUserNamePWV.clear();
        inputEMailPWV.clear();
        inputPasswordPWV.clear();
        inputPasswordWPWV.clear();
    }
            
    
}
