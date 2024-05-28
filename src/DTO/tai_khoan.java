/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import DAO.accessDB;
import javax.naming.spi.DirStateFactory;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class tai_khoan {
    private int id_tk;
    private String user;
    private String pass;
    private int loai_tk;
    private int id_nv;
    public tai_khoan(int id_tk, String user, String pass, int loai_tk, int id_nv){
        this.id_tk=id_tk;
        this.user=user;
        this.pass=pass;
        this.loai_tk=loai_tk;
        this.id_nv=id_nv;
    }
    public tai_khoan(){
        
    }
    public static boolean CheckAcc(String user, String pass){
//        String query = "SELECT * FROM tai_khoan WHERE ten_tai_khoan='"+user+"' and mat_khau = '"+pass+"'";   gggg
        String query = "SELECT * FROM tai_khoan WHERE Ten_TK='"+user+"' and Mat_Khau = '"+pass+"'";
        try{
            accessDB.getInstance().open();
            ResultSet rs = accessDB.getInstance().excuteQuery(query);
            if(rs.next()){
                return true;
            }
        }
        catch (SQLException e){
            accessDB.getInstance().displayError(e);
        }
        return false;
    }
    public static int getLoai_TK(String user, String pass){
        String query = "SELECT * FROM tai_khoan WHERE Ten_TK='"+user+"' and Mat_Khau = '"+pass+"'";
        try{
            ResultSet rs = accessDB.getInstance().excuteQuery(query);
            if (rs.next()) {
                return rs.getInt(5);
            }
        }
        catch (SQLException e){
            accessDB.getInstance().displayError(e);
        }
        return 0;
    }
    public static int getID_NV(String user, String pass){
        String query = "SELECT * FROM tai_khoan WHERE Ten_TK='"+user+"' and Mat_Khau = '"+pass+"'";
        try{
//            accessDB.getInstance().open();
            ResultSet rs = accessDB.getInstance().excuteQuery(query);
            if (rs.next()) {
                return rs.getInt(4);
            }
        }
        catch (SQLException e){
            accessDB.getInstance().displayError(e);
        }
        return 0;
    }
}
