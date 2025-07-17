package airlinemanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;


public class BookFlight extends JFrame implements ActionListener{
    JTextField tfaadhar;
    JLabel tfname, tfnatinality,tfaddress,lebelgender,lebelfname,lebelfcode;
    JButton bookflight,flight,fetchButton;
    Choice source, destination;
    JDateChooser dsdate;
    public BookFlight(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Book Flight");
        heading.setBounds(420, 20,500,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel lbaadhar=new JLabel("Adhar");
        lbaadhar.setBounds(60, 80,150,25);
        lbaadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbaadhar);
        
     
        tfaadhar=new JTextField();
        tfaadhar.setBounds(220,80,150,25);
        add(tfaadhar);
        
        fetchButton=new JButton("Fetch User");
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
        
        JLabel natinality=new JLabel("Natinanality");
        natinality.setBounds(60, 180,150,25);
        natinality.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(natinality);
        
        tfnatinality=new JLabel();
        tfnatinality.setBounds(220,180,150,25);
        add(tfnatinality);
        
        
        JLabel lbladdress=new JLabel("Address");
        lbladdress.setBounds(60, 220,150,25);
        lbladdress.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbladdress);
        
        tfaddress=new JLabel();
        tfaddress.setBounds(220,220,150,25);
        add(tfaddress);
        
        JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(60, 280,150,25);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblgender);
        
        lebelgender=new JLabel("Gender");
        lebelgender.setBounds(220, 280,150,25);
        add(lebelgender);
        
        JLabel lblsource=new JLabel("Source");
        lblsource.setBounds(60, 330,150,25);
        lblsource.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblsource);
        
        source=new Choice();
        source.setBounds(220,330,150,25);
        add(source);
        
        JLabel lbldesination=new JLabel("Destination");
        lbldesination.setBounds(60, 380,150,25);
        lbldesination.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldesination);
        
        destination=new Choice();
        destination.setBounds(220,380,150,25);
        add(destination);
        try{
            Conn con=new Conn();
            String query="select * from flight";
            ResultSet rs=con.st.executeQuery(query);
            while(rs.next()){
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
       
        
        flight=new JButton("Fetch Flights");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(380,380,120,25);
        flight.addActionListener(this);
        add(flight);
        
        JLabel lblfname=new JLabel("Flight Name");
        lblfname.setBounds(60, 430,150,25);
        lblfname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblfname);
        
        lebelfname=new JLabel();
        lebelfname.setBounds(220,430,150,25);
        add(lebelfname);
        
        JLabel lblfcode=new JLabel("Flight code");
        lblfcode.setBounds(60, 480,150,25);
        lblfcode.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblfcode);
        
        lebelfcode=new JLabel();
        lebelfcode.setBounds(220,480,150,25);
        add(lebelfcode);
        
        JLabel lbldate=new JLabel("Date Of Travel");
        lbldate.setBounds(60, 530,150,25);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldate);
        
        dsdate=new JDateChooser();
        dsdate.setBounds(220,530,150,25);
        add(dsdate);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/Icons/details.png"));
        Image i2=i1.getImage().getScaledInstance(460,320,Image.SCALE_DEFAULT);
        ImageIcon image=new ImageIcon(i2);
        JLabel lblimage=new JLabel(image);
        lblimage.setBounds(550,80,500,410);
        add(lblimage);
        
        bookflight=new JButton("Book Flight");
        bookflight.setBackground(Color.black);
        bookflight.setForeground(Color.WHITE);
        bookflight.setBounds(220, 580,150,25);
        bookflight.addActionListener(this);
        add(bookflight);
        
        
        
        setSize(1100,700);
        setLocation(200,50);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==fetchButton){
            String aadhar=tfaadhar.getText();
            
            try{
                Conn conn=new Conn();
                String query="select * from passenger where aadhar='"+aadhar+"'";
                ResultSet rs=conn.st.executeQuery(query);
                if(rs.next()){
                   tfname.setText(rs.getString("name"));
                   tfnatinality.setText(rs.getString("nationality"));
                   tfaddress.setText(rs.getString("address"));
                   lebelgender.setText(rs.getString("gender"));
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Please enter correct aadhar...");
                }
            }  
            catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==flight){
            String src=source.getSelectedItem();
            String dest=destination.getSelectedItem();
            try{
                Conn conn=new Conn();
                String query="select * from flight where source='"+src+"'and destination='"+dest+"'";
                ResultSet rs=conn.st.executeQuery(query);
                if(rs.next()){
                    lebelfname.setText(rs.getString("f_name"));
                    lebelfcode.setText(rs.getString("f_code"));
             
                }else{
                    JOptionPane.showMessageDialog(null, "No Flights Found");
                    
                }
            }  
            catch(Exception e){
                e.printStackTrace();
            }
        }else{
            Random random=new Random();
            String aadhar= tfaadhar.getText();
            String name=tfname.getText();
            String nationality=tfnatinality.getText();
            String flightname=lebelfname.getText();
            String flightcode=lebelfcode.getText();
            String src=source.getSelectedItem();
            String des=destination.getSelectedItem();
            String ddate=((JTextField)dsdate.getDateEditor().getUiComponent()).getText();
  
            try{
                Conn conn=new Conn();
                String query="insert into reservation values('PRN-" +random.nextInt(100000)+"',' TIC-="+random.nextInt(100000)+"','"+aadhar+"','"+name+"','"+nationality+"','"+flightname+"','"+flightcode+"','"+src+"','"+des+"','"+ddate+"')" ;
                conn.st.executeUpdate(query);
                
                    JOptionPane.showMessageDialog(null, "Tickit Book Successfully");
                    setVisible(false);
            } 
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String arhs[]){
        new BookFlight();
    
        
    }
    
}
