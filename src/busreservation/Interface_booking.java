/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busreservation;
import javax.swing.*; // Needed for Swing classes
import java.awt.*;    // Needed for GridLayout class
import java.awt.event.*; //Needed for actionListener
import java.awt.BorderLayout; 
import java.util.Random;
import javax.swing.JFrame; 
import javax.swing.JList; 
import javax.swing.JScrollPane;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

//Needed for connecting to database
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.Arrays;
/**
 *
 * @author Benjamin WU
 */
public class Interface_booking extends JFrame{
    
    final private int window_Width = 500;
    final private int window_Height = 400;
    
    //bigPanel divided by GridLayout(3,1)
    private JPanel bigPanel = new JPanel(); 
    private JPanel bigUp = new JPanel();
    private JPanel bigMid = new JPanel();
    private JPanel bigBot = new JPanel();
    
    private JPanel return1;
    private JPanel book;
    private JPanel booking;
    
    
    private JLabel booking_message;
    
    private JButton booking_now;
    private JButton return_now;
    
    private JScrollPane scrollpane; 
    private JList list; 
    
    //private String categories;
    //private ArrayList<String> categories = new ArrayList<String>(6);
    private String categories[];
    private String ID_cust;
    private customer cust_interface;
    private String buffer[];
    private JComboBox choice;
    
    public Interface_booking(customer cust1)
    {
         cust_interface = cust1;
          // JFrame window= new JFrame(); // INUTILE TU ES DEJA DANS UNE FRAME VU QUE TA CLASSE EXTENDS JFRAME
        this.setSize(window_Width, window_Height); // ON PARLE CETTE Objet

        //set a title to the window 
        this.setTitle("User Sign in"); //TJRS THIS

        //exit when the window is closed 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // THIS

        //set the type of layout 
        // this.setLayout(new GridLayout(3,3)); LA FRAME A PAS DE LAYOUT, ELLE POSSEDE JUSTE LE PANEL
        JPanel pan;
        pan = buildPanel_interface_booking(cust_interface); // ON RECUPERE LE PANEL 
        
        this.setContentPane(pan); // ON AJOUTE LE PANEL A LA FRAME

        // window.add(panel);
        //display the window 
        this.setVisible(true);
       
    }
    
    private JPanel buildPanel_interface_booking(customer cust_bp)
    {
        
        //initialize JPanel JButton JList 
        booking_message = new JLabel("Booking");
        booking_now = new JButton("Book Now");
        return_now = new JButton("Return");
        
        //initialize panel 
        
        bigPanel.setLayout(new GridLayout(3,1));
        
        bigUp.setLayout(new GridLayout(1,1));
        
        bigMid.setLayout(new GridLayout(1,1));
        
        bigBot.setLayout(new GridLayout(1,3));
        
        //initialize JPanel 
        book = new JPanel();
        booking = new JPanel();
        return1 = new JPanel();
        //set all JLabel JButton to JPanel
        book.add(booking_message);
        booking.add(booking_now);
        return1.add(return_now);
        
        //add JLabel to bigUp
        bigUp.add(book);

        //SQL get all bus data 
        //add panel to bigMid
            Connection conn = null;
            try {
                // db parameters - ptest is the name of the database
                String url = "jdbc:mysql://localhost:3308/projet_bus_java";
                String user = "root";
                String password = "";

                // create a connection to the database
                conn = DriverManager.getConnection(url, user, password);

                //read all data on bus 
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bus");
                ResultSet rs = stmt.executeQuery();
                
                int size=0;
                while (rs.next())
                    size++;
                
                categories = new String[size*6];                
                buffer = new String[size];
               
                rs.beforeFirst();
                int i=0;
                int j=0;
                while (rs.next()) {
                  //String categories[] = {"rs.getString(1)","rs.getString(2)","getString(3)","getString(4)","getString(5)","getString(6)"};
                    categories[i] = rs.getString(1);
                    buffer[j] = rs.getString(1);
                    j++;
                    i++;
                    categories[i] = rs.getString(2);
                    i++;
                    categories[i] = rs.getString(3);
                    i++;
                    categories[i] = rs.getString(4);
                    i++;
                    categories[i] = rs.getString(5);
                    i++;
                    categories[i] = rs.getString(6);
                    i++;                
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
            //initialize JList 
            //list fulfilled of bus
            list = new JList(categories); 
            scrollpane = new JScrollPane(list); 
            
             // to get content pane 
             //getContentPane().add(scrollpane, BorderLayout.CENTER); 
             bigMid.add(scrollpane); //====> bug 
             
             //initializing JComboBox
             choice = new JComboBox(buffer);
             
             
             
            
            
        //add button to bigBot
        bigBot.add(booking);
        bigBot.add(choice);
        bigBot.add(return1);
        
        //add all to bigPanel
        bigPanel.add(bigUp);
        bigPanel.add(bigMid);
        bigPanel.add(bigBot);
        
        //recup données customer
        ID_cust = cust_bp.getID();
        
        //action quand il appuie sur bouton return et book_now 
        //return_now.addActionListener(new return_button_Listener());
        
       booking_now.addActionListener(new booking_button_Listener());
        return_now.addActionListener(new return_button_Listener());
        
        return bigPanel;
    }
    
    private class return_button_Listener implements ActionListener{
        @Override
          public void actionPerformed(ActionEvent e) {
              new Interface_user(cust_interface);
              dispose();
              
          }
    }
    
   
    private class booking_button_Listener implements ActionListener{
       
         @Override
          public void actionPerformed(ActionEvent e) {
              String input_IDC, input_SEAT; //input_IDB
              //trouve un int entre 0 et 50
              Random myRand = new Random();
              int randomInteger = myRand.nextInt(50);
             
              
              input_SEAT = Integer.toString(randomInteger);
              System.out.println("seat ="+randomInteger);
              
              //give the data contained in the combox selected
              String input_IDB = (String)choice.getSelectedItem();
              input_IDC = ID_cust;
             
             //input_IDB = "1234";
             JOptionPane message = new JOptionPane();
             message.showMessageDialog(null,"Booking sucess");
              
               //SQL
            Connection conn = null;
            try {
                // db parameters - ptest is the name of the database
                String url = "jdbc:mysql://localhost:3308/projet_bus_java";
                String user = "root";
                String password = "";

                // create a connection to the database
                conn = DriverManager.getConnection(url, user, password);

                PreparedStatement stmt = conn.prepareStatement("INSERT INTO reservation (IDB, IDC, SEAT_NR) VALUES (?,?,?)");
                stmt.setString(1,input_IDB);
                stmt.setString(2,input_IDC);
                stmt.setString(3,input_SEAT);
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
            new Interface_user(cust_interface);
            dispose();
          }
    }
}
