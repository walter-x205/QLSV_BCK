package finish_project;

public class MonHoc {
	private String maMH, tenMH;
	private double heSo;

	public MonHoc(String maMH, String tenMH, double heSo) {
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.heSo = heSo;
	}

	public String getMaMH() {
		return maMH;
	}

	public String getTenMH() {
		return tenMH;
	}

	public double getHeSo() {
		return heSo;
	}
	
	public void inMH() {
		System.out.format("┃ %5s ┃ %30s ┃ %6s ┃\n",maMH,tenMH,heSo);
	}
	
}
