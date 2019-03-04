package playgame;

import javax.swing.JOptionPane;

public class Hero2edState extends HeroState{
	
	public Hero2edState(Hero hero){
		this.hero = hero;
	}
	public Hero2edState(HeroState state){
		this.hero = state.hero;
	}
	@Override
	public void check() {
		int score = hero.getScore();
		
		if(score>1000){
			int go = JOptionPane.showConfirmDialog(null, "得分已够，请是否选择进入下一关","闯关成功！",JOptionPane.YES_NO_CANCEL_OPTION);
			
			if(go==JOptionPane.YES_OPTION){
				hero.setCurrentState(new Hero3rdState(this));//第二关切换都第三关
				hero.setBlood(150);
				hero.setLevel(3);
			}else if(go==JOptionPane.NO_OPTION){
				JOptionPane.showMessageDialog(null, "你已退出游戏，再见！");
				System.exit(0);
			}
		}
	}
}
