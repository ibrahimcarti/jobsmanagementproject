/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.denemeproject.Business;

import com.example.denemeproject.Entities.Users;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

/**
 *
 * @author Ibrahim
 */
public interface IUsersService {
    ArrayList<Users> getUsers();
    String getUsernameById(int id);
    ArrayList<Users> getIdByUsername(String username);
    void add(Users user);
    void delete(int userId);
    void update(Users user);
    boolean login(String username, String password);
    int getUserIdByUsername(String username, String password);
    int getisAdminByUsername(int id);
    int getUserIdByUsername(String username);
    String getEmailByUsername(String username);
    String getEmailPasswordById(int id);
}
