/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busreservation;

import javax.swing.*; // Needed for Swing classes
import java.awt.*;    // Needed for GridLayout class
import java.awt.event.*; //Needed for actionListener


/**
 *
 * @author Benjamin WU
 */
public class Interface_page_1 extends JFrame {
    final private int window_Width = 500;
    final private int window_Height = 400;
    
    private JPanel bigPanel;
    private JPanel Left_panel;
    private JPanel Right_panel;
    
    private JButton Left_Button;
    private JButton Right_Button;
    
    public Interface_page_1()
    {
         
          // JFrame window= new JFrame(); // INUTILE TU ES DEJA DANS UNE FRAME VU QUE TA CLASSE EXTENDS JFRAME
        this.setSize(window_Width, window_Height); // ON PARLE CETTE Objet

        //set a title to the window 
        this.setTitle("User Sign in"); //TJRS THIS

        //exit when the window is closed 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // THIS

        //set the type of layout 
        // this.setLayout(new GridLayout(3,3)); LA FRAME A PAS DE LAYOUT, ELLE POSSEDE JUSTE LE PANEL
        JPanel pan;
        pan = buildPanel_interface_page_1(); // ON RECUPERE LE PANEL 
        
        this.setContentPane(pan); // ON AJOUTE LE PANEL A LA FRAME

        // window.add(panel);
        //display the window 
        this.setVisible(true);
       
    }
    
    private JPanel buildPanel_interface_page_1()
    {
        Left_Button = new JButton("Admin");
        Right_Button = new JButton("Customer");
        
        bigPanel = new JPanel();
        Left_panel = new JPanel();
        Right_panel = new JPanel();
        
        bigPanel.setLayout(new GridLayout(1,2));
        
        Left_panel.add(Left_Button);
        Right_panel.add(Right_Button);
        bigPanel.add(Left_panel);
        bigPanel.add(Right_panel);
        
        Left_Button.addActionListener(new LogtoAdmin());
        Right_Button.addActionListener(new LogtoCustomer());
        
        return bigPanel;
    }

 
    
    private class LogtoAdmin implements ActionListener
    {
        @Override
          public void actionPerformed(ActionEvent e) {
              new Interface_login_admin();
              dispose();
          }
    }
    
    private class LogtoCustomer implements ActionListener
    {
        @Override
          public void actionPerformed(ActionEvent e) {
              new Interface_login();
              dispose();
          }
    }
    
    
}
