/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 30303058
 */
public final class UserController extends Controller {
    public static Connection con;
    
    public UserController()
    {
        con = super.getConnection();
    }
    
    public static String login(String username, String password)
    {
        String login = "incorrect"; //default login value for failed attempt.
        try
        {
            Statement myStatement = con.createStatement();
            ResultSet rs = myStatement.executeQuery("SELECT * FROM Users WHERE Username='" + username + "'");
            rs.next();
            
            String databasePassword = rs.getString("Password");
            if (databasePassword.equals(password))
            {
                login = rs.getString("Permission");
                System.out.println("logged in: " + login);
            }
        }
        catch (SQLException e)
        {
            System.out.println("in login(): " + e);
        }
        return login;
    }
    
    public static User retrieveDetails(String username)
    {
        User user = new User();
        try
        {
            Statement myStatement = con.createStatement();
            ResultSet rs = myStatement.executeQuery("SELECT * FROM Users WHERE Username='" + username + "'");
            rs.next();
            User.setFirstName(rs.getString("First Name"));
            User.setSecondName(rs.getString("Second Name"));
            User.setUsername(rs.getString("Username"));
            User.setPassword(rs.getString("Password"));
            User.setPermission(rs.getString("Permission"));
        }
        catch (SQLException e)
        {
            System.out.println("in retrieveDetails(): " + e);
        }
        return user;
    }
}
