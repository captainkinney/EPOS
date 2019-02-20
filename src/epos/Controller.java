/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 30303058
 */
public class Controller {
    public static Connection con;
    
    public static Connection getConnection()
    {
        try
        {
            con = DriverManager.getConnection("jdbc:ucanaccess://Data\\Data.accdb");
        }
        catch (SQLException e)
        {
            System.out.println("in getConnection(): " + e);
        }
        return con;
    }
}
