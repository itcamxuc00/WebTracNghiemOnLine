package beans;

import java.sql.Date;


public class BG_DeThi {
	private  String MaDeThi;
	private  String MaLop;
	private  int ThoiLuong;
	private Date TGKetThuc;
	private Date TGBatDau;
	
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
	public Date getTGKetThuc() {
		return TGKetThuc;
	}
	public void setTGKetThuc(Date tGKetThuc) {
		TGKetThuc = tGKetThuc;
	}
	public Date getTGBatDau() {
		return TGBatDau;
	}
	public void setTGBatDau(Date tGBatDau) {
		TGBatDau = tGBatDau;
	}
}
