/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epos;

/**
 *
 * @author 30303058
 */
public class User {
    private static String firstName = "";
    private static String secondName = "";
    private static String username = "";
    private static String password = "";
    private static String permission = "";
    
    public static void setFirstName(String text) { firstName = text; }
    public static void setSecondName(String text) { secondName = text; }
    public static void setUsername(String text) { username = text; }
    public static void setPassword(String text) { password = text; }
    public static void setPermission(String text) { permission = text; }
    
    public static String getFirstName() { return firstName; }
    public static String getSecondName() { return secondName; }
    public static String getUsername() { return username; }
    public static String getPassword() { return password; }
    public static String getPermission() { return permission; }
}
