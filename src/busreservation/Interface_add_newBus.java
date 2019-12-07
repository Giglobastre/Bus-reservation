/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busreservation;
import javax.swing.*; // Needed for Swing classes
import java.awt.*;    // Needed for GridLayout class
import java.awt.event.*; //Needed for actionListener
import java.text.SimpleDateFormat; //Needed for Date 
import java.util.Date;
import java.text.ParseException;
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
public class Interface_add_newBus extends JFrame{
    final private int window_Width = 500;
    final private int window_Height = 400;
    
    private JPanel bigPanel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_3;
    private JPanel panel_4;
    private JPanel panel_5;
    private JPanel panel_6;
    private JPanel panel_7;
    
    private JLabel text_1;
    private JLabel text_2;
    private JLabel text_3;
    private JLabel text_4;
    private JLabel text_5;
    private JLabel message_add_bus;
    
    private JTextField field_1;
    private JTextField field_2;
    private JTextField field_3;
    private JTextField field_4;
    private JTextField field_5;
    
    private JButton return_button;
    private JButton add_button;
    
    
    public Interface_add_newBus()
    {
        this.setSize(window_Width, window_Height);

        //set a title to the window 
        this.setTitle("User Interface_user"); //TJRS THIS

        //exit when the window is closed 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // THIS
       
        JPanel pan;
        pan = buildPanel_interface_add_newBus(); // ON RECUPERE LE PANEL 
        this.setContentPane(pan); // ON AJOUTE LE PANEL A LA FRAME

        // window.add(panel);
        //display the window 
        this.setVisible(true);
    }
    
    private JPanel buildPanel_interface_add_newBus()
    {
            //initialize all 
        bigPanel = new JPanel();
        panel_1 = new JPanel();
        panel_2 = new JPanel();
        panel_3 = new JPanel();
        panel_4 = new JPanel();
        panel_5 = new JPanel();
        panel_6 = new JPanel();
        panel_7 = new JPanel();
        
        text_1 = new JLabel("Origin");
        text_2 = new JLabel("Destination");
        text_3 = new JLabel("Departure");
        text_4 = new JLabel("Arrival");
        text_5 = new JLabel("Driver");
        message_add_bus = new JLabel("Add Bus");
        
        field_1 = new JTextField(15);
        field_2 = new JTextField(15);
        field_3 = new JTextField(15);
        field_4 = new JTextField(15);
        field_5 = new JTextField(15);
        
        return_button = new JButton("Return");
        add_button = new JButton("Add Bus");
        
        //set the layout
        bigPanel.setLayout(new GridLayout(7,1));
        panel_1.setLayout(new GridLayout(1,3));
        panel_2.setLayout(new GridLayout(1,2));
        panel_3.setLayout(new GridLayout(1,2));
        panel_4.setLayout(new GridLayout(1,2));
        panel_5.setLayout(new GridLayout(1,2));
        panel_6.setLayout(new GridLayout(1,2));
        panel_7.setLayout(new GridLayout(1,3));
        
        //set ALL to panel
        panel_1.add(new JPanel());
        panel_1.add(message_add_bus);
        panel_1.add(new JPanel());
        
        panel_2.add(text_1);
        panel_2.add(field_1);
        
        panel_3.add(text_2);
        panel_3.add(field_2);
        
        panel_4.add(text_3);
        panel_4.add(field_3);
        
        panel_5.add(text_4);
        panel_5.add(field_4);
        
        panel_6.add(text_5);
        panel_6.add(field_5);
        
        panel_7.add(new JPanel());
        panel_7.add(add_button);
        panel_7.add(return_button);
        
        bigPanel.add(panel_1);
        bigPanel.add(panel_2);
        bigPanel.add(panel_3);
        bigPanel.add(panel_4);
        bigPanel.add(panel_5);
        bigPanel.add(panel_6);
        bigPanel.add(panel_7);
        
        add_button.addActionListener(new add_bus_to_DB());
        return_button.addActionListener(new return_fuction());
        
        return bigPanel;
    }
    
    private class add_bus_to_DB implements ActionListener
    {
         @Override
          public void actionPerformed(ActionEvent e) {
              String input_origin, input_dest, input_driver, date_dep, date_arr;
              Date date_departure = null;
              Date date_arrival = null;
              
              input_origin = field_1.getText();
              input_dest = field_2.getText();
              date_dep = field_3.getText();
              date_arr = field_4.getText();
              input_driver = field_5.getText();
           
              //convert String to Date
              SimpleDateFormat input_dep = new SimpleDateFormat("dd/MM/yyyy");
              SimpleDateFormat input_arrival = new SimpleDateFormat("dd/MM/yyyy");
              
             // Date date_departure = input_dep.parse(date_dep);
            //  Date date_arrival = input_arrival.parse(date_arr);
              
              
            try{
                   date_departure = input_dep.parse(date_dep);
                   date_arrival = input_arrival.parse(date_arr);
            }
              catch (ParseException a) {
            a.printStackTrace();
        }
            java.sql.Date sql_date_dep = new java.sql.Date(date_departure.getTime());
            java.sql.Date sql_date_arrival = new java.sql.Date(date_arrival.getTime());
              
              
             Connection conn = null;
            try {
                // db parameters - ptest is the name of the database
                String url = "jdbc:mysql://localhost:3308/projet_bus_java";
                String user = "root";
                String password = "";

                // create a connection to the database
                conn = DriverManager.getConnection(url, user, password);

                PreparedStatement stmt = conn.prepareStatement("INSERT INTO bus(origin, destination, departure, arrival, driver) VALUES(?,?,?,?,?)");
                stmt.setString(1, input_origin);
                stmt.setString(2, input_dest);
                //stmt.setDate(3, input_dep);
                stmt.setDate(3,sql_date_dep);
                stmt.setDate(4,sql_date_arrival);
                stmt.setString(5, input_driver);
                boolean query=stmt.execute();

                conn.close();
                 JOptionPane message = new JOptionPane();
                 message.showMessageDialog(null,"Add sucess");

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
    private class return_fuction implements ActionListener
    {
         @Override
          public void actionPerformed(ActionEvent e) {
              new Interface_manage_bus_admin();
              dispose();
          }
    }

}    