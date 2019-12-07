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
public class Interface_login extends JFrame {

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
    private JPanel panel_return;

    private JLabel Username;
    private JLabel passwordco;
    private JLabel welcome;
    private JTextField ID;
    private JTextField password;
    private JButton login;
    private JButton createLog;

    public Interface_login() {

        // JFrame window= new JFrame(); // INUTILE TU ES DEJA DANS UNE FRAME VU QUE TA CLASSE EXTENDS JFRAME
        this.setSize(window_Width, window_Height); // ON PARLE CETTE Objet

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
    private JPanel buildPanelInterface1() {

        welcome = new JLabel("welcome !");
        Username = new JLabel("Username");
        passwordco = new JLabel("password");

        //create two text field of 15 characters
        ID = new JTextField(15);
        password = new JTextField(15);

        //create two buttons 
        login = new JButton("Login");
        createLog = new JButton("Sign up");

        // Add an action listener to the button.
        login.addActionListener(new connectButtonListener());
        createLog.addActionListener(new createButtonListener());

        //fond de l'ecran
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 3)); // C EST LE PANEL QUI A UN LAYOUT. LA FRAME POSSEDE JUSTE LE PANEL 

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
        panel.add(panelCreateLog);
        panel.add(new JPanel());

        return panel;

    }

    private class connectButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String input_usr, input_pwd;

            input_usr = ID.getText();
            input_pwd = password.getText();

            //SQL
            Connection conn = null;
            try {
                // db parameters - ptest is the name of the database
                String url = "jdbc:mysql://localhost:3308/projet_bus_java";
                String user = "root";
                String password = "";

                // create a connection to the database
                conn = DriverManager.getConnection(url, user, password);

                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM customer WHERE login=? AND  password=?");
                stmt.setString(1, input_usr);
                stmt.setString(2, input_pwd);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getBoolean(6));
                    if (rs.getBoolean(6) == true) {
                        System.out.println("admin");
                        //pas besoin de creer un admin
                        new Interface_admin();
                        dispose();
                    } 
                    
                    else if (rs.getBoolean(6) == false) {
                        System.out.println("pas admin");
                        customer customer1 = new customer(rs.getString(1),rs.getString(3),rs.getString(2),rs.getString(4),rs.getString(5));
                        
                        //create user interface
                        new Interface_user(customer1);
                        dispose();
                    }
                }

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

        }
    }

    private class createButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new Interface_signin();
            dispose();
        }
    }
    
}
