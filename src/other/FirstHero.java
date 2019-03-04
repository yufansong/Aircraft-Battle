package other;

import javax.swing.JOptionPane;

public class FirstHero extends HeroState{

	@Override
	public void set() {
		// TODO Auto-generated method stub
		Level = 1;
		score = 0;
		hero.setimag("img/hero1.png");
	}
	
}
