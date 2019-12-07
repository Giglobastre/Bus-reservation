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
 * @author Kenny-portable
 */
public class TEST_scrollpane extends JFrame{
    
    final private int W = 500;
    final private int H = 400;
    
    private JPanel fond;
    private JPanel fond_label;
    
    private JScrollPane SP;

    private JLabel L1;
    private JLabel L2;
    private JLabel L3;
    private JLabel L4;
    private JLabel L5;
    private JLabel L6;
    private JLabel L7;
    private JLabel L8;
    private JLabel L9;
    private JLabel L10;
  
        
    public TEST_scrollpane(){
        
        this.setSize(W,H);
        this.setTitle("Test scroll pane");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.getContentPane().setLayout(new FlowLayout());
        JPanel pan; 
        pan = buildPanel_test_SP();
        //this.setContentPane(pan);
        this.getContentPane().setLayout(new GridLayout(1,2));
        this.getContentPane().add(pan);
        this.getContentPane().add(SP);
        
        //this.pack();
        this.setVisible(true);
    }
    
    private JPanel buildPanel_test_SP(){
        
        fond=new JPanel();
        fond_label=new JPanel();
        //SP=new JScrollPane();
        
        //SP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        fond_label.setLayout(new GridLayout(1,10));
        //SP.setBounds(0, 0,500, 400);
        
        L1=new JLabel("( LABEL LABEL ");
        L2=new JLabel("( LABEL LABEL ");
        L3=new JLabel("( LABEL LABEL ");
        L4=new JLabel("( LABEL LABEL ");
        L5=new JLabel("( LABEL LABEL ");
        L6=new JLabel("( LABEL LABEL ");
        L7=new JLabel("( LABEL LABEL ");
        L8=new JLabel("( LABEL LABEL ");
        L9=new JLabel("( LABEL LABEL ");
        L10=new JLabel("( LABEL LABEL ");
        
        fond_label.add(L1);
        fond_label.add(L2);
        fond_label.add(L3);
        fond_label.add(L4);
        fond_label.add(L5);
        fond_label.add(L6);
        fond_label.add(L7);
        fond_label.add(L8);
        fond_label.add(L9);
        fond_label.add(L10);
        
        //SP.add(fond_label);
        SP=new JScrollPane(fond_label);
        //SP.setBounds(0, 0,500, 400);
        SP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        //fond.add(SP);
        
        return fond_label;
    }
            
}