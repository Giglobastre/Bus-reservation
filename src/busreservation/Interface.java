/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busreservation;
import javax.swing.*; // Needed for Swing classes
import java.awt.*;    // Needed for GridLayout class
/**
 *
 * @author Benjamin WU
 */
public class Interface extends JFrame {
    
    final private int window_Width = 500;
    final private int window_Height = 400;
    private JPanel panelMessage; 
    private JPanel panelID;
    private JPanel panelPassword;
    private JPanel panelLogin;
    private JPanel panelCreateLog;
    private JPanel empty1;
    private JPanel empty2;
    private JPanel empty3;
    private JPanel empty4;
    private JPanel empty5;
    private JPanel empty6;
    private JPanel empty7;
    private JPanel panel;
    
    
    private JLabel message;
    private JTextField ID;
    private JTextField password;
    private JButton login;
    private JButton createLog;
    
    public Interface()
    {
        //create a basic window with width = 500 and height = 400
        JFrame window= new JFrame();
        window.setSize(window_Width,window_Height);
        
        //set a title to the window 
        window.setTitle("User Interface");
        
        //exit when the window is closed 
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //set the type of layout 
        setLayout(new GridLayout(4,3));
        //build a panel 
        buildPanelInterface1();
        window.add(panel);
        //display the window 
        window.setVisible(true);
    }
    
    //first window (connexion window)
    private void buildPanelInterface1()
    {
        message = new JLabel("welcome !");
        
     
        
        //create two text field of 15 characters
        ID = new JTextField(15);
        password = new JTextField(15);
        
        //create two buttons 
        login = new JButton("login");
        createLog = new JButton("Sign up");
        
        //add action when we click on the buttons 
        panel = new JPanel();
        //create  panels 
        panelMessage = new JPanel();
        panelID = new JPanel();
        panelPassword = new JPanel();
        panelLogin = new JPanel();
        panelCreateLog = new JPanel();
        empty1 = new JPanel();
        empty2 = new JPanel();
        empty3 = new JPanel();
        empty4 = new JPanel();
        empty5 = new JPanel();
        empty6 = new JPanel();
        empty7= new JPanel();
        
        //add everything to panel
        panelMessage.add(message);
        panelID.add(ID);
        panelPassword.add(password);
        panelLogin.add(login);
        panelCreateLog.add(createLog);
        panel.add(message);
        
        //layout of the connexion interface
        panel.add(empty1);
        panel.add(panelMessage);
        panel.add(empty2);
        panel.add(empty3);
        panel.add(panelID);
        panel.add(empty4);
        panel.add(empty5);
        panel.add(panelPassword);
        panel.add(empty6);
        panel.add(panelLogin);
        panel.add(empty7);
        panel.add(panelCreateLog);
        
        
    }

    
}
