package other;

import java.awt.Graphics;
import java.awt.Image;
public abstract class Enemy {
	protected int x;
	protected int y;
	protected int r;
	protected int speed;//ËÙ¶È
	protected Image epImg =null;
	protected int epNum;
	
	public abstract void Initial();
	public abstract void changeImg();
	public void paint(Graphics g){
		g.drawImage(epImg, x-r, y-r, null);
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
