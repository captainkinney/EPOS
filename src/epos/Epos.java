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
public class Epos {
    private static int customersServed = 0;
    private static double averageSale = 0.00;
    private static double minimumSale = 0.00;
    private static double maximumSale = 0.00;
    private static double totalTakings = 0.00;
    
    // Convenience method
    public static void incrementCustomersServed() { customersServed++; }
    
    public static void setCustomersServed(int num) { customersServed = num; }
    public static void setAverageSale(double num) { averageSale = num; }
    public static void setMinimumSale(double num) { minimumSale = num; }
    public static void setMaximumSale(double num) { maximumSale = num; }
    public static void setTotal(double num) { totalTakings = 0; }
    
    public int getCustomersServed() { return customersServed; }
    public double getAverageSale() { return averageSale; }
    public double getMinimumSale() { return minimumSale; }
    public double getMaximumSale() { return maximumSale; }
    public double getTotalTakings() { return totalTakings; }
}
