/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busreservation;
import java.awt.FlowLayout;  
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

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 *
 * @author Kenny-portable
 */
public class Interface_CviewRes extends JFrame{
    
    final private int window_Width = 500;
    final private int window_Height = 400;
    
    private JPanel bigpanel;
    private JPanel affbus;
    private JPanel info;
    
    private JScrollPane SP_affbus;
    
    private customer cust;
    
    private JLabel idr;
    private JLabel idc;
    private JLabel idb;
    private JLabel seat;
    
    public Interface_CviewRes(customer cust1){
        
        cust=cust1;
        
        this.setSize(window_Width, window_Height);

        //set a title to the window 
        this.setTitle("Your Reservations"); //TJRS THIS

        //exit when the window is closed 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // THIS
       
        JPanel pan;
        pan = buildPanel_interface_CviewRes(); // ON RECUPERE LE PANEL 
        this.setContentPane(pan); // ON AJOUTE LE PANEL A LA FRAME

        this.setVisible(true);
       
    } 
    
    private JPanel buildPanel_interface_CviewRes()
    {
        //SQL ICI POUR REMPLUS AFFBUS ?
        bigpanel=new JPanel();
        bigpanel.setLayout(new GridLayout(2,1));
        //                    x      y      w     h
       // SP_affbus.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        
        
        //SQL
            Connection conn = null;
            try {
                // db parameters - ptest is the name of the database
                String url = "jdbc:mysql://localhost:3306/projet_bus_java";
                String user = "root";
                String password = "";

                // create a connection to the database
                conn = DriverManager.getConnection(url, user, password);

                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reservation WHERE IDC=?");
                stmt.setString(1,cust.getID());
                ResultSet rs=stmt.executeQuery();
                int size=0;
                while(rs.next())
                    size++;
                
                info=new JPanel();
                info.setLayout(new GridLayout(1,size));
                //affbus.setSize(40, 200);
                
                rs.beforeFirst();
                while(rs.next())
                {
                    affbus=new JPanel();
                    affbus.setLayout(new GridLayout(4,1));
                    
                    idr=new JLabel(rs.getString(1));
                    idb=new JLabel(rs.getString(2));
                    idc=new JLabel(rs.getString(3));
                    seat=new JLabel(rs.getString(4));
                    
                    affbus.add(idr);
                    affbus.add(idb);
                    affbus.add(idc);
                    affbus.add(seat);
                    
                    info.add(affbus);
                }
                
                
                
                int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
                int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
            
                SP_affbus=new JScrollPane(info,v,h);
                //SP_affbus.setBounds(0,0,40*size, 200);
        
                bigpanel.add(SP_affbus);
        
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
            
        
        //bigpanel.pack();
        
        return bigpanel;
    }
    
}

/*//zone de texte de 20 lignes et 50 colonnes
       
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       f.setLocationRelativeTo(null);
       f.setVisible(true);
  
       JScrollPane jsp = new JScrollPane(jta);
       f.add(jsp, BorderLayout.CENTER);
       f.pack();*/
       

    /*private static void Interface_CviewRes() {  
        
        
  
        // Create and set up the window.  
        final JFrame frame = new JFrame("Scroll Pane Example");  
  
        // Display the window.  
        frame.setSize(500, 500);  
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  
        // set flow layout for the frame  
        frame.getContentPane().setLayout(new FlowLayout());  
  
        JTextArea textArea = new JTextArea(20, 20);  
        JScrollPane scrollableTextArea = new JScrollPane(textArea);  
  
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
  
        frame.getContentPane().add(scrollableTextArea);  
    }  */
   
