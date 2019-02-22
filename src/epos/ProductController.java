package epos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProductController extends Controller {
    private static Connection con;
    
    public ProductController()
    {
        con = super.getConnection();
    }
    
    public static Product retrieveDetails(String productName)
    {
        Product queriedProduct = new Product();
        try
        {
            Statement myStatement = con.createStatement();
            ResultSet rs = myStatement.executeQuery("SELECT * FROM Products WHERE Product Name='" + productName + "'");
            rs.next();
            
            queriedProduct.setName(productName);
            queriedProduct.setImage(rs.getString("Image Path"));
            queriedProduct.setPrice(rs.getString("Price"));
        }
        catch (SQLException e)
        {
            System.out.println("in ProductController.retrieveDetails(): " + e);
        }
        return queriedProduct;
    }
    
    public static void insertProduct(Product product)
    {
        try
        {
            Statement myStatement = con.createStatement();
        
            String name = product.getName();
            String image = product.getImage();
            String price = product.getPrice();
            
            ResultSet rs = myStatement.executeQuery("SELECT * FROM Products WHERE ProductName='" + name + "'");
            if (rs.next())
            {
                throw new Error();
            }
            
            myStatement.executeUpdate("INSERT INTO Products"
                    + " (ProductName, Price, ImagePath)"
                    + " VALUES ('" + name + "', '" + price + "', '" + image + "')");
            
            JOptionPane.showMessageDialog(null, "Product Added.");
        }
        catch (SQLException e)
        {
            System.out.println("in insertProduct(): " + e);
        }
        catch (Error e)
        {
            JOptionPane.showMessageDialog(null, "Error: Product Already Exists.");
        }
    }
    
    public static void deleteProduct(String name)
    {
        try
        {
            Statement myStatement = con.createStatement();
            myStatement.executeUpdate("DELETE * FROM Products WHERE ProductName='" + name + "'");
            
            JOptionPane.showMessageDialog(null, "Product Removed.");
        }
        catch(SQLException e)
        {
            System.out.println("in deleteProduct(): " + e);
        }
    }
    
    public static ArrayList<String> retrieveProducts()
    {
        ArrayList<String> products = new ArrayList<>();
        
        try
        {
            Statement myStatement = con.createStatement();
            ResultSet rs = myStatement.executeQuery("SELECT * FROM Products");
            
            while (rs.next())
            {
                products.add(rs.getString("ProductName"));
            }
        }
        catch (SQLException e)
        {
            System.out.println("in retrieveProducts(): " + e);
        }
        return products;
    }
}
