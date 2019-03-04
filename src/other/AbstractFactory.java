package other;

public abstract class AbstractFactory {
	public abstract HeroState creatHero();
	public abstract Bullet creatBullet();
	public abstract Enemy creatEnemy();
}
