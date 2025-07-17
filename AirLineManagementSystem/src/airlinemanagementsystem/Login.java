
package airlinemanagementsystem;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton Submit,reset,close;
    JTextField username;
    JPasswordField password;

    public Login(){
        
        getContentPane().setBackground(Color.gray);
        setLayout(null);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(20,20,100,20);
        add(lblusername);
        
        username=new JTextField();
        username.setBounds(130, 20,200,20);
        add(username);
        
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(20,60,100,20);
        add(lblpassword);
        
        password=new JPasswordField();
        password.setBounds(130,60,200,20);
        add(password);
        
        reset=new JButton("Reset");
        reset.setBounds(50,120,100,20);
        reset.addActionListener(this);
        add(reset);
    
        Submit=new JButton("Submit");
        Submit.setBounds(150,150,100,20);
        Submit.addActionListener(this);
        add(Submit);
        
        close=new JButton("close");
        close.setBounds(250,120,100,20);
        close.addActionListener(this);
        add(close);
        
        
        
        
        
        
        setSize(400,250);
        setLocation(600,250);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Submit){
            String user=username.getText();
            String pass=password.getText();
            
            try{
                Conn c=new Conn();
                String query="select * from login where username='"+user+"'and Password='"+pass+"'";
                ResultSet rs=c.st.executeQuery(query);
                
                if(rs.next()){
                    new Home();
                    setVisible(false);
                    
                }else{
                    JOptionPane.showMessageDialog(null,"invalid Username and password!!");
                    setVisible(false);
                }
            }
            catch(Exception e){
                
            }
            
        }else if (ae.getSource()==close){
            setVisible(false);
        }
        else if(ae.getSource()==reset){
            username.setText("");
            password.setText("");
            
        }
        
    }
    public static void main(String args[]){
        new Login();
    }
    
    
    
}
