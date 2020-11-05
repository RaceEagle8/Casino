package com.mycompany.casino;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;


/**
 * FXML Controller class
 *
 * @author janik
 */

public class RouletteViewController implements Initializable {
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void btnGoBackToHome(ActionEvent event) throws IOException {
        App.setRoot("RHomeScreenView");
    }

    @FXML
    private void btnStartRoulette(ActionEvent event) {
        random1();
        random2();
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
    

  
}