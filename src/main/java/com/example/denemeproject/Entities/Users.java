/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.denemeproject.Entities;

public class Users {
    private static Users instance;
    private int id;
    private String username;
    private String password;
    private int isAdmin;
    private String email;
    private String emailpassword;

    
    public static Users getInstance() {
        if (instance == null) {
            instance = new Users();
        }
        return instance;
    }
    
    public Users(){}

    public Users(int id, String username, String password, int isAdmin){
    this.id=id;
    this.username=username;
    this.password=password;
    this.isAdmin=isAdmin;
    }
    
    /**
     *
     * @param id
     * @param username
     * @param password
     * @param isAdmin
     * @param email
     * @param password
     */
    public Users(int id, String username, String password, int isAdmin, String email, String emailpassword){
    this.id=id;
    this.username=username;
    this.password=password;
    this.isAdmin=isAdmin;
    this.email=email;
    this.emailpassword=emailpassword;
    }
  
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }

    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the isAdmin
     */
    public int getIsAdmin() {
        return isAdmin;
    }

    /**
     * @param isAdmin the isAdmin to set
     */
    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the emailpassword
     */
    public String getEmailpassword() {
        return emailpassword;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param emailpassword the emailpassword to set
     */
    public void setEmailpassword(String emailpassword) {
        this.emailpassword = emailpassword;
    }
    
    
    
}
