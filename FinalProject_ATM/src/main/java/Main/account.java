/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

public class account {
    
    // Variables 
    String name;
    private String PIN, UID;
    private double current, savings;

    
    // Constructor
    account(String name, String UID, String PIN, double current, double savings) {
        this.setName(name);
        this.UID = UID;
        this.setPIN(PIN);
        this.setCurrent(current);
        this.setSavings(savings);
    }

    
    // instantiate a user
    static account user = new account("Juan Dela Cruz", "700530800559", "123456", 1000, 99999999999999.99);

    
    // Getters
    public String getName() {
        return name;
    }

    public String getUID() {
        return UID;
    }

    public String getPIN() {
        return PIN;
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

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public void setCurrent(double current) {
        this.current = current;
    }
    
    public void setSavings(double savings) {
        this.savings = savings;
    }
    
}
