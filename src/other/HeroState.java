package other;

import javax.swing.JOptionPane;

import playgame.Hero;

public abstract class HeroState {
	Hero hero;
	protected int Blood = 150;
	protected int Level;
	protected int score;
	protected abstract void set();
	public void showOptionPane() {
		int go = JOptionPane.showConfirmDialog(null, "�÷��ѹ������Ƿ�ѡ�������һ��","���سɹ���",JOptionPane.YES_NO_CANCEL_OPTION);
		
		if(go==JOptionPane.YES_OPTION){
			hero.setBlood(150);
			hero.setLevel(Level);
		}else if(go==JOptionPane.NO_OPTION){
			JOptionPane.showMessageDialog(null, "�����˳���Ϸ���ټ���");
			System.exit(0);
			}
	}
}
