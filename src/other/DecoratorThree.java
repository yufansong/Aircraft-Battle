package other;

import java.util.ArrayList;

import playgame.Bullet;

public class DecoratorThree extends Decorator{

	@Override
	public void add(ArrayList<Bullet> bullets) {
		// TODO Auto-generated method stub
		for (int i = 0; i < bullets2.size(); i++) {
			Bullet bu2 = bullets2.get(i);
			if (bu2.getY() <= 0 - bu2.getR()) {
				bullets2.remove(i);
			} else {
				bu2.setY(bu2.getY() - 10);
				bu2.setX(bu2.getX()-5);
			}
			for (int j = 0; j < enemyPlanes.size(); j++) {
				EnemyPlane ep = enemyPlanes.get(j);
				boolean b = isHeat(bu2,ep);
				if (b == true) {
					bullets2.remove(i);
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
