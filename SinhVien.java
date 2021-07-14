package finish_project;

public class SinhVien {
	private String maSV, hoDem, ten, ngaySinh, gioiTinh;

	public SinhVien(String maSV, String hoDem, String ten, String ngaySinh, String gioiTinh) {
		this.maSV = maSV;
		this.hoDem = hoDem;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
	}

	public String getMaSV() {
		return maSV;
	}

	public String getHoDem() {
		return hoDem;
	}

	public String getTen() {
		return ten;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}
	
	public void inSV() {
		System.out.format("┃%10s ┃ %-25s ┃ %-8s ┃ %12s ┃ %8s ┃ \n",maSV,hoDem,ten,ngaySinh,gioiTinh);
	}
	
}
