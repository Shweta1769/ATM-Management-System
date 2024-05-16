
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*; // for ResultSet
//ActionListener is an interface
public class Login extends JFrame implements ActionListener {
    JButton signup,clear,login;
     JTextField  cardTextField;
     JPasswordField pinTextField;
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);//we use this function because we use out custome setbounds ,actually swing bydefault change the setbounds so we use the function.
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);//use this class for change image size & image class is also not in swing package so we add awt package
        ImageIcon i3=new ImageIcon(i2);
        JLabel label =new JLabel(i3);// you cann't put a image direct  on a frame so ,you should use JLabel & cann't also put Image direct into JLabel so first you change the image into image icon 
        label.setBounds(70, 10,100, 100);
        add(label);//when you place some component on your frame that time you use add() fumction 
       
        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
         JLabel cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        add(cardno);
        
        
        cardTextField =new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
         JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);
        
        pinTextField =new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        
        login= new JButton("Sign in");
        login.setBounds(300,300,100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        
        clear= new JButton("Clear");
        clear.setBounds(430,300,100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        
        signup= new JButton("Sign up");
        signup.setBounds(300,350,230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);// with the use of function setSize we make a frame's length & breath  
        setVisible(true);
        setLocation(250,100);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardTextField.setText(" ");
            pinTextField.setText(" ");
        }
        else if(ae.getSource()== login){
            conn c=new conn();
            String cardnumber= cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query="select * from login where cardnumber= '"+cardnumber+"' and pin='"+pinnumber+"'"; //data fetch from database
            try{
               ResultSet rs= c.s.executeQuery(query);
               if(rs.next()){ //jodi data rs naye tobe user successfully login hoyeche 
                   setVisible(false);//login frame close korar jonno 
                   new Transaction(pinnumber).setVisible(true);
               }
               else{
                   JOptionPane.showMessageDialog(null,"Incorrect Card Number or pin");
               }
               
               
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()== signup){
            setVisible(false); //it is for close login page 
            new SignupOne().setVisible(true); //it is for open signup page
        }
    }
    public static void main(String args[]){
         new Login();
    }
    
}
