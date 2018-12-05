package utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import beans.BG_DeThi;
import beans.LayDeThiRs;
import beans.LopHoc;
import beans.TaiKhoan;
import beans.ThongTinTK;


public class DBUtils {
	
	public static TaiKhoan KiemTraDangNhap(Connection conn, String tenTK, String matKhau) throws SQLException
	{
		String sql = "select TenTK, TenNguoiDung, Quyen from TaiKhoan where TenTK = ? and MatKhau = ?";
		PreparedStatement pstm = conn.prepareStatement(sql); 
	    pstm.setString(1,tenTK);
	    pstm.setString(2,matKhau);
	    ResultSet rs = pstm.executeQuery();
	    if(rs.next())
	    {
	    	TaiKhoan tk = new TaiKhoan();
	    	tk.setTenTK(tenTK);
	    	String tenNguoiDung = rs.getString("TenNguoiDung");
	    	int quyen = rs.getInt("Quyen");
	    	tk.setTenNguoiDung(tenNguoiDung);
	    	tk.setQuyen(quyen);
	    	return tk;
	    }
		return null;
	}
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
	 
	 public static ThongTinTK LayThongTin(Connection conn, String TenTK) throws SQLException{
	        String sql = "select TenNguoiDung,NgaySinh,DiaChi,SDT from TaiKhoan where TenTK = ?";
	        PreparedStatement pstm = conn.prepareStatement(sql); 
	        pstm.setString(1, TenTK);
	        ResultSet rs = pstm.executeQuery();
	        ThongTinTK tk = new ThongTinTK();
	        if (rs.next()) {
	            String name = rs.getString("TenNguoiDung");
	            Date ngaysinh = rs.getDate("NgaySinh");
	            String diachi = rs.getString("DiaChi");
	            String sdt = rs.getString("SDT");
	            tk.setTenTK(TenTK);
	            tk.setTenNguoiDung(name);
	            tk.setNgaySinh(ngaysinh);
	            tk.setDiaChi(diachi);
	            tk.setSDT(sdt);
	        }
	        return tk;
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
	 public static List<BG_DeThi> LayDSDeThi(Connection conn, String tenTK) throws SQLException{
		 List<BG_DeThi> list = new ArrayList<>();
		 String sql = "execute pr_LayDsDeThi'" + tenTK + "'";
	     PreparedStatement pstm = conn.prepareStatement(sql); 
	     ResultSet rs = pstm.executeQuery();
	     while(rs.next())
	     {
	    	 String maDeThi = rs.getString("MaDeThi");
	    	 String maLop = rs.getString("maLop");
	    	 int thoiLuong = rs.getInt("ThoiLuong");
	    	 Date tGBatDau= rs.getDate("TGBatDau");
	    	 Date tGKetThuc = rs.getDate("TGketThuc");
	    	 BG_DeThi bg= new BG_DeThi();
	    	 bg.setMaDeThi(maDeThi);
	    	 bg.setMaLop(maLop);
	    	 bg.setThoiLuong(thoiLuong);
	    	 bg.setTGBatDau(tGBatDau);
	    	 bg.setTGKetThuc(tGKetThuc);
	    	 list.add(bg);
	     }
		 return list;
	 }
	 public static List<LayDeThiRs> LayDeThi(Connection conn, String MaDe) throws SQLException {
		 	String sql = "execute pr_LayDeThi '" + MaDe +"'";
	       PreparedStatement pstm = conn.prepareStatement(sql); 
	       //pstm.setString(1, MaDe);
	       ResultSet rs = pstm.executeQuery();
	       List<LayDeThiRs> list = new ArrayList<LayDeThiRs>();
	       while (rs.next()) {
	            String maCauHoi = rs.getString("MaCauHoi");
	            String noiDung = rs.getString("NoiDung");
	            String dapAnA = rs.getString("DapAnA");
	            String dapAnB = rs.getString("DapAnB");
	            String dapAnC = rs.getString("DapAnC");
	            String dapAnD = rs.getString("DapAnD");
	            String dapAnDung = rs.getString("DapAnDung");
	            LayDeThiRs ch = new LayDeThiRs();
	            ch.setMaCauHoi(maCauHoi);
	            ch.setNoiDung(noiDung);
	            ch.setDapAnA(dapAnA);
	            ch.setDapAnB(dapAnB);
	            ch.setDapAnC(dapAnC);
	            ch.setDapAnD(dapAnD);
	            ch.setDapAnDung(dapAnDung);
	            list.add(ch);
	        }	        
	        return list;
	    }
	 
	 public static String LayDapAn(Connection conn, String MaDe) throws SQLException {
		 String sql = "execute pr_LayDapAn '" + MaDe +"'";
		 PreparedStatement pstm = conn.prepareStatement(sql); 
		 ResultSet rs = pstm.executeQuery();
		 String dapAn = "";
		 while(rs.next())
		 {
			 dapAn = rs.getString("DapAn");
		 }
		 return dapAn;
	 }	 
}
