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
public class Product {
    private String name = "n/a";
    private String image = "n/a";
    private String price = "n/a";

    public void setName(String text) { name = text; }
    public void setImage(String text) { image = text; }
    public void setPrice(String text) { price = text; }
    
    public String getName() { return name; }
    public String getImage() { return image; }
    public String getPrice() { return price; }
}
