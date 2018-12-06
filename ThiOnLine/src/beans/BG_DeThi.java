package beans;

import java.sql.Timestamp;


public class BG_DeThi {
	private  String MaDeThi;
	private String TieuDe;
	private  String MaLop;
	private String TenLop;
	private  int ThoiLuong;
	private Timestamp TGKetThuc;
	private Timestamp TGBatDau;
	
	public String getMaDeThi() {
		return MaDeThi;
	}
	public void setMaDeThi(String maDeThi) {
		MaDeThi = maDeThi;
	}
	public String getMaLop() {
		return MaLop;
	}
	public void setMaLop(String maLop) {
		MaLop = maLop;
	}
	public int getThoiLuong() {
		return ThoiLuong;
	}
	public void setThoiLuong(int thoiLuong) {
		ThoiLuong = thoiLuong;
	}
	public String getTenLop() {
		return TenLop;
	}
	public void setTenLop(String tenLop) {
		TenLop = tenLop;
	}
	public String getTieuDe() {
		return TieuDe;
	}
	public void setTieuDe(String tieuDe) {
		TieuDe = tieuDe;
	}
	public Timestamp getTGKetThuc() {
		return TGKetThuc;
	}
	public void setTGKetThuc(Timestamp tGKetThuc) {
		TGKetThuc = tGKetThuc;
	}
	public Timestamp getTGBatDau() {
		return TGBatDau;
	}
	public void setTGBatDau(Timestamp tGBatDau) {
		TGBatDau = tGBatDau;
	}
}
