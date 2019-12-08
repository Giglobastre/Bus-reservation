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
    private JPanel mid;
    
    
    private JLabel user;
    private JLabel welcome_phrase;
    
    private JButton booking_button;
    private JButton see_reservation_button;
    private JButton deconnexion_button;
    
    
    private customer cust;
    
    public Interface_user(customer cust1)
    {
        cust = cust1;
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
        user = new JLabel("USER INTERFACE");
        welcome_phrase = new JLabel("What can we do for you?");
        booking_button = new JButton("Booking");
        see_reservation_button = new JButton("See your reservation");
        deconnexion_button = new JButton("Disconnect");
        
        //initializing JPanel
        bigPanel = new JPanel();
        bigPanel.setLayout(new GridLayout(4, 1));
        
        
        user_interface = new JPanel();
        user_interface.setLayout(new GridLayout(1,3));
        phrase = new JPanel();
        phrase.setLayout(new GridLayout(1,2));
        mid = new JPanel();
        mid.setLayout(new GridLayout(1,2));
        
        
        //add everything to a panel 
        user_interface.add(new JPanel());
        user_interface.add(user);
        user_interface.add(new JPanel());
        phrase.add(welcome_phrase);
        phrase.add(new JPanel());
        mid.add(booking_button);
        mid.add(see_reservation_button);
        
        
        //add every panel to bigPanel
        bigPanel.add(user_interface);
        bigPanel.add(phrase);
        bigPanel.add(mid);
        bigPanel.add(deconnexion_button);
        
        booking_button.addActionListener(new booking_function());
        deconnexion_button.addActionListener(new disconnect_function());
        see_reservation_button.addActionListener(new see_reservation_function());
        
        return bigPanel;
    }
    
    private class booking_function implements ActionListener{
        @Override
          public void actionPerformed(ActionEvent e) {
              new Interface_booking(cust);
              dispose();    
        }
    }
    private class disconnect_function implements ActionListener
    {
        @Override
          public void actionPerformed(ActionEvent e) {
              new Interface_login();
              dispose();    
        }
    }
    
    private class see_reservation_function implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            new Interface_CviewRes(cust);
            dispose();
        }
    }
}
