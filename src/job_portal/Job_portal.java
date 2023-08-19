package job_portal;

import static com.sun.glass.ui.Cursor.setVisible;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Job_portal {

       public Connection connection;
            
    public void connectDB( String table_name) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=job_portal;selectMethod=cursor", "sa", "123456");

        //    System.out.println("DATABASE NAME IS:" + connection.getMetaData().getDatabaseProductName());

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT * FROM "+table_name);
            
            boolean show = true;
            while (resultSet.next()) {         
            //System.out.println(
            //resultSet.getString());
               ResultSetMetaData rsmd = resultSet.getMetaData();
                 int columnsNumber = rsmd.getColumnCount();
              for (int i = 1; i <= columnsNumber; i++) {
                  if(i<=1 && show)
                  {
                      for (int j = 1; j <= rsmd.getColumnCount(); j++) {
                          System.out.print(rsmd.getColumnName(j)+"\t\t"); 
                      }
                      System.out.println("");
                      show=false;
                  }
                  else 
                     System.out.print(" ");
                     String columnValue = resultSet.getString(i);
                     System.out.print(columnValue + "\t\t\t" );
    }
    System.out.println("");         
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    
    public static void main(String[] args) {
        Job_portal cnObj = new Job_portal();
        cnObj.connectDB("company");
    }
    
}
