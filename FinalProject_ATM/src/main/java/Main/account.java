/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;


public class account {
    
    // Variables 
    String name;
    private String password, UID;
    private double current, savings;

    
    // Constructor
    account(String name, String UID, String password, double current, double savings) {
        this.setName(name);
        this.UID = UID;
        this.setPassword(password);
        this.setCurrent(current);
    }

    
    // instantiate a user
    static account user = new account("User1", "700530800559", "123456", 1000, 1000);

    
    // Getters
    public static String getName() {
        return user.name;
    }

    public static String getUID() {
        return user.UID;
    }

    public static String getPassword() {
        return user.password;
    }

    public static double getCurrent() {
        return user.current;
    }
    
    public static double getSavings() {
        return user.savings;
    }

    
    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCurrent(double current) {
        this.current = current;
    }
    
    public void setSavings(double savings) {
        this.current = savings;
    }
    
}
