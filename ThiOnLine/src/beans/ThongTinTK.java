package beans;

import java.sql.Date;

//class này sử dụng cho proc LayDanhSachHocSinh
//Không dùng produce thì có lẻ không cần cái này
//chưa nghĩ ra cách tốt hơn

public class ThongTinTK {
	private String TenTK;
	private String MatKhau;
	private String TenNguoiDung;
	private Date NgaySinh;
	private int SoLuongLopHoc;
	private String DiaChi;
	private String SDT;
	
	public String getTenTK() {
		return TenTK;
	}
	public void setTenTK(String tenTK) {
		TenTK = tenTK;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	public String getTenNguoiDung() {
		return TenNguoiDung;
	}
	public void setTenNguoiDung(String tenNguoiDung) {
		TenNguoiDung = tenNguoiDung;
	}
	public Date getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public int getSoLuongLopHoc() {
		return SoLuongLopHoc;
	}
	public void setSoLuongLopHoc(int soLuongLopHoc) {
		SoLuongLopHoc = soLuongLopHoc;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	
}
