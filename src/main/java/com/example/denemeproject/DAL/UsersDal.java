package com.example.denemeproject.DAL;

import com.example.denemeproject.Entities.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityGraph;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDal implements IUserDal {

    private Connection connection;

    public UsersDal() {
        connection = DbHelper.getConnection();
    }

    @Override
    public ArrayList<Users> getUsers() {
        String query = "select * from Users";
            ResultSet resultSet;
            ArrayList<Users> users = null;
            try{
                PreparedStatement statement = connection.prepareStatement(query);
                resultSet = statement.executeQuery();
                users = new ArrayList<Users>();
                while(resultSet.next()){
                users.add(new Users(resultSet.getInt("ID"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getInt("isAdmin"),
                        resultSet.getString("email"),
                        resultSet.getString("emailpassword")
                ));
                }
                statement.close();
            }catch(SQLException exception){
                exception.printStackTrace();
            }
            return users;
    }
    
    @Override
    public ArrayList<Users> getIdByUsername(String username) {
        String query = "select username from Users where username=?";
            ResultSet resultSet;
            ArrayList<Users> users = null;
            try{
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, username);
                resultSet = statement.executeQuery();
                users = new ArrayList<Users>();
                while(resultSet.next()){
                users.add(new Users(resultSet.getInt("ID"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getInt("isAdmin")
                ));
                }
                statement.close();
            }catch(SQLException exception){
                exception.printStackTrace();
            }
            return users;
    }

    @Override
    public void add(Users user) {
        String query = "INSERT INTO users (username, password, isAdmin, email, emailpassword) VALUES (?, ?, ?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getIsAdmin());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getEmailpassword());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void delete(int userId) {
        String query = "DELETE FROM users WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Users user) {
        String query = "UPDATE users SET username = ?, password = ?, isAdmin=?, email=?, emailpassword=? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setInt(3,user.getIsAdmin());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getEmailpassword());
            statement.setInt(6, user.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public boolean login(String username, String password) {
        User user = null;
        boolean result = false;
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, username);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    result = true;
                    int userId = resultSet.getInt("id");
                    Users userSession = Users.getInstance();
                    userSession.setUsername(username);
                    userSession.getId();
                } else {
                    result = false;
                }
                
                resultSet.close();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return result;
    }

    @Override
    public int getUserIdByUsername(String username, String password) {
        String query = "SELECT id FROM users WHERE username = ? AND password=?";
    try {
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, username);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("id");
        }
        resultSet.close();
        statement.close();
    } catch (SQLException exception) {
        exception.printStackTrace();
    }
    return 0;
    }

    @Override
    public int getUserIdByUsername(String username) {
        String query = "SELECT id FROM users WHERE username = ?";
    try {
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, username);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("id");
        }
        resultSet.close();
        statement.close();
    } catch (SQLException exception) {
        exception.printStackTrace();
    }
    return 0;
    }
    
    @Override
    public int getisAdminByUsername(int id) {
            String query = "SELECT isAdmin FROM users WHERE id = ?";
    try {
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("isAdmin");
        }
        resultSet.close();
        statement.close();
    } catch (SQLException exception) {
        exception.printStackTrace();
    }
    return 0;
    }
    
    @Override
    public String getUsernameById(int id){
    String query = "SELECT username FROM users WHERE id = ?";
    try {
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString("username");
        }
        resultSet.close();
        statement.close();
    } catch (SQLException exception) {
        exception.printStackTrace();
    }
        return null;
    }

    @Override
    public String getEmailByUsername(String username) {
       String query = "SELECT email FROM users WHERE username = ?";
    try {
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, username);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString("email");
        }
        resultSet.close();
        statement.close();
    } catch (SQLException exception) {
        exception.printStackTrace();
    }
        return null;
    }

    @Override
    public String getEmailPasswordById(int id) {
           String query = "SELECT emailpassword FROM users WHERE id = ?";
    try {
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString("emailpassword");
        }
        resultSet.close();
        statement.close();
    } catch (SQLException exception) {
        exception.printStackTrace();
    }
        return null;
    }
}
