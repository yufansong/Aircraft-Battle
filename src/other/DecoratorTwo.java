package other;

import java.util.ArrayList;

import playgame.Bullet;

public class DecoratorTwo extends Decorator{

	@Override
	public void add(ArrayList<Bullet> bullets) {
		// TODO Auto-generated method stub
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
				//ÅÐ¶Ï×Óµ¯ÓëµÐ»úÊÇ·ñÏà×²
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
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
