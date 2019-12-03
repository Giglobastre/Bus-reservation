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
public class Interface_admin extends JFrame{
    final private int window_Width = 500;
    final private int window_Height = 400;
    private JPanel bigPanel;
    private JPanel admin;
    private JPanel phrase;
    private JPanel phrase1;
    private JPanel search;
    private JPanel see_train;
    private JPanel see_reservation;
    private JPanel add_train;
    private JPanel deconnexion;
    
    private JLabel admin_interface;
    private JLabel welcome_phrase;
    private JLabel phrase2;
    
    private JButton search_button;
    private JButton see_train_button;
    private JButton see_reservation_button; 
    private JButton add_train_button;
    private JButton deconnexion_button;
    
    public Interface_admin()
    {
        this.setSize(window_Width, window_Height);

        //set a title to the window 
        this.setTitle("User Interface_user"); //TJRS THIS

        //exit when the window is closed 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // THIS
       
        JPanel pan;
        pan = buildPanel_interface_admin(); // ON RECUPERE LE PANEL 
        this.setContentPane(pan); // ON AJOUTE LE PANEL A LA FRAME

        // window.add(panel);
        //display the window 
        this.setVisible(true);
    }
    
    private JPanel buildPanel_interface_admin()
    {
        //set JLabel and JButton
        admin_interface = new JLabel("Admin Interface");
        welcome_phrase = new JLabel("Yes Master?");
        phrase2 = new JLabel("Would you like too..");
        search_button = new JButton("Search train");
        see_train_button = new JButton("See all trains");
        see_reservation_button = new JButton("See all reservations");
        add_train_button = new JButton("Add train");
        deconnexion_button = new JButton("Deconnexion");
        
        //Initializing JPanel
        bigPanel = new JPanel();
        bigPanel.setLayout(new GridLayout(5, 3));
        
        admin = new JPanel();
        phrase = new JPanel();
        phrase1 = new JPanel();
        search = new JPanel();
        see_train = new JPanel();
        see_reservation = new JPanel();
        add_train = new JPanel();
        deconnexion = new JPanel();
        
        //add everything to a panel
        admin.add(admin_interface);
        phrase.add(welcome_phrase);
        phrase1.add(phrase2);
        search.add(search_button);
        see_train.add(see_train_button);
        see_reservation.add(see_reservation_button);
        add_train.add(add_train_button);
        deconnexion.add(deconnexion_button);
        
        //add everything to bigPanel
        bigPanel.add(new JPanel());
        bigPanel.add(admin);
        bigPanel.add(new JPanel());
        bigPanel.add(phrase);
        bigPanel.add(phrase1);
        bigPanel.add(new JPanel());
        bigPanel.add(search);
        bigPanel.add(see_train);
        bigPanel.add(new JPanel());
        bigPanel.add(see_reservation);
        bigPanel.add(add_train);
        bigPanel.add(new JPanel());
        bigPanel.add(new JPanel());
        bigPanel.add(new JPanel());
        bigPanel.add(deconnexion);
        
        return bigPanel;
    }
    
    
}