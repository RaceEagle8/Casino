package com.mycompany.casino;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import static javafx.application.Application.launch;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static ArrayList<User> Users;
    
    
            
    
    
    @Override
    public void start(Stage stage) throws IOException {
        App.Users = new ArrayList<User>();
        scene = new Scene(loadFXML("StartView"), 1049, 601);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    
    
    //-------------------------------------------------------------------
    public static void addUsers(String UserName, String EMail, String Password, boolean Darf, int Coins, int Level,boolean LoggedIn, boolean Wuerfeln, boolean Roulette){
        App.Users.add((new User(UserName, EMail, Password, Darf, Coins, Level,LoggedIn, Wuerfeln, Roulette)));
    }
    
    public static void removeUsers(User user){
        App.Users.remove(user);
    }
    
    public static User lastAddedUser(){
        return App.Users.get(App.Users.size()-1);
    }
   
    
    public static ArrayList<User> getAllUsers(){
        return App.Users;
    }
    
    //--------------------------------------------------------------------
    
    public static void Time(){
        try
        {
           Thread Neu = new Thread();
            Neu.sleep(2500);
           
        }catch(InterruptedException error)
        {
            System.out.println("Fehler des Systems Programm wird nach letztem BACKUP neu ausgeführt!");
            return;
        }
        
    }
    
    //

    
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        
        launch();
    }

}