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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author guido
 */
public class LoginController implements Initializable {

    @FXML
    private TextField inputUsernameLogin;
    @FXML
    private TextField inputPasswordLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnPasswortVergessenLogin(ActionEvent event) throws IOException {
        App.setRoot("PWVergessen");
        return;
    }

    @FXML
    private void btnBackLogin(ActionEvent event) throws IOException {
        App.setRoot("MainScreen");
    }

    @FXML
    private void btnOKLogin(ActionEvent event) throws IOException {
        
        //Überprüfung Ob das Passwort zum Username passt!
        
        for(User Users : App.getAllUsers()){
            if(inputUsernameLogin.getText().equals(Users.getUserName())){
                
                if(Users.getPassword().equals(inputPasswordLogin.getText())){
                    System.out.println(" UserName und Passwort richtig " + Users.getUserName() + " " + Users.getEMail() + " " + Users);
                
                    if(Users.getDarf() == false){
                        
                        Users.setUserName("Banned");
                        System.out.println("AltersFehler");
                        
                        return;
                    }
                
                    Users.setLoggedIn(true);
                    clearInputLogin();
                    
                    System.out.println("Test1");
                    String UN = Users.getUserName();
                    
                    
                    App.setRoot("MainGame");
                    return;
                }
                
            }
            
        }
        System.out.println("FehlerBeiLogin");
        App.setRoot("FehlerBeiLogin");
        return;
        
    }
    
    public void clearInputLogin(){
        inputUsernameLogin.clear();
        inputPasswordLogin.clear();
    }
            
    
    
}
