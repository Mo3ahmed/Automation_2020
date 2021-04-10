package DataBase_07152020;
/*
 *1 create a connection
 *create statement
 * execute statement
 * close connection
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Example {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

//step 1
        //      Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
//step 2
        Statement stmt = con.createStatement();
//Step 3 execute sql statement
        String sql = "insert into countries values('BD','Bangladesh',7)";
        stmt.executeQuery(sql);
//step 4
        con.close();
        System.out.println("Query added successfully");


    }//end of main method

}//end of class
