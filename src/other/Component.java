package other;

import java.util.ArrayList;

import playgame.Bullet;

public abstract class Component {
	private int x;
	private int y;
	private int r;
	public Component(Bullet bullt) {
		// TODO Auto-generated constructor stub
	}
	public abstract  void run();
	public ArrayList<Bullet> getBullets() {
		return bullets;
	}
	public void setBullets(ArrayList<Bullet> bullets) {
		this.bullets = bullets;
	}
	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
}
