package playgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

//5th class
//Q4:问题： 战机移动功能的实现过程?
public class Hero {
	private int x;
	private int y;
	private int r;
	private int allBlood;
	private int Blood;
    private int score;
	private Image heroImg = new ImageIcon("img/hero2.png").getImage();
	
	private static Hero hero = new Hero();
	
	//classs members added bu liu
	//alt+shift+s
	private int level = 1;
	private HeroState currentState = new Hero1stState(this);
		
	Hero(){
//		hero1stState = new Hero1stState(this);
//		hero2edState = new Hero2edState(this);		
//		currentState = hero1stState;
	}
	//单件模式
	public static Hero getHero(){
		return hero;
	}
	
	//备忘录
	public Memento createMemento(){
		Memento mem = new Memento();
		mem.setScore(hero.getScore());
		mem.setLevel(hero.getLevel());
		return mem;
	}
	
	public void restroeFormToMemento(Memento mem){
		level = mem.getLevel();
		score = mem.getScore();
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public HeroState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(HeroState currentState) {
		this.currentState = currentState;
	}

	public void paint(Graphics g){

				g.drawImage(heroImg, x-r, y-r, null);

				g.setColor(Color.orange);
				g.fillRect(20, 20, allBlood, 30);
		
				g.setColor(Color.red);
				g.fillRect(20, 20, Blood, 30);

				g.setFont(new Font("",Font.BOLD,30));
				g.drawString("分数： "+score, 900, 50);
								
				g.drawString("level： "+this.getLevel(), 1200, 50);
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

	public int getAllBlood() {
		return allBlood;
	}

	public void setAllBlood(int allBlood) {
		this.allBlood = allBlood;
	}

	public int getBlood() {
		return Blood;
	}

	public void setBlood(int blood) {
		Blood = blood;
	}

	public int getScore() {
		return score;
		
	}

	public void setScore(int score) {
		this.score = score;
		currentState.check();
			}
	}
