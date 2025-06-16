package it.unimib.sd2025;

public class User{
    private String id;
    private String name;
    private String surname;
    private String email;
    private String social_security_number;
    private double balance;

    // necessari ?
    private int used_vouchers;
    private int available_vouchers;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSocial_security_number() {
        return social_security_number;
    }
    public void setSocial_security_number(String social_security_number) {
        this.social_security_number = social_security_number;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public int getUsed_vouchers() {
        return used_vouchers;
    }
    public void setUsed_vouchers(int used_vouchers) {
        this.used_vouchers = used_vouchers;
    }
    public int getAvailable_vouchers() {
        return available_vouchers;
    }
    public void setAvailable_vouchers(int available_vouchers) {
        this.available_vouchers = available_vouchers;
    }

    
}