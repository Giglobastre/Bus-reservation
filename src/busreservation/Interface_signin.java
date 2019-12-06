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
 * @author Kenny-portable
 */
public class Interface_signin extends JFrame{
    
    final private int window_Width = 500;
    final private int window_Height = 400;
    
    private JPanel panel;
    private JPanel Panelmessage;
    private JPanel Panelfirstname;
    private JPanel Panellastname;
    private JPanel Panelpwd;
    private JPanel Panelusername;
    private JPanel Panelbut;
    private JPanel return_panel;
    
    private JPanel PanelTfirstname;
    private JPanel PanelTlastname;
    private JPanel PanelTusername;
    private JPanel PanelTpwd;
    
    private JLabel message;
    private JLabel firstname;
    private JLabel lastname;
    private JLabel pwd;
    private JLabel username;
    
    private JTextField Tfirstname;
    private JTextField Tlastname;
    private JTextField Tpassword;
    private JTextField Tusername;
    
    private JButton Submit;
    private JButton return1;
    
    public Interface_signin() {

        // JFrame window= new JFrame(); // INUTILE TU ES DEJA DANS UNE FRAME VU QUE TA CLASSE EXTENDS JFRAME
        this.setSize(window_Width, window_Height); // ON PARLE CETTE Objet

        //set a title to the window 
        this.setTitle("User Sign in"); //TJRS THIS

        //exit when the window is closed 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // THIS

        //set the type of layout 
        // this.setLayout(new GridLayout(3,3)); LA FRAME A PAS DE LAYOUT, ELLE POSSEDE JUSTE LE PANEL
        JPanel pan;
        pan = buildPanelInterface_signup(); // ON RECUPERE LE PANEL 
        this.setContentPane(pan); // ON AJOUTE LE PANEL A LA FRAME

        // window.add(panel);
        //display the window 
        this.setVisible(true);

    }
    
    private JPanel buildPanelInterface_signup() {

        message = new JLabel("Sign-up here");
        firstname = new JLabel("Firstname");
        lastname = new JLabel("Lastname");
        username=new JLabel("Username");
        pwd=new JLabel("Password");
        
        Tfirstname=new JTextField(15);
        Tlastname=new JTextField(15);
        Tpassword=new JTextField(15);
        Tusername=new JTextField(15);
        
        Submit=new JButton("Submit");
        return1 = new JButton("Return");

        Submit.addActionListener(new submittButtonListener());
        return1.addActionListener(new Return_Button());

        //fond de l'ecran
        panel = new JPanel();
        panel.setLayout(new GridLayout(6, 3)); // C EST LE PANEL QUI A UN LAYOUT. LA FRAME POSSEDE JUSTE LE PANEL 

         //create  blocs panels 
        Panelmessage = new JPanel();
        Panelfirstname = new JPanel();
        Panellastname = new JPanel();
        Panelpwd = new JPanel();
        Panelusername = new JPanel();
        
        PanelTfirstname= new JPanel();
        PanelTlastname= new JPanel();
        PanelTusername= new JPanel();
        PanelTpwd= new JPanel();

        Panelbut=new JPanel();
        return_panel = new JPanel();
        
        //add everything to panel
        Panelmessage.add(message);
        Panelfirstname.add(firstname);
        Panellastname.add(lastname);
        Panelpwd.add(pwd);
        Panelusername.add(username);
        
        PanelTfirstname.add(Tfirstname);
        PanelTlastname.add(Tlastname);
        PanelTpwd.add(Tpassword);
        PanelTusername.add(Tusername);
        
        Panelbut.add(Submit);
        return_panel.add(return1);

        
        panel.add(new JPanel());
        panel.add(Panelmessage);
        panel.add(new JPanel());
        
        panel.add(Panelfirstname);
        panel.add(PanelTfirstname);
        panel.add(new JPanel());
        
        panel.add(Panellastname);
        panel.add(PanelTlastname);
        panel.add(new JPanel());
        
        panel.add(Panelusername);
        panel.add(PanelTusername);
        panel.add(new JPanel());
        
        panel.add(Panelpwd);
        panel.add(PanelTpwd);
        panel.add(new JPanel());
        
        panel.add(new JPanel());
        panel.add(Panelbut);
        panel.add(return_panel);

        return panel;

    }


private class submittButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String input_fn, input_ln, input_uname, input_passwd;

            input_fn=Tfirstname.getText();
            input_ln=Tlastname.getText();
            input_uname=Tusername.getText();
            input_passwd=Tpassword.getText();
            
            //SQL
            Connection conn = null;
            try {
                // db parameters - ptest is the name of the database
                String url = "jdbc:mysql://localhost:3308/projet_bus_java";
                String user = "root";
                String password = "";

                // create a connection to the database
                conn = DriverManager.getConnection(url, user, password);

                PreparedStatement stmt = conn.prepareStatement("INSERT INTO customer(nom, prenom, login, password, admin) VALUES(?,?,?,?,false)");
                stmt.setString(1, input_fn);
                stmt.setString(2, input_ln);
                stmt.setString(3, input_uname);
                stmt.setString(4, input_passwd);
                boolean query=stmt.execute();

                conn.close();

            } catch (SQLException err) {
                System.out.println(err.getMessage());
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            
            new Interface_login();
            dispose();
        }
    }
    
    private class Return_Button implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Interface_login();
            dispose();
        }
    }
}