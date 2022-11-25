package repository;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import model.KhachHang;

public class KhachHangRepository {

    public ArrayList<KhachHang> getAll(){
        ArrayList<KhachHang> listKH = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM KHACHHANG";
            

            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                //  (String maKH, String ten, int tuoi, boolean gioiTinh, String loaiKhachHang)
                String maKh = rs.getString("MAKH");
                String tenKh = rs.getString("TENKH");
                int tuoiKh = rs.getInt("TUOI");
                boolean gioiTinhKh = rs.getBoolean("GIOITINH");
                String loaiKh = rs.getString("LOAIKHACHHANG");

                KhachHang kh = new KhachHang(maKh, tenKh, tuoiKh, gioiTinhKh, loaiKh);
                listKH.add(kh);
            }
        } catch (SQLException e) {
        }

        return listKH;
    }

     public void Insert(KhachHang kh) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO KHACHHANG"
                    + "(MAKH, TENKH,TUOI,GIOITINH,LOAIKHACHHANG)"
                    + "VALUES (?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kh.getMaKH());
            ps.setString(2, kh.getTen());
            ps.setInt(3, kh.getTuoi());
            ps.setBoolean(4, kh.isGioiTinh());
            ps.setString(5, kh.getLoaiKhachHang());
            ps.execute();
            System.out.println("Truy vấn thành công!");
        } catch (SQLException e) {
        }
    }

    public void Update(String ma, KhachHang kh) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "Update KHACHHANG Set TENKH = ?, TUOI = ?,GIOITINH = ?,LOAIKHACHHANG = ? Where MAKH = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kh.getTen());
            ps.setInt(2, kh.getTuoi());
            ps.setBoolean(3, kh.isGioiTinh());
            ps.setString(4, kh.getLoaiKhachHang());
            ps.setString(5, ma);
            ps.execute();
            System.out.println("Truy vấn thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    public void Delete(String makh) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "DELETE FROM KHACHHANG Where MAKH = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, makh);
            ps.execute();
            System.out.println("Truy vấn thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

     public ArrayList<KhachHang> getSearch(int min, int max){
        ArrayList<KhachHang> listKH = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM KHACHHANG WHERE TUOI BETWEEN ? AND ?";
            

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, min);
            ps.setInt(2, max);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                //  (String maKH, String ten, int tuoi, boolean gioiTinh, String loaiKhachHang)
                String maKh = rs.getString("MAKH");
                String tenKh = rs.getString("TENKH");
                int tuoiKh = rs.getInt("TUOI");
                boolean gioiTinhKh = rs.getBoolean("GIOITINH");
                String loaiKh = rs.getString("LOAIKHACHHANG");

                KhachHang kh = new KhachHang(maKh, tenKh, tuoiKh, gioiTinhKh, loaiKh);
                listKH.add(kh);
            }
        } catch (SQLException e) {
        }
        return listKH;
    }
     
      public ArrayList<KhachHang> getKhachVip(){
        ArrayList<KhachHang> listKH = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM KHACHHANG WHERE LOAIKHACHHANG = 'Khach VIP'";
            

            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                //  (String maKH, String ten, int tuoi, boolean gioiTinh, String loaiKhachHang)
                String maKh = rs.getString("MAKH");
                String tenKh = rs.getString("TENKH");
                int tuoiKh = rs.getInt("TUOI");
                boolean gioiTinhKh = rs.getBoolean("GIOITINH");
                String loaiKh = rs.getString("LOAIKHACHHANG");

                KhachHang kh = new KhachHang(maKh, tenKh, tuoiKh, gioiTinhKh, loaiKh);
                listKH.add(kh);
            }
        } catch (SQLException e) {
        }
        return listKH;
    }
}
