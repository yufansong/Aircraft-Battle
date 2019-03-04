package playgame;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

//6th class
//Q5:问题：发射子弹的过程
public class Bullet {
	private int x;
	private int y;
	private int r;
	private Image bulletImg = new ImageIcon("img/fire.png").getImage();
	
	
	
	public void paint(Graphics g){
		g.drawImage(bulletImg, x-r, y-r, null);
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
	


