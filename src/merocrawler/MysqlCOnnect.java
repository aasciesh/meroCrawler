/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package merocrawler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author asish
 */
public class MysqlCOnnect {

    String jdbcUrl = "jdbc:mysql://localhost:3306/mysql";
    String usrName = "root";
    String pswrd = "beltttar1";

    public static ArrayList<CrawlerBaseObj> getBaseList() {
        Connection conn = null;
        Statement stmt = null;
        ArrayList<CrawlerBaseObj> myList = new ArrayList<CrawlerBaseObj>();
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/merohub", "root", "Bha+As-5r");

            //STEP 4: Execute a query

            stmt = conn.createStatement();
            String sql;
            sql = "SELECT baseUrl, publisherId, baseType FROM crawlerBase";
            ResultSet rs = stmt.executeQuery(sql);


            //STEP 5: Extract data from result set
            while (rs.next()) {
                CrawlerBaseObj crawlerBase = new CrawlerBaseObj();
                //Retrieve by column name
                crawlerBase.setURL(rs.getString("baseUrl"));
                crawlerBase.setPublisherId(rs.getInt("publisherId"));
                crawlerBase.setSourceType(rs.getString("baseType"));
//         int id  = rs.getInt("id");
//         int age = rs.getInt("age");
//         String first = rs.getString("first");
//         String last = rs.getString("last");
                myList.add(crawlerBase);

            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();

        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {

                se.printStackTrace();
            }//end finally try
        }//end try
        return myList;
    }

    public static void main(String args[]) {
    }
}
