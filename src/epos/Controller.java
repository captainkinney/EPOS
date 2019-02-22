package epos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 30303058
 */
public class Controller {
    public static Connection getConnection()
    {
        Connection con = null;
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
