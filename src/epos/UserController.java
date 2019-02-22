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
import java.util.ArrayList;
import javax.swing.JOptionPane;

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

    public static ArrayList<String> retrieveUsernames()
    {
        ArrayList<String> usernames = new ArrayList<>();
        
        try
        {
            Statement myStatement = con.createStatement();
            ResultSet rs = myStatement.executeQuery("SELECT * FROM Users");
            
            while (rs.next())
            {
                String username = rs.getString("Username");
                usernames.add(username);
            }
        }
        catch (SQLException e)
        {
            System.out.println("in retrieveUsers(): " + e);
        }
        return usernames;
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
    
    public User retrieveDetails(String username)
    {
        User user = new User();
        try
        {
            Statement myStatement = con.createStatement();
            ResultSet rs = myStatement.executeQuery("SELECT * FROM Users WHERE Username='" + username + "'");
            rs.next();
            User.setFirstName(rs.getString("FirstName"));
            User.setSecondName(rs.getString("SecondName"));
            User.setUsername(username);
            User.setPassword(rs.getString("Password"));
            User.setPermission(rs.getString("Permission"));
            User.setID(rs.getString("ID"));
        }
        catch (SQLException e)
        {
            System.out.println("in retrieveDetails(): " + e);
        }
        return user;
    }
    
    public void insertUser(User user)
    {
        try
        {
            Statement myStatement = con.createStatement();
        
            String firstName = user.getFirstName();
            String secondName = user.getSecondName();
            String username = user.getUsername();
            String password = user.getPassword();
            String permission = user.getPermission();
            
            ResultSet rs = myStatement.executeQuery("SELECT * FROM Users WHERE Username='" + firstName + "'");
            if (rs.next())
            {
                throw new Error();
            }
            
            myStatement.executeUpdate("INSERT INTO Users"
                    + " (FirstName, SecondName, Username, Password, Permission)"
                    + " VALUES ('" + firstName + "', '" + secondName + "', '" + username + "', '" + password + "', '" + permission + "')");
            
            JOptionPane.showMessageDialog(null, "User Added.");
        }
        catch (SQLException e)
        {
            System.out.println("in insertUser(): " + e);
        }
        catch (Error e)
        {
            JOptionPane.showMessageDialog(null, "Error: Username Already Exists.");
        }
    }
    
    public void updateUser(String username, User user)
    {
        String firstName = user.getFirstName();
        String secondName = user.getSecondName();
        String newUsername = user.getUsername();
        String password = user.getPassword();
        String permission = user.getPermission();
        
        try
        {
            Statement myStatement = con.createStatement();
            myStatement.executeUpdate("UPDATE Users SET "
                    + "FirstName='" + firstName
                    + "', SecondName='" + secondName
                    + "', Username='" + newUsername
                    + "', Password='" + password
                    + "', Permission='" + permission
                    + "' WHERE username='" + username + "'");
            
            JOptionPane.showMessageDialog(null, "User Updated.");
        }
        catch (SQLException e)
        {
            System.out.println("in updateUser(): " + e);
        }
        
        
    }
    
    public void deleteUser(String username)
    {
        try
        {
            Statement myStatement = con.createStatement();
            myStatement.executeUpdate("DELETE * FROM Users WHERE Username='" + username + "'");
            
            JOptionPane.showMessageDialog(null, "User Deleted.");
        }
        catch (SQLException e)
        {
            System.out.println("in deleteUser(): " + e);
        }
    }
}
