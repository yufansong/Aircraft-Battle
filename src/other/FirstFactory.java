public class FirstFactory extends AbstractFactory{

	@Override
	public HeroState creatHero() {
		// TODO Auto-generated method stub
		return new FirstHero();
	}

	@Override
	public Bullet creatBullet() {
		// TODO Auto-generated method stub
		return new FirstBullet();
	}

	@Override
	public Enemy creatEnemy() {
		// TODO Auto-generated method stub
		return new FisrtEnemy();
	}

}
