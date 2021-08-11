/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sqlserver;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author PC
 */
public class Connect {
    
    
    private static  String URL = "jdbc:sqlserver://localhost:1433;databaseName=tool";
    private static  String USER = "sa";
    private static  String PASS = "123456";

    public static java.sql.Connection getConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            return con;
    }
}
