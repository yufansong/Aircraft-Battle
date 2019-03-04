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
			int go = JOptionPane.showConfirmDialog(null, "ͨ�أ���ѡ���Ƿ�������Ϸ","���سɹ���",JOptionPane.YES_NO_CANCEL_OPTION);
			
			if(go==JOptionPane.YES_OPTION){
				hero.setCurrentState(new Hero1stState(this));//�ڶ����л���������
				hero.setBlood(150);
				hero.setLevel(1);
			}else if(go==JOptionPane.NO_OPTION){
				JOptionPane.showMessageDialog(null, "�����˳���Ϸ���ټ���");
				System.exit(0);				
				}
			}
		}
	}

