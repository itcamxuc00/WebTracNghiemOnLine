package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import beans.LopHoc;
import beans.LuotThi;
import beans.MonHoc;
import beans.TaiKhoan;
import beans.ThongTinTK;

public class DBUtils {

	public static TaiKhoan KiemTraDangNhap(Connection conn, String tenTK, String matKhau) throws SQLException {
		String sql = "select TenTK, TenNguoiDung, Quyen from TaiKhoan where TenTK = ? and MatKhau = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, tenTK);
		pstm.setString(2, matKhau);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
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


	public static ThongTinTK LayThongTin(Connection conn, String TenTK) throws SQLException {
		String sql = "select TenNguoiDung,NgaySinh,DiaChi,SDT from TaiKhoan where TenTK = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, TenTK);
		ResultSet rs = pstm.executeQuery();
		ThongTinTK tk = new ThongTinTK();
		if (rs.next()) {
			String name = rs.getString("TenNguoiDung");
			String ngaysinh = rs.getString("NgaySinh");
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

	public static List<LopHoc> LayDSLopHoc(Connection conn) throws SQLException {
		String sql = "exec pr_LayDSlopHoc";
		PreparedStatement pstm = conn.prepareStatement(sql);
		// pstm.setString(1,TenTK);
		ResultSet rs = pstm.executeQuery();
		List<LopHoc> list = new ArrayList<LopHoc>();
		while (rs.next()) {
			String malop = rs.getString("MaLop");
			String tenlop = rs.getString("TenLop");
			Date ngayKetThuc = rs.getDate("NgayKetThuc");
			int soHocSinh = rs.getInt("SoLuong");
			LopHoc lh = new LopHoc();
			lh.setMaLop(malop);
			lh.setTenLop(tenlop);
			lh.setNgayKetThuc(ngayKetThuc);
			lh.setSoHocSinh(soHocSinh);
			list.add(lh);
		}
		return list;
	}

	public static List<LopHoc> LopHocChuaThi(Connection conn, String maDe) throws SQLException {
		String sql = "pr_LopHocChuaThi'" + maDe + "'";
		PreparedStatement pstm = conn.prepareStatement(sql);
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

	public static void ThemLopHoc(Connection conn, String tenLop, String ngayKetThuc)
			throws SQLException, ParseException {
		String maLop = "LH" + Long.toString(System.currentTimeMillis());
		String sql = "insert into LopHoc values(?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, maLop);
		pstm.setString(2, tenLop);
		pstm.setString(3, ngayKetThuc);
		pstm.executeUpdate();
	}

	public static void SuaLopHoc(Connection conn, String maLop, String tenLop, String ngayKetThuc) throws SQLException {
		String sql = "update LopHoc set TenLop=?, NgayKetThuc=? where MaLop=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, tenLop);
		pstm.setString(2, ngayKetThuc);
		pstm.setString(3, maLop);
		pstm.executeUpdate();
	}

	public static void XoaKhoiLop(Connection conn, String TenTK, String MaLop) throws SQLException {
		String sql = "DELETE FROM TV_LopHoc WHERE TV_LopHoc.MaLopHoc = ? and TV_LopHoc.TenTK = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, MaLop);
		pstm.setString(2, TenTK);
		pstm.executeUpdate();
	}

	public static void ThemVaoLop(Connection conn, String maLop, String tenTK) throws SQLException {
		String sql = "Insert into TV_LopHoc values (?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, maLop);
		pstm.setString(2, tenTK);
		pstm.executeUpdate();
	}


	public static String layMaMonHoc(Connection conn, String maDe) throws SQLException {
		String result = null;
		String sql = "select MaMonHoc from DeThi where MaDeThi = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, maDe);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			result = rs.getString("MaMonHoc");
		}
		return result;
	}

	public static LuotThi KiemTraDuocPhepThi(Connection conn, String tenTK, String maDe, String maLop)
			throws SQLException {
		String sql = "pr_KiemTraDuocPhepThi '" + tenTK + "','" + maDe + "','" + maLop + "'";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
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

	public static List<MonHoc> LayMonHoc(Connection conn) throws SQLException {
		String sql = "select * from MonHoc";
		List<MonHoc> list = new ArrayList<>();
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			String maMonHoc = rs.getString("MaMon");
			String tenMonHoc = rs.getString("TenMon");
			MonHoc mh = new MonHoc();
			mh.setMaMonHoc(maMonHoc);
			mh.setTenMonHoc(tenMonHoc);
			list.add(mh);
		}
		return list;
	}

	public static void XoaNDDeThi(Connection conn, String maDe) throws SQLException {
		String sql = "exec pr_XoaHetNoiDungDeThi'" + maDe + "'";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.executeUpdate();
	}

	public static void LuuNDDeThi(Connection conn, String maDe, String MaCauHoi) throws SQLException {
		int maCauHoi = Integer.parseInt(MaCauHoi);
		String sql = "INSERT INTO ND_DeThi VALUES (?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, maCauHoi);
		pstm.setString(2, maDe);
		pstm.executeUpdate();
	}

	public static void XoaLopHoc(Connection conn, String maLop) throws SQLException {
		String sql = "DeLete from LopHoc where MaLop = (?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, maLop);
		pstm.executeUpdate();
	}

	public static void XoaDeThi(Connection conn, String maDe) throws SQLException {
		String sql = "DeLete from DeThi where MaDeThi = (?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, maDe);
		pstm.executeUpdate();
	}

	public static void XoaTaiKhoan(Connection conn, String tenTK) throws SQLException {
		String sql = "DeLete from TaiKhoan where tenTK = (?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, tenTK);
		pstm.executeUpdate();
	}

	public static void ThemHocSinh(Connection conn, ThongTinTK tk) throws SQLException {
		String sql = "INSERT INTO TaiKhoan VALUES (?,?,?,?,?,?,1)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, tk.getTenTK());
		pstm.setString(2, tk.getMatKhau());
		pstm.setString(3, tk.getTenNguoiDung());
		pstm.setString(4, tk.getNgaySinh());
		pstm.setString(5, tk.getDiaChi());
		pstm.setString(6, tk.getSDT());
		pstm.executeUpdate();
	}
}
