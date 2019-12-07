/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busreservation;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Benjamin WU
 */
public class customer {
    
    //declaration des attribues 
    private String customerID;
    private String Fname;
    private String Lname;
    private String user_name;
    private String password;
   
    //constructor
    public customer(String ID, String FN, String LN, String user, String pass)
    {
        customerID = ID;
        Fname = FN;
        Lname = FN;
        user_name = user;
        password = pass;
        
    }
    
    public String getID()
    {
        return customerID;
    }
    public String getLn()
    {
        return Lname;
    }
    public String getFn()
    {
        return Fname;
    }
    public String getUser()
    {
        return user_name;
    }
   
}
