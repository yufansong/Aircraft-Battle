package playgame;

import javax.swing.JOptionPane;

public class Hero3rdState extends HeroState{
	public Hero3rdState(Hero hero){
		this.hero = hero;
	}
	public Hero3rdState(HeroState state){
		this.hero = state.hero;
	}
	@Override
	public void check() {
		int score = hero.getScore();
		
		if(score>2500){
			int go = JOptionPane.showConfirmDialog(null, "通关，请选择是否重新游戏","闯关成功！",JOptionPane.YES_NO_CANCEL_OPTION);
			
			if(go==JOptionPane.YES_OPTION){
				hero.setCurrentState(new Hero1stState(this));//第二关切换都第三关
				hero.setBlood(150);
				hero.setLevel(1);
			}else if(go==JOptionPane.NO_OPTION){
				JOptionPane.showMessageDialog(null, "你已退出游戏，再见！");
				System.exit(0);				
				}
			}
		}
	}

