package playgame;

import javax.swing.JOptionPane;

/**
 * 
 * @author xzjt112
 *��һ��
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
			int go = JOptionPane.showConfirmDialog(null, "�÷��ѹ������Ƿ�ѡ�������һ��","���سɹ���",JOptionPane.YES_NO_CANCEL_OPTION);
			
			if(go==JOptionPane.YES_OPTION){
				hero.setCurrentState(new Hero2edState(this));//�ڶ����л���������
				hero.setBlood(150);
				hero.setLevel(2);
			}else if(go==JOptionPane.NO_OPTION){
				JOptionPane.showMessageDialog(null, "�����˳���Ϸ���ټ���");
				System.exit(0);
				}
			}		
		}	
	}
