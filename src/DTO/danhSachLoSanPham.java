/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;
import BUS.Find;
import DAO.accessDB;
import GROUP.ThongTinLo;
import com.mysql.cj.protocol.Resultset;
import java.util.*;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;


/**
 *
 * @author Admin
 */
public  class danhSachLoSanPham implements Find{
    public int id_lo;
    public String ten_sp;
    public Date nsx;
    public String khu_vuc;
    public ArrayList<danhSachLoSanPham> list;
    public JTable TimKiem(JTable table) {
        String sql="select id_lo,ten_Sp,hsd,khu_vuc from lo_san_pham join san_pham on lo_san_pham.id_sp=san_pham.id_sp;";
        accessDB.getInstance().open();
        ResultSet rs = accessDB.getInstance().excuteQuery(sql);
        list = new ArrayList<>();
        danhSachLoSanPham tmp;
        try {
            while(rs.next()){
                tmp = new danhSachLoSanPham();
                tmp.id_lo=rs.getInt(1);
                tmp.ten_sp=rs.getString(2);
                tmp.nsx=rs.getDate(3);
                tmp.khu_vuc=rs.getString(4);
                list.add(tmp);
            }

        } catch (Exception e) {
                e.printStackTrace();
        }
    }

}
