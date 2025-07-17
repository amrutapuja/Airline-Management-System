package airlinemanagementsystem;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class JourneyDetails extends JFrame implements ActionListener{
    JTable table;
    JTextField prn;
    JButton show;
    public JourneyDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblpnr=new JLabel("PNE Deatils");
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblpnr.setBounds(50,50,100,25);
        add(lblpnr);
        
        prn=new JTextField();
        prn.setBounds(160,50,120,25);
        add(prn);
        
        show =new JButton("Show Details");
        show.setBackground(Color.black);
        show.setForeground(Color.white);
        show.setBounds(290,50,120,25);
        show.addActionListener(this);
        add(show);
        
       
        table=new JTable();
        
    
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,800,150);
        jsp.setBackground(Color.white);
        add(jsp);
        
       
        setSize(800 ,600);
        setLocation(400,150);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
          try{
            Conn conn=new Conn();
            ResultSet rs= conn.st.executeQuery("select * from reservation where PRN='"+prn.getText()+"'");
            
            if(!rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "No Information Found!!!");
                return;
    
            }
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        } 
    }
    public static void main(String args[]){
        new JourneyDetails();
        
    }
    
}