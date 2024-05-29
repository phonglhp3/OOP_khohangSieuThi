/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package traul;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author heheh
 */
public class Database_Connection {

    Connection conn = null;
    public static String url = "jdbc:mysql://localhost:3306/sieuthi2.0";
    public static String user = "root";
    public static String password = "123456";
    private static Database_Connection instance;

    public static Connection getJDBCConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database_Connection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Database_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Database_Connection getInstance() {
        if (instance == null) {
            instance = new Database_Connection();
        }
        return instance;
    }

    public Connection getConn() {
        return conn;
    }

    public void open() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            System.out.println("Kết Nối Thành Công");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int executeUpdate(String sql) {
        int result = 0;
        try {
            Statement stm = conn.createStatement();
            result = stm.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        try {
            Statement stm = conn.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void close() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Kết Nối Đã Đóng");
            } catch (SQLException ex) {
                Logger.getLogger(Database_Connection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
