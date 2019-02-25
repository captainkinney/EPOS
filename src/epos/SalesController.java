/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epos;

import static epos.UserController.con;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lewis
 */
public class SalesController extends Controller {
    
    public SalesController()
    {
        con = super.getConnection();
    }
    
    public static double retrieveTotal(String username)
    {
        double total = 0.0;
        try
        {
            Statement myStatement = con.createStatement();
            ResultSet rs = myStatement.executeQuery("SELECT * FROM Sales WHERE Username='" + username + "'");
            
            total = 0.0;
            while (rs.next())
            {
                String stringVal = rs.getString("Sale");
                total += Double.parseDouble(stringVal);
            }
        }
        catch (SQLException e)
        {
            System.out.println("in retrieveTotal(): " + e);
        }
        return total;
    }
    
    public static void submitSale(User user, double total)
    {
        try
        {
            Statement myStatement = con.createStatement();
            myStatement.executeUpdate("INSERT INTO Sales"
                + "(Username, Sale) "
                + " VALUES ('" + user.getUsername() + "', '" + String.valueOf(total) + "')");
        }
        catch (SQLException e)
        {
            System.out.println("in submitSale(): " + e);
        }
    }
    
    public static void resetSystem()
    {
        try
        {
            Statement myStatement = con.createStatement();
            myStatement.executeUpdate("DELETE * FROM Sales");
        }
        catch (SQLException e)
        {
            System.out.println("in resetSystem(): " + e);
        }
    }
}
