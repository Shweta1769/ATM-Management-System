
package bank.management.system;
import java.sql.*; //sql library
//we use the class as a object we don't run the class
public class conn {
 //constructore
    
    Connection c;
    Statement s;
    public conn(){
        try {
       
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Shweta@1769");
            s=c.createStatement(); //call korte hobe 
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
