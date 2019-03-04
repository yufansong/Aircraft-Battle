package playgame;
// import java.awt.*;
// import java.io.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class MyJPanel extends JPanel implements Runnable,MouseMotionListener {
	//private static final long serialVersionUID = 5179918663894372869L;
	private Hero hero = new Hero();
	private int bgX;
	private int bgY;
	
	private int by;
	private int bby;
	//敌机集合
	private ArrayList<EnemyPlane> enemyPlanes = new ArrayList<EnemyPlane>();
	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	private ArrayList<Bullet> bullets1 = new ArrayList<Bullet>();
	private ArrayList<Bullet> bullets2 = new ArrayList<Bullet>();
	private int epNum = 10;//敌机数量
	private Image bgImg = null;
	private Image goImg = new ImageIcon("img/GameOver.jpg").getImage();
	// database 
	private DB_Operater db_Operater;
	private String name;
	private int curTime, lastTime, grade;

	public MyJPanel(Dimension dim, int grade, String name) {
	
		lastTime = (int)System.currentTimeMillis();
		// database
		this.name = name;
		this.grade = grade;
		db_Operater = new DB_Operater();
		
		//初始化战机
		hero.setR(57);
		hero.setX((bgX - hero.getR() * 2) / 2);
		hero.setY(bgY - 3 * hero.getR());
		hero.setAllBlood(150);
		hero.setBlood(150);
		db_Operater.update(name, "150", "blood");
		hero.setScore(0);
		
		//初始化敌机
		for (int i = 0; i < epNum; i++) {
			EnemyPlane ep = new EnemyPlane();
			ep.setX((int) (Math.random() * bgX));
			ep.setY((int) (Math.random() * bgY));
			ep.setR(25);
			ep.setSpeed((int) (Math.random() * 5) + 1);
			enemyPlanes.add(ep);
		}
		
		//初始化背景 bgNum=hero.getLevel()5%+1;
	//	int bgNum = (int) (Math.random() * 5) + 1;
	//	bgImg = new ImageIcon("img/bg2.jpg").getImage();
	//	bgImg = new ImageIcon("img/bg" + bgNum + ".jpg").getImage();
		//System.out.println("img/bg" + bgNum + ".jpg");  //  img/bg3.jpg                
		//设置鼠标监听
		this.addMouseMotionListener(this);
		//初始化屏幕的宽和高
				bgX = dim.width;
				bgY = dim.height;
				by = 0;
				bby = by-bgY;

	}
	
	
	public void initBg(){
		int bgNum=hero.getLevel()%5+1;
		bgImg = new ImageIcon("img/bg" + bgNum + ".jpg").getImage();
	}
	public void move(){
		by +=3;
		bby +=3;
		if(by>bgY){
			by = bby-bgY;
		}
		if(bby>bgY){
			bby = by-bgY;
		}
	}
	
	
	public void paint(Graphics g) {
		super.paint(g);
		
		//设置背景色
//		this.setBackground(Color.BLACK);
		this.initBg();
		g.drawImage(bgImg, 0, by,bgX, bgY, null);
		g.drawImage(bgImg, 0, bby,bgX, bgY, null);
		move();
		//绘制敌机
		for (int i = 0; i < enemyPlanes.size(); i++) {
			enemyPlanes.get(i).paint(g);
		}		
		//绘制子弹
		for (int i = 0; i < bullets.size(); i++) {
			Bullet bu = bullets.get(i);
			bu.paint(g);
		}
		for (int i = 0; i < bullets1.size(); i++) {
			Bullet bu1 = bullets1.get(i);
			bu1.paint(g);
		}
		for (int i = 0; i < bullets2.size(); i++) {
			Bullet bu2 = bullets2.get(i);
			bu2.paint(g);
		}
		//绘制战机
		hero.paint(g);
		
		//结束界面
		if (hero.getBlood() <= 0) {
			// update the data  
			int grade = hero.getScore();
			int level = hero.getScore()/200; 
			
			curTime = (int)System.currentTimeMillis();//单位毫秒
			int time = (curTime - lastTime)/1000 + db_Operater.get(name, "time");
			int temp = Math.max(grade, db_Operater.get(name, "maxgrade"));
			System.out.println("test:!!!"+temp);
			db_Operater.update(name, level, grade);
			db_Operater.update(name, time+"", "time");
			db_Operater.update(name, temp+"", "maxgrade");
			System.out.println("tetttt:"+db_Operater.get(name, "maxgrade"));
			/*g.setFont(new Font("宋体", Font.BOLD, 50));
			g.drawString("GAME OVER", (bgX - 450) / 2, (bgY - 50) / 2);*/
			g.drawImage(goImg, 0, 0, bgX, bgY, null);
			g.setFont(new Font("宋体", Font.BOLD, 20));
			
			int maxgrade = db_Operater.get(name, "maxgrade");  // get the maxgrade form the db
			
			g.drawString("最高分：" + maxgrade, (bgX - 100) / 2, bgY - 280);
			
			if(grade<maxgrade){
				int i = 1;
				i+=i;
				g.drawString("分数为："+grade+"   名次为:"+i,(bgX - 100) / 2, bgY - 240);
			}else{
				grade = maxgrade;
				g.drawString("分数为："+grade+"   名次为:"+1,(bgX - 100) / 2, bgY - 200);
			}
		}
	}

	@Override
	public void run() {
		int count = 0;
		while (true) {
			
			if (hero.getBlood() > 0) {
				//初始化子弹
				if (count % 10 == 0) {
					initBullet();
					initBullet1();
					initBullet2();
				}
				count++;
				
				//让敌机下落
				for (int i = 0; i < enemyPlanes.size(); i++) {
					EnemyPlane ep = enemyPlanes.get(i);
					if (ep.getY() >= bgY) {
						ep.setX((int) (Math.random() * bgX));
						ep.setY(0 - ep.getR());
						ep.setSpeed((int) (Math.random() * 5) + 1+hero.getLevel());
						ep.changeImg();
						enemyPlanes.remove(i);
						enemyPlanes.add(ep);
					} else {
						ep.setY(ep.getY() + ep.getSpeed());
					}
					//判断敌机是否与战机相撞
					boolean b = isHeat(ep, hero);
					if (b == true) {
						ep.setX((int) (Math.random() * bgX));
						ep.setY(0 - ep.getR());
						ep.setSpeed((int) (Math.random() * 5) + 1);
						ep.changeImg();
						enemyPlanes.remove(i);
						enemyPlanes.add(ep);
						int curBlood = db_Operater.get(name, "blood");
						hero.setBlood(curBlood-hero.getAllBlood()/5);
						db_Operater.update(name, hero.getBlood()+"", "blood");
						
					}
				}
				//敌机左出现
				for (int m = 0; m < 2; m++) {
					EnemyPlane ep1 = enemyPlanes.get(m);
					if (ep1.getX() >= bgX) {
						ep1.setY(5);
						ep1.setX(0 - ep1.getR());
						ep1.setSpeed((int) (Math.random() * 5));
						ep1.changeImg();
						enemyPlanes.remove(m);
						enemyPlanes.add(ep1);
					} else {
						ep1.setX(ep1.getY() + ep1.getSpeed());
						//判断敌机是否与战机相撞
						boolean b = isHeat(ep1, hero);
						if (b == true) {
							ep1.setX((int) (Math.random() * bgX));
							ep1.setY(0 - ep1.getR());
							ep1.setSpeed((int) (Math.random() * 5) + 1);
							ep1.changeImg();
							enemyPlanes.remove(m);
							enemyPlanes.add(ep1);
							int curBlood = db_Operater.get(name, "blood");
							hero.setBlood(curBlood-hero.getAllBlood()/5);
							db_Operater.update(name, hero.getBlood()+"", "blood");
							
						}
					}
				//让子弹飞
				for (int i = 0; i < bullets.size(); i++) {
					Bullet bu = bullets.get(i);
					if (bu.getY() <= 0 - bu.getR()) {
						bullets.remove(i);
					} else {
						bu.setY(bu.getY() - 10);
					}
					for (int j = 0; j < enemyPlanes.size(); j++) {
						EnemyPlane ep = enemyPlanes.get(j);
						boolean b = isHeat(bu,ep);
						//判断子弹与敌机是否相撞
						if (b == true) {
							bullets.remove(i);
							ep.setX((int) (Math.random() * bgX));
							ep.setY(0 - ep.getR());
							ep.setSpeed((int) (Math.random() * 5) + 5);
							ep.changeImg();
							enemyPlanes.remove(j);
							enemyPlanes.add(ep);
							hero.setScore(hero.getScore() + 10);
						}
					}
				}
				//左发射
//				for (int i = 0; i < bullets1.size(); i++) {
//					Bullet bu1 = bullets1.get(i);
//					if (bu1.getY() <= 0 - bu1.getR()) {
//						bullets1.remove(i);
//					} else {
//						bu1.setY(bu1.getY() - 10);
//						bu1.setX(bu1.getX()+5);
//					}
//					for (int j = 0; j < enemyPlanes.size(); j++) {
//						EnemyPlane ep = enemyPlanes.get(j);
//						boolean b = isHeat(bu1,ep);
//						//判断子弹与敌机是否相撞
//						if (b == true) {
//							bullets1.remove(i);
//							ep.setX((int) (Math.random() * bgX));
//							ep.setY(0 - ep.getR());
//							ep.setSpeed((int) (Math.random() * 5) + 5);
//							ep.changeImg();
//							enemyPlanes.remove(j);
//							enemyPlanes.add(ep);
//							hero.setScore(hero.getScore() + 10);
//						}
//					}
//				}
				//右发射
//				for (int i = 0; i < bullets2.size(); i++) {
//					Bullet bu2 = bullets2.get(i);
//					if (bu2.getY() <= 0 - bu2.getR()) {
//						bullets2.remove(i);
//					} else {
//						bu2.setY(bu2.getY() - 10);
//						bu2.setX(bu2.getX()-5);
//					}
//					for (int j = 0; j < enemyPlanes.size(); j++) {
//						EnemyPlane ep = enemyPlanes.get(j);
//						boolean b = isHeat(bu2,ep);
//						//判断子弹与敌机是否相撞
//						if (b == true) {
//							bullets2.remove(i);
//							ep.setX((int) (Math.random() * bgX));
//							ep.setY(0 - ep.getR());
//							ep.setSpeed((int) (Math.random() * 5) + 5);
//							ep.changeImg();
//							enemyPlanes.remove(j);
//							enemyPlanes.add(ep);
//							hero.setScore(hero.getScore() + 10);
//						}
//					}
//				}
				repaint();
			}
			
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				
				e.printStackTrace();
					}
				}
			}
		}
	
	//判断敌机是否与子弹相撞
	private boolean isHeat(Bullet bu, EnemyPlane ep) {
		if ((bu.getX() - ep.getX()) * (bu.getX() - ep.getX()) + 
				(bu.getY() - ep.getY()) * (bu.getY() - ep.getY()) <=
				(bu.getR() + ep.getR()) * (bu.getR() + ep.getR())) {
			return true;
		} else {
			return false;
		}
	}
	private boolean isHeat1(Bullet bu1, EnemyPlane ep) {
		if ((bu1.getX() - ep.getX()) * (bu1.getX() - ep.getX()) + 
				(bu1.getY() - ep.getY()) * (bu1.getY() - ep.getY()) <=
				(bu1.getR() + ep.getR()) * (bu1.getR() + ep.getR())) {
			return true;
		} else {
			return false;
		}
	}
	private boolean isHeat2(Bullet bu2, EnemyPlane ep) {
		if ((bu2.getX() - ep.getX()) * (bu2.getX() - ep.getX()) + 
				(bu2.getY() - ep.getY()) * (bu2.getY() - ep.getY()) <=
				(bu2.getR() + ep.getR()) * (bu2.getR() + ep.getR())) {
			return true;
		} else {
			return false;
		}
	}

	//判断敌机是否与战机相撞
	private boolean isHeat(EnemyPlane ep, Hero hero) {
		if ((ep.getX() - hero.getX()) * (ep.getX() - hero.getX()) + 
				(ep.getY() - hero.getY()) * (ep.getY() - hero.getY()) <=
				(ep.getR() + hero.getR()) * (ep.getR() + hero.getR())) {
			return true;
		} else {
			return false;
		}
	}

	private void initBullet() {
		Bullet bu = new Bullet();
		bu.setX(hero.getX());
		bu.setY(hero.getY());
		bu.setR(50);
		bullets.add(bu);
	
	}
	private void initBullet1() {
		Bullet bu1 = new Bullet();
		bu1.setX(hero.getX());
		bu1.setY(hero.getY());
		bu1.setR(50);
		bullets1.add(bu1);
	
	}
	private void initBullet2() {
		Bullet bu2 = new Bullet();
		bu2.setX(hero.getX());
		bu2.setY(hero.getY());
		bu2.setR(50);
		bullets2.add(bu2);
	
	}

	//鼠标按下并移动时调用
	@Override
	public void mouseDragged(MouseEvent e) {
		if (hero.getBlood() > 0) {
			hero.setX(e.getX());
			hero.setY(e.getY());
			repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
}

