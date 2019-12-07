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
public class Interface_manage_bus_admin extends JFrame{
    
    final private int window_Width = 500;
    final private int window_Height = 400;
    private JPanel bigPanel;
    private JPanel bigTop;
    private JPanel top;
    private JPanel mid;
    private JPanel bigBot;
    
    private JLabel title;
    
    private JComboBox choice;
    
    private JButton add_button;
    private JButton delete_button;
    private JButton return_button;
    
    private String categories[];
    private String buffer[];
     
    private JScrollPane scrollpane; 
    private JList list; 
    
     public Interface_manage_bus_admin()
    {
        this.setSize(window_Width, window_Height);

        //set a title to the window 
        this.setTitle("User Interface_user"); //TJRS THIS

        //exit when the window is closed 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // THIS
       
        JPanel pan;
        pan = buildPanel_interface_manage_bus_admin(); // ON RECUPERE LE PANEL 
        this.setContentPane(pan); // ON AJOUTE LE PANEL A LA FRAME

        // window.add(panel);
        //display the window 
        this.setVisible(true);
    }
    
    private JPanel buildPanel_interface_manage_bus_admin()
    {
        //initialize all 
        bigPanel = new JPanel();
        bigTop = new JPanel();
        top = new JPanel();
        mid = new JPanel();
        bigBot =  new JPanel();
        title = new JLabel("Manage your bus !");
        add_button = new JButton("Add Bus");
        delete_button = new JButton("Delete Bus");
        return_button = new JButton("Return");
        
        bigPanel.setLayout(new GridLayout(4,1));
        bigTop.setLayout(new BorderLayout());
        top.setLayout(new GridLayout(1,1));
        mid.setLayout(new GridLayout(1,2));
        bigBot.setLayout(new GridLayout(1,3));
        
        
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
              
             
             //initializing JComboBox
             choice = new JComboBox(buffer);
        
             bigTop.add(title, BorderLayout.CENTER);
             //top.add(new JPanel());
             top.add(scrollpane);
             //top.add(new JPanel());
             mid.add(new JPanel());
             mid.add(choice);
             bigBot.add(add_button);
             bigBot.add(delete_button);
             bigBot.add(return_button);
             
             bigPanel.add(bigTop);
             bigPanel.add(top);
             bigPanel.add(mid);
             bigPanel.add(bigBot);
             
             add_button.addActionListener(new add_bus_function());
             delete_button.addActionListener(new delete_bus_function());
             return_button.addActionListener(new return_function());
           
        
        return bigPanel;
    }
    
    private class add_bus_function implements ActionListener
    {
        @Override
          public void actionPerformed(ActionEvent e) {
              
              new Interface_add_newBus();
              dispose();
          }
    }
    
    private class delete_bus_function implements ActionListener
    {
        @Override
          public void actionPerformed(ActionEvent e) {
              //give the data contained in the combox selected
              String input_IDB = (String)choice.getSelectedItem();
              int IDB = Integer.valueOf(input_IDB);
              System.out.println("IDB =" + IDB);
              Connection conn = null;
            try {
                // db parameters - ptest is the name of the database
                String url = "jdbc:mysql://localhost:3308/projet_bus_java";
                String user = "root";
                String password = "";

                // create a connection to the database
                conn = DriverManager.getConnection(url, user, password);

                PreparedStatement stmt = conn.prepareStatement("DELETE FROM bus WHERE id = ?");
                stmt.setInt(1,IDB);
                boolean query=stmt.execute();
                
                conn.close();
                }
            
            catch (SQLException err) {
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
              
                
                new Interface_manage_bus_admin();
                dispose();
          }
    }
    
    private class return_function implements ActionListener
    {
        @Override
          public void actionPerformed(ActionEvent e) {
              new Interface_admin();
              dispose();
          }
    }
    
}