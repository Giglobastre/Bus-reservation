/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busreservation;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*; // Needed for Swing classes
import java.awt.*;    // Needed for GridLayout class
import java.awt.event.*; //Needed for actionListener
/**
 *
 * @author Benjamin WU
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        customer cust = new customer("1","ab","ac","ad","ae");
        new Interface_login();
        //new Interface_user(cust);
        //new Interface_admin();
        //new Interface_signin();
        //new Interface_page_1();
        //new Interface_signin_admin();
        //new Interface_booking(cust);
    }
    
}
