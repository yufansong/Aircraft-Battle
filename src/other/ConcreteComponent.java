package other;

import java.util.ArrayList;

import playgame.Bullet;

public class ConcreteComponent extends Component{

	private static Object bullt;
	public ConcreteComponent(Bullet bullet){
		super((Bullet) bullt);
	}
	@Override
	public void run(){
		DecoratorTwo a;
		DecoratorThree b;
		a.add(getBullets());
		b.add(getBullets());
	}

}
