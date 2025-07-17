package airlinemanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;


public class Cancel extends JFrame implements ActionListener{
    JTextField tfpnr;
    JLabel tfname, cancellation,lblcode,lbldateoftravel;
    JButton flight,fetchButton;
    
    public Cancel(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        Random random=new Random();
        
        
        JLabel heading=new JLabel("Cancellation");
        heading.setBounds(130, 20,250,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        add(heading);
        
       
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/Icons/cancel.png"));
        Image i2=i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(470,150,250,250);
        add(image);
        
        
        JLabel lbaadhar=new JLabel("PNR Number");
        lbaadhar.setBounds(60, 80,150,25);
        lbaadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbaadhar);
        
     
        tfpnr=new JTextField();
        tfpnr.setBounds(220,80,150,25);
        add(tfpnr);
        
        fetchButton=new JButton("Show Details");
        fetchButton.setBackground(Color.black);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 80,120,25);
        fetchButton.addActionListener(this);
        add(fetchButton);
       
        JLabel lbaname=new JLabel("Name");
        lbaname.setBounds(60, 130,150,25);
        lbaname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbaname);
        
        tfname=new JLabel();
        tfname.setBounds(220,130,150,25);
        add(tfname);
        
        JLabel natinality=new JLabel("Cancellatin number");
        natinality.setBounds(60, 180,150,25);
        natinality.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(natinality);
        
        cancellation=new JLabel(""+random.nextInt(100000));
        cancellation.setBounds(220,180,150,25);
        add(cancellation);
        
        
        JLabel lbladdress=new JLabel("Flight Code");
        lbladdress.setBounds(60, 220,150,25);
        lbladdress.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbladdress);
        
        lblcode=new JLabel();
        lblcode.setBounds(220,220,150,25);
        add(lblcode);
        
        JLabel lblgender=new JLabel("Date");
        lblgender.setBounds(60, 280,150,25);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblgender);
        
        lbldateoftravel=new JLabel("Gender");
        lbldateoftravel.setBounds(220, 280,150,25);
        add(lbldateoftravel);
        
       
        
        flight=new JButton("Cancel");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(220,330,120,25);
        flight.addActionListener(this);
        add(flight);
        
        
        
        
        
        setSize(800,450);
        setLocation(300,150);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==fetchButton){
            String prn=tfpnr.getText();
            
            try{
                Conn conn=new Conn();
                String query="select * from reservation where PRN='"+prn+"'";
                ResultSet rs=conn.st.executeQuery(query);
                if(rs.next()){
                   tfname.setText(rs.getString("name"));
                   lblcode.setText(rs.getString("flightcode"));
                   lbldateoftravel.setText(rs.getString("ddate"));
                   
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Please enter correct PNR...");
                }
            }  
            catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==flight){
            String name=tfname.getText();
            String pnr=tfpnr.getText();
            String cancelno=cancellation.getText();
            String fcode= lblcode.getText();
            String date= lbldateoftravel.getText();
            
            
            
            try{
                Conn conn=new Conn();
                String query="insert into cancel values('"+pnr+"','"+name+"','"+cancelno+"','"+fcode+"','"+date+"')";
               conn.st.executeUpdate(query);
               conn.st.executeUpdate("delete from reservation where PRN='"+pnr+"'");
             
                    JOptionPane.showMessageDialog(null, "Flight Cancelled ");
                    setVisible(false);
                    
        
            }  
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String arhs[]){
        new Cancel();
    
        
    }
    
}
