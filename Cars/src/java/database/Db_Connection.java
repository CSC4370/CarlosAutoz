package database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Db_Connection {
    
    public Connection Connection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String connect = "jdbc:msyql://localhost:3306/cars?user=root";
            Connection myConnection = DriverManager.getConnection(connect);
            return myConnection;
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            Logger.getLogger(Db_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
