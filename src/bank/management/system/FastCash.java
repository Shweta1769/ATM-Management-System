
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,ministatement,pinchange,fastcash,exit,balanceenquiry;
    String pinnumber;    
//constructor amr aai jonno banai jate class r object create korle easily frame samne ese jaye 
    FastCash(String pinnumber){
        
        this.pinnumber= pinnumber;
       setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);
        
        JLabel text= new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(210,270,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,13));
        image.add(text);// image.add = for show the text above the image 
        
        
        deposit =new JButton("Rs 100");
        deposit.setBounds(140,370,130,25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl =new JButton("Rs 500");
        withdrawl.setBounds(330,370,130,25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        
        fastcash =new JButton("Rs 1000");
        fastcash.setBounds(140,400,130,25);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement =new JButton("Rs 2000");
        ministatement.setBounds(330,400,130,25);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        
        pinchange =new JButton("Rs 5000");
        pinchange.setBounds(140,430,130,25);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry =new JButton("Rs 10000");
        balanceenquiry.setBounds(330,430,130,25);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit=new JButton("BACK");
        exit.setBounds(330,460,130,25);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(800,800);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
       
    }
    // class override
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==exit){
           setVisible(false);
           new Transaction(pinnumber).setVisible(true);
        }
        else {
           String amount= ((JButton)ae.getSource()).getText().substring(3); //RS 500
           conn c=new conn();
           try{
               ResultSet rs=c.s.executeQuery("Select * from bank where pin='"+pinnumber+"'");
               int balance=0;
               while(rs.next()){
                   if(rs.getString("type").equals("Deposit")){
                       balance += Integer.parseInt(rs.getString("amount"));
                   }
                   else{
                       balance-= Integer.parseInt(rs.getString("amount"));
                   }
               }
               
               if(ae.getSource()  != exit && balance< Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null, "Insufficient Balance");
                   return;
               }
               Date date=new Date();
               String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Rs" + amount +"Debited Successfully");
             
               
               setVisible(false);
               new Transaction(pinnumber).setVisible(true);
           }catch(Exception e){
               System.out.println(e);
           }
        }
        
    }
    public static void main(String ar[]){
        
    new FastCash("");
            } 
}
