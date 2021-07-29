package cn.com.filecount;

public class Coords {
	int x;
	int y;
	public Coords(int x, int y) {
		// TODO Auto-generated constructor stub
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "[行数=" + getX() + ", 列数=" + getY() + "]";
	}
}
