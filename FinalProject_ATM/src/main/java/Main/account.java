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
        this.setSavings(savings);
    }

    
    // instantiate a user
    static account user = new account("Juan Dela Cruz", "700530800559", "123456", 1000, 1500);

    
    // Getters
    public String getName() {
        return name;
    }

    public String getUID() {
        return UID;
    }

    public String getPassword() {
        return password;
    }

    public double getCurrent() {
        return current;
    }
    
    public double getSavings() {
        return savings;
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
        this.savings = savings;
    }
    
}
