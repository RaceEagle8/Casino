/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.casino;

/**
 *
 * @author guido
 */
public class User {
    
    public String UserName;
    public String EMail;
    public String Password;
    public boolean Darf;
    public int Coins;
    public int Level;
    public boolean LoggedIn;
    
    public User(String UserName, String EMail, String Password, boolean Darf, int Coins, int Level,boolean LoggedIn){
        
        setUserName(UserName);
        setEMail(EMail);
        setPassword(Password);
        setDarf(Darf);
        setCoins(Coins);
        setLevel(Level);
        setLoggedIn(LoggedIn);
        
    }
            
    /**
     * Getter Setter
     */
    
    //UserName
    
    public String getUserName()
    {
        return this.UserName;
    }
    
    public void setUserName(String UserName)
    {
        this.UserName = UserName;
    }
    
    //Passwort
    
    public String getPassword()
    {
        return this.Password;
    }
    
    public void setPassword(String Password)
    {
        this.Password = Password;
    }
    
    //EMail
    
    public String getEMail()
    {
        return this.EMail;
    }
    
    public void setEMail(String EMail)
    {
        this.EMail = EMail;
    }
    
    //Coins
    
    public int getCoins(){
        return this.Coins;
    }
    
    public void setCoins(int Coins){
        this.Coins = Coins;
    }
    
    //Level
    
    public int getLevel(){
        return this.Level;
    }
    
    public void setLevel(int Level){
        this.Level = Level;
    }
    
    //Darf
    
    public boolean getDarf(){
        return this.Darf;
    }
    
    public void setDarf(boolean Darf){
        this.Darf = Darf;
    }
    
    
    //LoggedIn
    
    public boolean getLoggedIn(){
        return this.LoggedIn;
    }
    
    public void setLoggedIn(boolean LoggedIn){
        this.LoggedIn = LoggedIn;
    }
            
    
}
