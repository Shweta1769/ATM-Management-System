
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class SignupTwo extends JFrame implements ActionListener {
    

    JTextField pan ,aadhar;
     JButton next;
     JRadioButton syes,sno,eyes,eno;
     JComboBox religion,category,income,education,occupation;
     String formno;
    SignupTwo( String formno){ //string formno = constructor , and use to call the form no from signup one form
        this.formno=formno;
        setLayout(null);
        
        setTitle("New Account Application Form -Page 2");
        
     
        
         JLabel additionalDetails= new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
         JLabel name= new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        String valReligion[]={"Hindi", "Muslim","Sikh","Christian","Others"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
      

        JLabel fname= new JLabel("Category:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        String valCategory[]={"General","ST","SC","OBC"};
        category = new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
          
        
        JLabel dob= new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
          String valIncome[]={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        income = new JComboBox(valIncome);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);

        
        
         JLabel gender= new JLabel("Educational");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        JLabel email= new JLabel("Qualification:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,315,200,30);
        add(email);
        
         String educationValues[]={"10th","12th","UG","PG","Phd"};
        education = new JComboBox(educationValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);
        
        
        JLabel marital= new JLabel("Occupation:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
        String occupationValues[]={"Salaried","Self-Employed","Business","Retired","Student","Others"};
         
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        
        
        JLabel address= new JLabel("PAN no:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
         pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD, 14));
        pan.setBounds(300,440,400,30);
        add(pan);
        
         JLabel city= new JLabel("Aadhar no:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
         aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD, 14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        JLabel state= new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
         syes=new JRadioButton("Yes"); 
        syes.setBounds(300,540,120,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
         sno=new JRadioButton("No"); 
        sno.setBounds(450,540,120,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
         ButtonGroup seniorCitizen =new ButtonGroup();
        seniorCitizen.add(syes);
        seniorCitizen.add(sno);
        
        
         JLabel pin= new JLabel("Existing Account:");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(100,590,200,30);
        add(pin);
        
         eyes=new JRadioButton("Yes"); 
        eyes.setBounds(300,590,120,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
         eno=new JRadioButton("No"); 
        eno.setBounds(450,590,120,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup existionAcc =new ButtonGroup();
        existionAcc.add(eyes);
        existionAcc.add(eno);
          
       
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,630,80,30);
        next.addActionListener(this);
        add(next);
        
      getContentPane().setBackground(Color.WHITE);
        setSize(800,700);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
      
        String sreligion = (String) religion.getSelectedItem();//with help of the set text we set the value and with the help of gettext we get the value
         String scategory = (String) category.getSelectedItem();
         String sincome=(String) income.getSelectedItem();
         String seducation=(String) education.getSelectedItem();
         String soccupation=(String) occupation.getSelectedItem();
         
         String seniorcitizen =null;
         if(syes.isSelected()){
             seniorcitizen="Yes";
         }
         else if(sno.isSelected()){
             seniorcitizen= "NO";
         }
        
         String existionAcc=null;
         if(eyes.isSelected()){
             existionAcc="Yes";
         }else if(eno.isSelected()){
             existionAcc="No";
         }
         String span= pan.getText();
         String saadhar= aadhar.getText();
         
         try{
            
                 conn c =new conn();
                 String query="insert into signuptwo values('"+ formno+"','"+ sreligion+"','"+ scategory+"','"+sincome+"','"+ seducation+"','"+ soccupation+"','"+ span+"','"+ saadhar+"','"+ existionAcc+"','"+ seniorcitizen+"')";
                 c.s.executeUpdate(query); 
             
      //signup3 object
      setVisible(false);
      new SignupThree(formno).setVisible(true);
         }catch (Exception e){
             System.out.println(e);
         }
    }
    //"String"+variable+"String"
    public static void main(String ar[]){
        new SignupTwo("");
    }
}

