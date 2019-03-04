package playgame;

import javax.swing.JOptionPane;

/**
 * 
 * @author xzjt112
 *第一关
 */
public class Hero1stState extends HeroState {
	
	public Hero1stState(Hero hero){
		this.hero = hero;
	}
	
	public Hero1stState(HeroState state){
		this.hero = state.hero;
	}

	@Override
	public void check() {
		int score = hero.getScore();
		
		if(score>500){
			int go = JOptionPane.showConfirmDialog(null, "得分已够，请是否选择进入下一关","闯关成功！",JOptionPane.YES_NO_CANCEL_OPTION);
			
			if(go==JOptionPane.YES_OPTION){
				hero.setCurrentState(new Hero2edState(this));//第二关切换都第三关
				hero.setBlood(150);
				hero.setLevel(2);
			}else if(go==JOptionPane.NO_OPTION){
				JOptionPane.showMessageDialog(null, "你已退出游戏，再见！");
				System.exit(0);
				}
			}		
		}	
	}
