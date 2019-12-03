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

/**
 *
 * @author Benjamin WU
 */

public class InterfaceLog extends JFrame {
    
    final private int window_Width = 500;
    final private int window_Height = 400;
    
    private JPanel panelMessage; 
    private JPanel panelID;
    private JPanel panelPassword;
    private JPanel panelLogin;
    private JPanel panelCreateLog;
    private JPanel panel;
    private JPanel paneltext;
    private JPanel panel_text;

    
    private JLabel Username;
    private JLabel passwordco;
    private JLabel welcome;
    private JTextField ID;
    private JTextField password;
    private JButton login;
    private JButton createLog;
    
    public InterfaceLog()
    {
       
       // JFrame window= new JFrame(); // INUTILE TU ES DEJA DANS UNE FRAME VU QUE TA CLASSE EXTENDS JFRAME
        this.setSize(window_Width,window_Height); // ON PARLE CETTE Objet
        
        //set a title to the window 
        this.setTitle("User Interface"); //TJRS THIS
        
        //exit when the window is closed 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // THIS
        
        
        //set the type of layout 
       // this.setLayout(new GridLayout(3,3)); LA FRAME A PAS DE LAYOUT, ELLE POSSEDE JUSTE LE PANEL
       
       JPanel pan;
       pan = buildPanelInterface1(); // ON RECUPERE LE PANEL 
       this.setContentPane(pan); // ON AJOUTE LE PANEL A LA FRAME


       // window.add(panel);
        //display the window 
        this.setVisible(true);
        
    }
    
    //first window (connexion window)
    private JPanel buildPanelInterface1()
    {
        
        
        welcome = new JLabel("welcome !");
        Username = new JLabel("Username");
        passwordco  = new JLabel("password");
        
        //create two text field of 15 characters
        ID = new JTextField(15);
        password = new JTextField(15);
        
        //create two buttons 
        login = new JButton("login");
        createLog = new JButton("Sign up");
        
        
        
        //fond de l'ecran
        panel = new JPanel();
        panel.setLayout(new GridLayout(4,3)); // C EST LE PANEL QUI A UN LAYOUT. LA FRAME POSSEDE JUSTE LE PANEL 

//create  blocs panels 
        panelMessage = new JPanel();
        paneltext = new JPanel();
        panel_text = new JPanel();
        panelID = new JPanel();
        panelPassword = new JPanel();
        panelLogin = new JPanel();
        panelCreateLog = new JPanel();
        
     
        
        //add everything to panel
        panelMessage.add(welcome);
        paneltext.add(Username);
        panel_text.add(passwordco);              
        panelID.add(ID);
        panelPassword.add(password);
        panelLogin.add(login);
        panelCreateLog.add(createLog);
        
       
   
        panel.add(new JPanel());
        panel.add(panelMessage);
        panel.add(new JPanel());
        panel.add(paneltext);
        panel.add(panelID);
        panel.add(new JPanel());
        panel.add(panel_text);
        panel.add(panelPassword);
        panel.add(new JPanel());
        panel.add(panelLogin);
        panel.add(new JPanel());
        panel.add(panelCreateLog);
        

        return panel;
        
    }
}


