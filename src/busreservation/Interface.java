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
    private JPanel panelPasseword;
    private JPanel panelLogin;
    private JPanel panelCreateLog;
    
    
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
        setLayout(new GridLayout(5,5));
        //build a panel 
        buildPanelInterface1();
        
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
        
        //create  panels 
        panel = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        
        //add everything to panel
        panel.add(message);
        panel1.add(ID)
    }
}
