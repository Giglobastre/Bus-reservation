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
import javax.swing.border.LineBorder;
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
    /*private JPanel search;
    private JPanel see_train;
    private JPanel see_reservation;
    private JPanel add_train;*/
    private JPanel deconnexion;
    private JPanel button;
    
    private JLabel admin_interface;
    private JLabel welcome_phrase;
    private JLabel phrase2;
    
    private JButton Manage_bus_button;
    private JButton Manage_customer_button;
    private JButton Manage_reservation_button; 
    private JButton add_bus_button;
    private JButton deconnexion_button;
    
    public Interface_admin()
    {
        this.setSize(window_Width, window_Height);

        //set a title to the window 
        this.setTitle("Admin Interface"); //TJRS THIS
        
        //borderless
        this.setUndecorated(true);
        //exit when the window is closed 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // THIS
       
        JPanel pan;
        pan = buildPanel_interface_admin(); // ON RECUPERE LE PANEL 
        this.setContentPane(pan); // ON AJOUTE LE PANEL A LA FRAME

        
        this.setVisible(true);
    }
    
    private JPanel buildPanel_interface_admin()
    {
        //set JLabel and JButton
        admin_interface = new JLabel("Admin Interface");
        welcome_phrase = new JLabel("What do you want to do? ");
        phrase2 = new JLabel("Would you like too..");
        Manage_bus_button = new JButton("Manage Bus");
        Manage_customer_button = new JButton("Manage Customer");
        Manage_reservation_button = new JButton("Manage reservations");
        add_bus_button = new JButton("Add Bus");
        deconnexion_button = new JButton("Disconnect");
        
        //Initializing JPanel
        bigPanel = new JPanel();
        bigPanel.setLayout(new GridLayout(4, 1));
        
        
       //deconnexion = new JPanel();
        button = new JPanel();
        button.setLayout(new GridLayout(2,2));
        
        
        //add everything to a panel
        
        
        button.add(Manage_bus_button);
        button.add(Manage_customer_button);
        button.add(Manage_reservation_button);
        button.add(add_bus_button);
        //deconnexion.add(deconnexion_button);
        
        Manage_bus_button.setBackground(Color.darkGray);
        Manage_customer_button.setBackground(Color.darkGray);
        Manage_reservation_button.setBackground(Color.darkGray);
        add_bus_button.setBackground(Color.darkGray);
        deconnexion_button.setBackground(Color.darkGray);
        
        Manage_bus_button.setForeground(Color.white);
        Manage_customer_button.setForeground(Color.white);
        Manage_reservation_button.setForeground(Color.white);
        add_bus_button.setForeground(Color.white);
        deconnexion_button.setForeground(Color.white);
        
        //add everything to bigPanel
        bigPanel.add(admin_interface);
        bigPanel.add(welcome_phrase);
        bigPanel.add(button);
        bigPanel.add(deconnexion_button);
        
        deconnexion_button.addActionListener(new deco_listener());
        Manage_bus_button.addActionListener(new manage_bus_function());
        Manage_reservation_button.addActionListener(new manage_reservation_function());
        add_bus_button.addActionListener(new add_bus_function());
        Manage_customer_button.addActionListener(new manage_customer_function());
        
        return bigPanel;
    }
    
    private class deco_listener implements ActionListener{
        @Override
          public void actionPerformed(ActionEvent e) {
              new Interface_login();
              dispose();
          }
    }
    
    private class manage_bus_function implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new Interface_manage_bus_admin();
            dispose();
        }
    }
    
    private class manage_reservation_function implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new Interface_admin_SeeAllRes();
            dispose();
        }
    }
    
    private class add_bus_function implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new Interface_add_newBus();
            dispose();
        }
    }
    
    private class manage_customer_function implements ActionListener{
        @Override 
        public void actionPerformed(ActionEvent e){
            new Interface_admin_manage_user();
            dispose();
        }
    }
}