
package airlinemanagementsystem;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener {
   
    public Home(){
         
        setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/Icons/Airplane.jpg"));
        JLabel image=new JLabel(img);
        image.setBounds(0,0,1600,800);
        add(image);
        
        JLabel heading=new JLabel("!! AIR INDIA WELCOME YOU !!");
        heading.setBounds(600,40,1000,40);
        heading.setForeground(Color.black);
        heading.setFont(new Font("Tahoma",Font.PLAIN,36));
        image.add(heading);
        
        JMenuBar menuBar=new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu details=new JMenu("Details");
        menuBar.add(details);
        
        JMenuItem flightDetails=new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);
        
        JMenuItem customerDetails=new JMenuItem("Add Customer Details");
        customerDetails.addActionListener(this);
        details.add(customerDetails);
        
        JMenuItem bookFlights=new JMenuItem("Book Flight");
        bookFlights.addActionListener(this);
        details.add(bookFlights);
        
        JMenuItem journyDetails=new JMenuItem("Journy Details");
        journyDetails.addActionListener(this);
        details.add(journyDetails);
        
        JMenuItem tickitCancellation=new JMenuItem("Cancel Tickit");
        tickitCancellation.addActionListener(this);
        details.add(tickitCancellation);
        
        JMenu tickit=new JMenu("Tickit");
        menuBar.add(tickit);
        
        JMenuItem boardingPass=new JMenuItem("Boarding Pass");
        boardingPass.addActionListener(this);
        tickit.add(boardingPass);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(600,250);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        String text=ae.getActionCommand();
        if(text.equals("Add Customer Details")){
            new AddCustomer();
        }
        else if(text.equals("Flight Details")){
            new FlightInfo();
        }
        else if(text.equals("Book Flight")){
            new BookFlight();
        }
        else if(text.equals("Journy Details")){
            new JourneyDetails();
        }
        else if(text.equals("Cancel Tickit")){
            new Cancel();
        }
        else if(text.equals("Boarding Pass")){
            new BoardingPass();
        }
    }
    public static void main(String args[]){
        new Home();
    }  
}
