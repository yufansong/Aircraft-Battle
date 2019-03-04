package other;

public class ThirdFactory  extends AbstractFactory{

	@Override
	public HeroState creatHero() {
		// TODO Auto-generated method stub
		return new ThirdHero();
	}

	@Override
	public Bullet creatBullet() {
		// TODO Auto-generated method stub
		return new ThirdBullet();
	}

	@Override
	public Enemy creatEnemy() {
		// TODO Auto-generated method stub
		return new ThirdEnemy();
	}
	
}
