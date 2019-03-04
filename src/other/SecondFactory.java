package other;

public class SecondFactory extends AbstractFactory{

	@Override
	public HeroState creatHero() {
		// TODO Auto-generated method stub
		return new SecondHero();
	}

	@Override
	public Bullet creatBullet() {
		// TODO Auto-generated method stub
		return new SecondBullet();
	}

	@Override
	public Enemy creatEnemy() {
		// TODO Auto-generated method stub
		return new SecondEnemy();
	}
	
}
