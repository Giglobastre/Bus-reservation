/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busreservation;
import javax.swing.*; // Needed for Swing classes
import java.awt.*;    // Needed for GridLayout class
import java.awt.event.*; //Needed for actionListener
//Needed for connecting to database
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*; 
/**
 *
 * @author Benjamin WU
 */
public class Interface_user extends JFrame{
    final private int window_Width = 500;
    final private int window_Height = 400;
    private JPanel bigPanel;
    private JPanel user_interface;
    private JPanel phrase;
    private JPanel booking;
    private JPanel see_reservation;
    private JPanel deconnexion;
    
    private JLabel user;
    private JLabel welcome_phrase;
    
    private JButton booking_button;
    private JButton see_reservation_button;
    private JButton deconnexion_button;
    
    public Interface_user()
    {
        this.setSize(window_Width, window_Height);

        //set a title to the window 
        this.setTitle("User Interface_user"); //TJRS THIS

        //exit when the window is closed 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // THIS
       
        JPanel pan;
        pan = buildPanel_interface_user(); // ON RECUPERE LE PANEL 
        this.setContentPane(pan); // ON AJOUTE LE PANEL A LA FRAME

        // window.add(panel);
        //display the window 
        this.setVisible(true);
    }
    
    private JPanel buildPanel_interface_user()
    {
        //set JLabel and JButton variables 
        user = new JLabel("User interface");
        welcome_phrase = new JLabel("What can we do for you?");
        booking_button = new JButton("Booking");
        see_reservation_button = new JButton("See your reservation");
        deconnexion_button = new JButton("Deconnexion");
        
        //initializing JPanel
        bigPanel = new JPanel();
        bigPanel.setLayout(new GridLayout(5, 3));
        
        user_interface = new JPanel();
        phrase = new JPanel();
        booking = new JPanel();
        see_reservation = new JPanel();
        deconnexion = new JPanel();
        
        //add everything to a panel 
        user_interface.add(user);
        phrase.add(welcome_phrase);
        booking.add(booking_button);
        see_reservation.add(see_reservation_button);
        deconnexion.add(deconnexion_button);
        
        //add every panel to bigPanel
        bigPanel.add(new JPanel());
        bigPanel.add(user_interface);
        bigPanel.add(new JPanel());
        bigPanel.add(phrase);
        bigPanel.add(new JPanel());
        bigPanel.add(new JPanel());
        bigPanel.add(booking);
        bigPanel.add(new JPanel());
        bigPanel.add(new JPanel());
        bigPanel.add(see_reservation);
        bigPanel.add(new JPanel());
        bigPanel.add(new JPanel());
        bigPanel.add(new JPanel());
        bigPanel.add(new JPanel());
        bigPanel.add(deconnexion);
        
        return bigPanel;
    }
}
