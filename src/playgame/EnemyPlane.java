package playgame;

import java.awt.Graphics;
import java.awt.Image;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;

//7th class
//Q6:问题：敌机下落功能的实现
public class EnemyPlane {
	private int x;
	private int y;
	private int r;
	private int speed;//速度
	private Image epImg =null;
	private int epNum;
	
	public EnemyPlane(){
		epNum = (int)(Math.random()*15)+1;
		DecimalFormat df = new DecimalFormat("00");
		String ep= df.format(epNum);
		epImg = new ImageIcon("img/ep"+ep+".png").getImage();		
	}
	
	public void changeImg(){
		epNum = (int)(Math.random()*15)+1;
		DecimalFormat df = new DecimalFormat("00");
		String ep= df.format(epNum);
		epImg = new ImageIcon("img/ep"+ep+".png").getImage();	
	}
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
