
package airlinemanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    JTextField tfname, tfphone, tfaadhar, tfnatinality,tfaddress;
    JRadioButton rbmale, rbfemale;
    public AddCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(220, 30,500,25);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel lbaname=new JLabel("Name");
        lbaname.setBounds(60, 80,150,25);
        lbaname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbaname);
        
     
        tfname=new JTextField();
        tfname.setBounds(220,80,150,25);
        add(tfname);
       
        JLabel natinality=new JLabel("Natinality");
        natinality.setBounds(60, 130,150,25);
        natinality.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(natinality);
        
        tfnatinality=new JTextField();
        tfnatinality.setBounds(220,130,150,25);
        add(tfnatinality);
        
        JLabel lnlaadhar=new JLabel("Aadhar");
        lnlaadhar.setBounds(60, 180,150,25);
        lnlaadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lnlaadhar);
        
        tfaadhar=new JTextField();
        tfaadhar.setBounds(220,180,150,25);
        add(tfaadhar);
        
        JLabel lbladdress=new JLabel("Address");
        lbladdress.setBounds(60, 220,150,25);
        lbladdress.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbladdress);
        
        tfaddress=new JTextField();
        tfaddress.setBounds(220,220,150,25);
        add(tfaddress);
        
        JLabel lblgender=new JLabel("gender");
        lblgender.setBounds(60, 280,150,25);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblgender);
        
        
        ButtonGroup gendergroup=new ButtonGroup();
        
        rbmale=new JRadioButton("Male");
        rbmale.setBackground(Color.WHITE);
        rbmale.setBounds(220, 280, 75, 26);
        add(rbmale);
        
        rbfemale=new JRadioButton("Female");
        rbfemale.setBackground(Color.WHITE);
        
        rbfemale.setBounds(300, 280, 75, 26);
        add(rbfemale);
        
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        
        JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(60, 330,150,25);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblphone);
        
        tfphone=new JTextField();
        tfphone.setBounds(220,330,150,25);
        add(tfphone);
        
        JButton save=new JButton("Save");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(220,380,150,30);
        save.addActionListener(this);
        add(save);
        
        
        ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/Icons/empjpeg.jpeg"));
        JLabel lblimage=new JLabel(image);
        lblimage.setBounds(450,80,280,400);
        add(lblimage);
        
        
        
        setSize(900,600);
        setLocation(300,150);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        String name=tfname.getText();
        String nationality =tfnatinality.getText();
        String phone= tfphone.getText();
        String address=tfaddress.getText();
        String aadhar=tfaadhar.getText();
        String gender=null;
        if(rbmale.isSelected()){
            gender="Male";
        }
        else{
            gender="Female";
        }
        try{
            Conn conn=new Conn();
            String query="insert into passenger values('"+name+"','"+nationality+"','"+address+"','"+aadhar+"','"+gender+"')";
            conn.st.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Customer details added Sucessfully...");
            setVisible(false);
        }  
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String arhs[]){
        new AddCustomer();
    
        
    }
    
}
