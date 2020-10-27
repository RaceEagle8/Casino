/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.casino;


import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author guido
 */
public class RegistrationController implements Initializable {

       
    
   
     
    @FXML
    private TextField inputUsername;
    @FXML
    private TextField inputEMail;
    @FXML
    private TextField intputPassword1;
    @FXML
    private TextField inputPasswort2;
    @FXML
    private TextField dateBDay;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    //stage wird geschlossen
    
    
    @FXML
    private void btnBackRegistration(ActionEvent event) throws IOException {
        App.setRoot("MainScreen");
        
    }
    
    @FXML
    private void btnOkRegistration(ActionEvent event) throws IOException {
        System.out.println("Test");
        

       //Überprüfung ob das Passwort gleich ist.
       
       if( intputPassword1.getText().equals( inputPasswort2.getText())){
         System.out.println("Test 4");
       
        String UserName = inputUsername.getText();
        String EMail = inputEMail.getText();
        String Password = intputPassword1.getText();
        boolean LoggedIn = false;
        
        
        //Überprüfung ob es schon einen User mit gleichem UserName oder einen User mit gleicher EMail
       
        for(User Users : App.getAllUsers()){
            
            if(inputUsername.getText().equals(Users.getUserName())){
                App.setRoot("FehlerUserNameRegistration");
                return;
            }
            else{
                System.out.println("UserName Right");
            }
            
        }
        
        for(User BUsers : App.getAllUsers()){
            
            if(inputEMail.getText().equals(BUsers.getEMail())){
                App.setRoot("FehlerEMailRegistration");
                return;
            }
            else{
                System.out.println("EMail Right");
            }
            
        }
        
        for(User WUser : App.getAllUsers()){
            
            if(intputPassword1.getText().equals(WUser.getPassword())){
                App.setRoot("FehlerPassword2Registration");
                return;
            }
            else{
                System.out.println("PW Right");
            }
        }
        
        //Dates
        
        Date BDay = BDayDate();
        
        if(BDay == null){
            App.setRoot("FehlerDateRegistration");
            return;
            
        }

        boolean Darf = Dateue18(BDay);
        

        
        int Coins = 5000;
        int Level = 0;
        
        System.out.println("Erstellung");
        App.addUsers(UserName, EMail, Password, Darf, Coins, Level,LoggedIn);
        clearInput();
        
        for(User user : App.getAllUsers()){
            if(user.getDarf() == false){
                
                user.setCoins(0);
                
            }
        }
        
        App.setRoot("MainScreen");
        return;

       }
       else{
           App.setRoot("FehlerPasswordsRegistration");
           return;
       }
  
    }
   
    //Date Check ü18
    
    public boolean Dateue18(Date BDay){
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        
        
        
        Date Heute = new Date();
        
        long diffInMillies = Math.abs(Heute.getTime() - BDay.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        int UEaz = (int)diff;
        
        if(UEaz >= 6575){
            boolean Yes = true;
            return Yes;
        }
        boolean Fail = false;
        return Fail;
        
        
    }
    
    
    
    //BDay eingabe
    
    public Date BDayDate(){
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            
            try{
                Date BDay = formatter.parse(dateBDay.getText());
                return BDay;
                
            }catch(ParseException error){
                
                Date Fail = null;
                return Fail;
                
            }
        
    }
    
    
    
    
    
    //cleart die InputFelder
    
    public void clearInput(){
        inputUsername.clear();
        inputEMail.clear();
        intputPassword1.clear();
        inputPasswort2.clear();
        dateBDay.clear();
    }

}
