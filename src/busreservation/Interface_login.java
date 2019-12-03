/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busreservation;

import javax.swing.*;    // Needed for Swing classes
import java.awt.event.*; // Needed for ActionListener Interface
import java.awt.*;
/**
 *
 * @author Benjamin WU
 */
public class Interface_login extends JFrame {
    
   private JPanel panel;             // To reference a panel
   private JLabel messageLabel;      // To reference a label
   
   private JLabel usrLabel;
   private JLabel pwdLabel;
   private JLabel space;
   
   private JTextField usr; // To reference a text field
   private JTextField pwd;
   private JButton connect;       // To reference a button
   private final int WINDOW_WIDTH = 700;  // Window width
   private final int WINDOW_HEIGHT = 700; // Window height
    
    public Interface_login()
    {
        // Set the window title.
      setTitle("Connexion Window");

      // Set the size of the window.
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

      // Specify what happens when the close button is clicked.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Build the panel and add it to the frame.
      setLayout(new GridLayout(4,3));
      buildPanel();

      // Add the panel to the frame's content pane.
     

      //grid
      setLayout(new GridLayout(4,3));
     
      // Display the window.
      setVisible(true);
    }
    
    private void buildPanel()
   {
       this.setLayout(new GridLayout(4,3));
      // Create a label to display instructions.
      messageLabel = new JLabel("Welcome");

      // Create a text field 10 characters wide.
      usr = new JTextField(25);
      pwd = new JTextField(25);
      space = new JLabel(" dw ");
     
      usrLabel = new JLabel("USERNAME");
      pwdLabel = new JLabel("Password");

      // Create a button with the caption "Calculate".
      connect = new JButton("Connect");
     

      // Add an action listener to the button.
      connect.addActionListener(new connectButtonListener());

      // Create a JPanel object and let the panel
      // field reference it.
      panel = new JPanel();

      // Add the label, text field, and button
      // components to the panel.
     
      // o o o
      // o o o
      // o o o
      // o o o
     
      // 1row of grid
      panel.add(new JPanel()); //skip 1row col2
      panel.add(messageLabel);
      panel.add(new JPanel());
     
      panel.add(usrLabel);
      panel.add(usr);
      panel.add(new JPanel());
     
      panel.add(pwdLabel);
      panel.add(pwd);
      panel.add(new JPanel());
     
      panel.add(new JPanel());
      panel.add(connect);
     
     
      setContentPane(panel);
      panel.setVisible(true);
   }
   
   
   private class connectButtonListener implements ActionListener
   {
      @Override
      public void actionPerformed(ActionEvent e)
      {
         String usrw, pwdw;
         final String admin="admin";
         final String adminpwd="123456";
         
         usrw = usr.getText();
         pwdw = pwd.getText();
         
         if(usr.equals(admin) && pwd.equals(adminpwd))
         {
             JOptionPane.showMessageDialog(null, "you are logged as an admin");
         }
         
      }
   }
   
   
}