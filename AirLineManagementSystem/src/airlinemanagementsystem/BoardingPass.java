package airlinemanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;


public class BoardingPass extends JFrame implements ActionListener{
    JTextField tfpnr;
    JLabel tfname, tfnatinality,lblsrc,lbldest,lebelfname,lebelfcode,lebeldate;
    JButton fetchButton;
   
    public BoardingPass(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("AIR INDIA");
        heading.setBounds(380,10,450,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        add(heading);
        
        JLabel subheading=new JLabel("Boarding Pass");
        subheading.setBounds(360,50,300,30);
        subheading.setFont(new Font("Tahoma",Font.PLAIN,24));
        subheading.setForeground(Color.BLUE);
        add(subheading);
        
        JLabel lbaadhar=new JLabel("PNR DETAILS");
        lbaadhar.setBounds(60, 100,150,25);
        lbaadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbaadhar);
        
     
        tfpnr=new JTextField();
        tfpnr.setBounds(220,100,150,25);
        add(tfpnr);
        
        fetchButton=new JButton("Enter");
        fetchButton.setBackground(Color.black);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 100,120,25);
        fetchButton.addActionListener(this);
        add(fetchButton);
       
        JLabel lbaname=new JLabel("NAME");
        lbaname.setBounds(60, 140,150,25);
        lbaname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbaname);
        
        tfname=new JLabel();
        tfname.setBounds(220,140,150,25);
        add(tfname);
        
        JLabel natinality=new JLabel("NATIIONALITY");
        natinality.setBounds(60, 180,150,25);
        natinality.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(natinality);
        
        tfnatinality=new JLabel();
        tfnatinality.setBounds(220,180,150,25);
        add(tfnatinality);
        
        
        JLabel lbladdress=new JLabel("SRC");
        lbladdress.setBounds(60, 220,150,25);
        lbladdress.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbladdress);
        
        lblsrc=new JLabel();
        lblsrc.setBounds(220,220,150,25);
        add(lblsrc);
        
        JLabel lblgender=new JLabel("DEST");
        lblgender.setBounds(380, 220,150,25);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblgender);
        
        lbldest=new JLabel();
        lbldest.setBounds(540, 220,150,25);
        add(lbldest);
        
        
        

        
        JLabel lblfname=new JLabel("Flight Name");
        lblfname.setBounds(60, 260,150,25);
        lblfname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblfname);
        
        lebelfname=new JLabel();
        lebelfname.setBounds(220,260,150,25);
        add(lebelfname);
        
        JLabel lblfcode=new JLabel("Flight code");
        lblfcode.setBounds(380, 260,150,25);
        lblfcode.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblfcode);
        
        lebelfcode=new JLabel();
        lebelfcode.setBounds(540,260,150,25);
        add(lebelfcode);
        
        JLabel lbldate=new JLabel("Date");
        lbldate.setBounds(60, 300,150,25);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldate);
        
        lebeldate=new JLabel();
        lebeldate.setBounds(220,300,150,25);
        add(lebeldate);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/Icons/airindia.jpeg"));
        Image i2=i1.getImage().getScaledInstance(300,230,Image.SCALE_DEFAULT);
        ImageIcon image=new ImageIcon(i2);
        JLabel lblimage=new JLabel(image);
        lblimage.setBounds(600,0,300,300);
        add(lblimage);
        
 
        
        
        
        setSize(1000,450);
        setLocation(300,150);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==fetchButton){
            String pnr=tfpnr.getText();
            
            try{
                Conn conn=new Conn();
                String query="select * from reservation where PRN='"+pnr+"'";
                ResultSet rs=conn.st.executeQuery(query);
                 if(rs.next()){
                   tfname.setText(rs.getString("name"));
                   tfnatinality.setText(rs.getString("nationality"));
                   lblsrc.setText(rs.getString("src"));
                   lbldest.setText(rs.getString("des"));
                   lebelfname.setText(rs.getString("flightname"));
                   lebelfcode.setText(rs.getString("flightcode"));
                   lebeldate.setText(rs.getString("ddate"));
                   
                }else{
                    JOptionPane.showMessageDialog(null, "Please enter correct PNR...");
                }
            }  
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String arhs[]){
        new BoardingPass();
    
        
    }
    
}
