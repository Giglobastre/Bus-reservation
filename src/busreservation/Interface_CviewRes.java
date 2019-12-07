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
    private JPanel bas;
    
    private JScrollPane SP_affbus;
    
    private JComboBox CB_affbus;
    
    private customer cust;
    
    private JButton button_del;
    private JButton button_ret;
    
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
        button_del=new JButton("Cancel");
        button_ret=new JButton("Return");
        button_ret.addActionListener(new but_ret());
        button_del.addActionListener(new del_res());
        CB_affbus=new JComboBox();
        bas= new JPanel();
        bas.setLayout(new GridLayout(1,2));
        
        
        //SQL
            Connection conn = null;
            try {
                // db parameters - ptest is the name of the database
                String url = "jdbc:mysql://localhost:3308/projet_bus_java";
                String user = "root";
                String password = "";

                // create a connection to the database
                conn = DriverManager.getConnection(url, user, password);

                PreparedStatement stmt = conn.prepareStatement("SELECT reservation.IDR,bus.* FROM reservation, bus WHERE reservation.IDC=? AND bus.id=reservation.IDB");
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
                    CB_affbus.addItem(rs.getString(1)+" : Reservation ID "+" From :  "+rs.getString(3)+" To : "+rs.getString(4)+" The : "+rs.getString(5) +" To :" +rs.getString(6));
                }
        
                bigpanel.add(CB_affbus);
                    
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
            
        bas.add(button_ret);
        bas.add(button_del);
        bigpanel.add(bas);
        
        return bigpanel;
    }
    
    private class but_ret implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Interface_user(cust);
        }
    }
    
    private class del_res implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String res = (String)CB_affbus.getSelectedItem();
            String tmp="";
            int i=0,cnt=0;
            while(!Character.toString(res.charAt(i)).equals(" "))
            {
                tmp+=res.charAt(i);
                i++;
            }
            
            int IDR_todel=Integer.parseInt(tmp);
            //SQL
            Connection conn = null;
            try {
                // db parameters - ptest is the name of the database
                String url = "jdbc:mysql://localhost:3308/projet_bus_java";
                String user = "root";
                String password = "";

                // create a connection to the database
                conn = DriverManager.getConnection(url, user, password);

                PreparedStatement stmt = conn.prepareStatement("DELETE FROM reservation WHERE IDR=?");
                stmt.setInt(1,IDR_todel);
                boolean query=stmt.execute();
                        ///////////////////////////////////////////////////////////////////////////////////////////////
                new Interface_CviewRes(cust); 
                dispose();
                        ///////////////////////////////////////////////////////////////////////////////////////////////
                        
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
}

