package finish_project;

public class Diem {
	private String SV, MH;
	private double diem;
	public Diem(String SV, String MH, double diem) {
		this.SV = SV;
		this.MH = MH;
		this.diem = diem;
	}
	public String getSV() {
		return SV;
	}
	public String getMH() {
		return MH;
	}
	public double getDiem() {
		return diem;
	}
	
}
