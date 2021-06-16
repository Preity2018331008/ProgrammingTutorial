package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
    private Connection con;
    private Statement statement;
    public Connection getConnection() throws SQLException{
        if(con==null){
            String url="jdbc:mysql://localhost/";
            String dbName = "dmc";
            String driver = "com.mysql.jdbc.Driver";
            String userName = "root";
            String password = "";
            try{
                Class.forName(driver);
                this.con=(Connection) DriverManager.getConnection(url+dbName,userName,password);
            }
            catch(ClassNotFoundException | SQLException sqle){
                System.out.println(sqle);
            }
        }
        return con;
    }
}
