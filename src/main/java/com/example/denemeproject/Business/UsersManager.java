/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.denemeproject.Business;

import com.example.denemeproject.DAL.IUserDal;
import com.example.denemeproject.DAL.UsersDal;
import com.example.denemeproject.Entities.Users;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

/**
 *
 * @author Ibrahim
 */
public class UsersManager implements IUsersService{
    
    private IUserDal userdal;
    
    public UsersManager(IUserDal userdal){
    this.userdal=userdal;
    
    }
    
    @Override
    public ArrayList<Users> getUsers() {
        return (ArrayList<Users>) userdal.getUsers();
    }

    @Override
    public void add(Users user) {
       userdal.add(user);
    }

    /**
     *
     * @param userId
     */
    public void delete(int userId) {
        userdal.delete(userId);
    }

    @Override
    public void update(Users user) {
        userdal.update(user);
    }

    @Override
    public boolean login(String username, String password) {
        return userdal.login(username, password);
    }

    @Override
    public int getUserIdByUsername(String username, String password) {
        return userdal.getUserIdByUsername(username,password);
    }

    @Override
    public int getisAdminByUsername(int id) {
         return userdal.getisAdminByUsername(id);
    }

    @Override
    public ArrayList<Users> getIdByUsername(String username) {
        return userdal.getIdByUsername(username);
    }

    @Override
    public int getUserIdByUsername(String username) {
        return userdal.getUserIdByUsername(username);
    }

    @Override
    public String getUsernameById(int id) {
       return userdal.getUsernameById(id);
    }

    @Override
    public String getEmailByUsername(String username) {
        return userdal.getEmailByUsername(username);
    }

    @Override
    public String getEmailPasswordById(int id) {
        return userdal.getEmailPasswordById(id);
    }

}
