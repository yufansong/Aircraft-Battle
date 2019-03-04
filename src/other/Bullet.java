package other;

import java.awt.Graphics;
import java.awt.Image;

public abstract class Bullet {
	protected int x;
	protected int y;
	protected int r;
	protected Image bulletImg;
	protected abstract void initialImage();  
	public void paint(Graphics g ) {
		Decorator a = new Decorator_Non(bulletImg);
		Decorator b = new Decorator_Red(a.getImg());
		g.drawImage(b.getImg(), x-r, y-r, null);
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
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
}
