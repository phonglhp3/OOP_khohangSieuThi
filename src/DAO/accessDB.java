/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DAO;
import com.mysql.cj.protocol.Resultset;
import java.sql.*;
public class accessDB{ 
    private static String url = "jdbc:mysql://127.0.0.1:3306/sieuthi";
    private static String user = "root";
    private static String pass = "31032004";
    Connection conn = null;
    private static accessDB intance;
 
    /**
     * main
     * 
     * @author viettuts.vn
     * @param args
     */
    public static accessDB getInstance(){
        if (intance == null) {
            intance = new accessDB();
        }
        return intance;
    }
    public Connection getConn(){
        
        return conn;
    }
    public void displayError(SQLException e){
        System.out.println("Error Message: "+e.getMessage());
        System.out.println("SQL State: "+e.getSQLState());
        System.out.println("Error Code: "+e.getErrorCode());
    }
    public void open(){
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("select * from tai_khoan");
//            while (rs.next()) {
//                System.out.println(rs.getInt(1) + "  " + rs.getString(2) 
//                        + "  " + rs.getString(5));
//            }
            System.out.println("ket noi thanh cong");
//            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void close(){
        try{
            if(conn!=null){
                conn.close();
                conn=null;
                System.out.println("da ngat ket noi DB");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public ResultSet excuteQuery(String sql){
        ResultSet rs = null;
        try{
            Statement stm = conn.createStatement();
//            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery(sql);
        }
        catch (SQLException e){
            displayError(e);
        }
        return rs;
    }
    public static void main(String args[]) {
        accessDB test = new accessDB();
        test.open();
        test.close();
    }
 
 
    /**
     * create connection 
     * 
     * @author viettuts.vn
     * @param dbURL: database's url
     * @param userName: username is used to login
     * @param password: password is used to login
     * @return connection
     */
//    public static Connection getConnection(String dbURL, String userName, 
//            String password) {
//        Connection conn = null;
//        try {System.out.println("connect successfully!");
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(dbURL, userName, password);
//            System.out.println("connect successfully!");
//        } catch (Exception ex) {
//            System.out.println("connect failure!");
//            ex.printStackTrace();
//        }
//        return conn;
//    }
}