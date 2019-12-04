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
    private int customerID;
    private String Fname;
    private String Lname;
    private String user_name;
    private String password;
   
    //constructor
    public customer(int ID, String FN, String LN, String user, String pass)
    {
        customerID = ID;
        Fname = FN;
        Lname = FN;
        user_name = user;
        password = pass;
        
    }
    
    private int getID()
    {
        return customerID;
    }
    private String getLn()
    {
        return Lname;
    }
    private String getFn()
    {
        return Fname;
    }
    private String getUser()
    {
        return user_name;
    }
   
}
