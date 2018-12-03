package utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import beans.LopHoc;
import beans.TaiKhoan;
import beans.ThongTinTK;


public class DBUtils {
	
	 public static List<ThongTinTK> LayDSNguoiDung(Connection conn) throws SQLException {
	        String sql = "execute pr_LayDanhSachHocSinh"; 
	        PreparedStatement pstm = conn.prepareStatement(sql); 
	        ResultSet rs = pstm.executeQuery();
	        List<ThongTinTK> list = new ArrayList<ThongTinTK>();
	        while (rs.next()) {
	            String tentk = rs.getString("TenTK");
	            String name = rs.getString("TenNguoiDung");
	            Date ngaysinh = rs.getDate("NgaySinh");
	            String diachi = rs.getString("DiaChi");
	            String sdt = rs.getString("SDT");
	            int soluonglop = rs.getInt("SoLuong");
	            ThongTinTK tk = new ThongTinTK();
	            tk.setTenTK(tentk);
	            tk.setTenNguoiDung(name);
	            tk.setNgaySinh(ngaysinh);
	            tk.setDiaChi(diachi);
	            tk.setSDT(sdt);
	            tk.setSoLuongLopHoc(soluonglop);
	            list.add(tk);
	        }
	        return list;
	    }
	 
	 public static List<LopHoc> LayDSLopHoc(Connection conn, String TenTK) throws SQLException {
		 	String sql = "execute pr_DSLopHoc'" + TenTK + "'";
	        PreparedStatement pstm = conn.prepareStatement(sql); 
	       // pstm.setString(1,TenTK);
	        ResultSet rs = pstm.executeQuery();
	        List<LopHoc> list = new ArrayList<LopHoc>();
	        while (rs.next()) {
	            String malop = rs.getString("MaLop");
	            String tenlop = rs.getString("TenLop");
	            LopHoc lh = new LopHoc();
	            lh.setMaLop(malop);
	            lh.setTenLop(tenlop);    
	            list.add(lh);
	        }	        
	        return list;
	    }
	 
	 public static void XoaKhoiLop(Connection conn, String TenTK, String MaLop) throws SQLException {
		 	String sql = "DELETE FROM TV_LopHoc WHERE TV_LopHoc.MaLopHoc = ? and TV_LopHoc.TenTK = ?";
	        PreparedStatement pstm = conn.prepareStatement(sql); 
	       pstm.setString(1,MaLop);
	       pstm.setString(2,TenTK);
	       pstm.executeUpdate();
	    }
    /*
    public static Product findProduct(Connection conn, String code) throws SQLException {
        String sql = "Select a.Code, a.Name, a.Price from Product a where a.Code=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, code);
 
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
            String name = rs.getString("Name");
            float price = rs.getFloat("Price");
            Product product = new Product(code, name, price);
            return product;
        }
        return null;
    }
 
    public static void updateProduct(Connection conn, Product product) throws SQLException {
        String sql = "Update Product set Name =?, Price=? where Code=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, product.getName());
        pstm.setFloat(2, product.getPrice());
        pstm.setString(3, product.getCode());
        pstm.executeUpdate();
    }
 
    public static void insertProduct(Connection conn, Product product) throws SQLException {
        String sql = "Insert into Product(Code, Name,Price) values (?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, product.getCode());
        pstm.setString(2, product.getName());
        pstm.setFloat(3, product.getPrice());
 
        pstm.executeUpdate();
    }
 
    public static void deleteProduct(Connection conn, String code) throws SQLException {
        String sql = "Delete From Product where Code= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, code);
        pstm.executeUpdate();
    }*/
}
