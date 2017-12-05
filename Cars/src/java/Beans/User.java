package Beans;

import database.Db_Connection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo
 */
public class User {
    
    private String usern, passw;
    
    public User(){
        usern = "";
        passw = "";
   }
    
    public String getUsern(){
        return usern;
    }
    
    public String getPassw(){
        return passw;
    }
    
    public void setData(String u, String p){
        this.usern = u;
        this.passw = p;
    }
    
    public void RegisterUser(){
        Db_Connection dbconn = new Db_Connection();
        Connection myconnection = dbconn.Connection();
        String sqlstatement ="INSERT INTO registereduserstable (username, password) VALUES ('"+usern+"', '"+passw+"')";
        try {
            Statement mystatement = myconnection.createStatement();
            mystatement.executeUpdate(sqlstatement);
            mystatement.close();
            myconnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean LoginUser(String user,String pwd) 
    {
            boolean check =false;
            try 
            {      
                Db_Connection dbconn=new Db_Connection();
                Connection myconnection= dbconn.Connection();
                
                PreparedStatement ps =myconnection.prepareStatement("select * from registereduserstable where username=? and password=?");

                ps.setString(1, user);
                ps.setString(2, pwd);
                ResultSet rs =ps.executeQuery();
                check = rs.next();

                myconnection.close();        
            }catch(Exception e){e.printStackTrace();}
            
            return check;    
    }
    
    public void GetUser()
    {
            try 
            {      
                Db_Connection dbconn=new Db_Connection();
                Connection myconnection= dbconn.Connection();
                
                String sqlString = "SELECT * FROM registereduserstable WHERE username = '"+usern+"'";
                Statement myStatement = myconnection.createStatement();
                ResultSet rs=myStatement.executeQuery(sqlString);

                while(rs.next())
                {
                    usern= rs.getString("username");
                    passw = rs.getString("password");
                }
                
                myStatement.close();
                myconnection.close();
                
            } catch (SQLException ex) {Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);} 
            
    }
}
