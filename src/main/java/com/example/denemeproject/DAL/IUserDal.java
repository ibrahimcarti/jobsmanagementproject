
package com.example.denemeproject.DAL;
import com.example.denemeproject.Entities.Users;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

/**
 *
 * @author Ibrahim
 */
public interface IUserDal {
    
    ArrayList<Users> getUsers();
    ArrayList<Users> getIdByUsername(String username);
    void add(Users user);
    void delete(int userId);
    void update(Users user);
    boolean login(String username, String password);
    int getUserIdByUsername(String username, String password);
    int getisAdminByUsername(int id);
    int getUserIdByUsername(String username);
    String getUsernameById(int id);
    String getEmailByUsername(String username);
    String getEmailPasswordById(int id);
}
