package dataminingKNN;

public class viTri {
	private int id;
	private double x, y, x0, y0;
	private String loaiVat;
	
	public viTri(int id, double x, double y, double x0, double y0, String loaiVat) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
		this.x0 = x0;
		this.y0 = y0;
		this.loaiVat = loaiVat;
	}
	
	public String getLoaiVat() {
		return loaiVat;
	}

	public double khoangCach() {
			return Math.sqrt(Math.pow((x0 - x),2) + Math.pow((y0-y),2));
	}
	@Override
	public String toString() {
		return this.id + "\t" + this.x + "\t" + this.y + "\t" + this.loaiVat + "\t\t" + khoangCach();
	}
}
