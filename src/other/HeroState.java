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
		int go = JOptionPane.showConfirmDialog(null, "得分已够，请是否选择进入下一关","闯关成功！",JOptionPane.YES_NO_CANCEL_OPTION);
		
		if(go==JOptionPane.YES_OPTION){
			hero.setBlood(150);
			hero.setLevel(Level);
		}else if(go==JOptionPane.NO_OPTION){
			JOptionPane.showMessageDialog(null, "你已退出游戏，再见！");
			System.exit(0);
			}
	}
}
