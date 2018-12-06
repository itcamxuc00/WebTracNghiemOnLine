package utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.sql.Date;

import beans.BG_DeThi;
import beans.DeThi;
import beans.LayDeThiRs;
import beans.LopHoc;
import beans.LuotThi;
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
	    	 String tieuDe = rs.getString("TieuDe");
	    	 String maLop = rs.getString("maLop");
	    	 String tenLop = rs.getString("TenLop");
	    	 int thoiLuong = rs.getInt("ThoiLuong");
	    	 Timestamp tGBatDau= rs.getTimestamp("TGBatDau");
	    	 Timestamp tGKetThuc = rs.getTimestamp("TGketThuc");
	    	 BG_DeThi bg= new BG_DeThi();
	    	 bg.setMaDeThi(maDeThi);
	    	 bg.setTieuDe(tieuDe);
	    	 bg.setMaLop(maLop);
	    	 bg.setTenLop(tenLop);
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
	            int maCauHoi = rs.getInt("MaCauHoi");
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
	 
	 
	 public static LuotThi KiemTraDuocPhepThi(Connection conn, String tenTK, String maDe, String maLop) throws SQLException {
		 String sql = "pr_KiemTraDuocPhepThi '" + tenTK +"','"
				 + maDe + "','" + maLop + "'";		 
	       PreparedStatement pstm = conn.prepareStatement(sql); 
	       ResultSet rs = pstm.executeQuery();
	       if(rs.next())
	       {
	    	   LuotThi lt = new LuotThi();
	    	   lt.setMaDe(maDe);
	    	   lt.setMaLop(maLop);
	    	   String tieuDe = rs.getString("TieuDe");
	    	   int thoiLuong = rs.getInt("ThoiLuong");
	    	   Timestamp batDau = rs.getTimestamp("BatDau");
	    	   lt.setTieuDe(tieuDe);
	    	   lt.setThoiLuong(thoiLuong);
	    	   lt.setBatDau(batDau);
	    	   return lt;
	       }
		 return null;
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
	 
	 
	 private static List<LayDeThiRs> TaoDeThi(Connection conn,int capDo, int soLuong, String maMonHoc) throws SQLException {
		 if(soLuong>0)
		 {
			 List<LayDeThiRs> rsList = new ArrayList<>();
			 Random rd = new Random();
			 String sql = "select count(*) as SoLuong from CauHoi where CapDo = ? and MonHoc = ?";
			 PreparedStatement pstm = conn.prepareStatement(sql); 
			 pstm.setInt(1,capDo);
			 pstm.setString(2,maMonHoc);
			 ResultSet rs = pstm.executeQuery();
			 if(rs.next())
			 {
				 int soLuongSanCo = rs.getInt("SoLuong");
				 if(soLuongSanCo<soLuong)
				 {
					if(capDo==1) new ArithmeticException("Số câu hỏi dễ bạn chọn lớn hơn số lương trong ngân hàng");
					else if (capDo==2) new ArithmeticException("Số câu hỏi trung bình bạn chọn lớn hơn số lương trong ngân hàng");
					else if(capDo==3) new ArithmeticException("Số câu hỏi khó bạn chọn lớn hơn số lương trong ngân hàng");
				}
				 else{
					 sql = "select MaCauHoi,NoiDung,DapAnA,DapAnB,DapAnC,DapAnD,DapAnDung from CauHoi where CapDo = ? and CauHoi.MonHoc = ?";
					 pstm = conn.prepareStatement(sql); 
					 pstm.setInt(1,capDo);
					 pstm.setString(2,maMonHoc);
					 List<LayDeThiRs> tmpList = new ArrayList<>();
					 while(rs.next())
					 {
						 int maCauHoi = rs.getInt("MâCuHoi");
						 String noiDung = rs.getString("NoiDung");
						 String dapAnA = rs.getString("DapAnA");
						 String dapAnB = rs.getString("DapAnB");
						 String dapAnC = rs.getString("DapAnC");
						 String dapAnD = rs.getString("DapAnD");
						 String dapAnDug = rs.getString("DapAnDung");
						 LayDeThiRs ch = new LayDeThiRs();
						 ch.setMaCauHoi(maCauHoi);
						 ch.setNoiDung(noiDung);
						 ch.setDapAnA(dapAnA);
						 ch.setDapAnB(dapAnB);
						 ch.setDapAnC(dapAnC);
						 ch.setDapAnD(dapAnD);
						 ch.setDapAnD(dapAnDug);
						 tmpList.add(ch);
					 }
					 int i;
					 while(rsList.size()<soLuong)
					 {
						 i = rd.nextInt(tmpList.size()); 
						 rsList.add(tmpList.get(i));
						 tmpList.remove(i);
					 }
				 }
			 }
			 return rsList;
		 }
		 return null;
	 }
	 
	 public static List<LayDeThiRs> TaoDeThi(Connection conn, String maMonHoc, int soCauDe, int soCauTb, int soCauKho) throws SQLException {
		 List<LayDeThiRs> rsList = new ArrayList<>();
		 rsList.addAll(TaoDeThi(conn, 1, soCauDe, maMonHoc));
		 rsList.addAll(TaoDeThi(conn, 2, soCauTb, maMonHoc));
		 rsList.addAll(TaoDeThi(conn, 3, soCauKho, maMonHoc));
		 return rsList;
	 }
	 
	 public static List<DeThi> LayDSDeThi(Connection conn) throws SQLException {
		 String sql = "select * from DeThi";
		 List<DeThi> list = new ArrayList<>();
		 PreparedStatement pstm = conn.prepareStatement(sql); 
		 ResultSet rs = pstm.executeQuery();
		 while(rs.next())
		 {
			 String maDeThi = rs.getString("MaDeThi");
			 String maMonHoc = rs.getString("maMonHoc");
			 int soCauDe = rs.getInt("SoCauDe");
			 int soCauKho = rs.getInt("SoCauKho");
			 int soCauTrungBinh = rs.getInt("SoCauTrungBinh");
			 DeThi dt = new DeThi();
			 dt.setMaDeThi(maDeThi);
			 dt.setMaMonHoc(maMonHoc);
			 dt.setSoCauDe(soCauDe);
			 dt.setSoCauKho(soCauKho);
			 dt.setSoCauTrungBinh(soCauTrungBinh);
			 list.add(dt);
		 }
		 return null;
	 }
}	 
	 
