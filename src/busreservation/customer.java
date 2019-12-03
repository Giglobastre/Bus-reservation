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
    private int customerNumber;
   // private ArrayList<reservation> reservationPerso = new ArrayList<reservation>();
    private final int min =0;
    private final int max = 50;
    
    // generate random number between 0 and 50
    public int getRandomNumber(int mini, int maxi)
    {
        Random r = new Random();
        return r.nextInt((max - min) + 1)+ min;
    }
    
    //constructor
    public customer()
    {
        customerNumber = getRandomNumber(min,max);
    }
   
}
