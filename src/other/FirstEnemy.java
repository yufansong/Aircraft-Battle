package other;

import java.text.DecimalFormat;

import javax.swing.ImageIcon;

public class FirstEnemy extends Enemy{

	@Override
	public void Initial() {
		// TODO Auto-generated method stub
		epNum = (int)(Math.random()*4)+1;
		DecimalFormat df = new DecimalFormat("00");
		String ep= df.format(epNum);
		epImg = new ImageIcon("img/ep"+ep+".png").getImage();	
	}

	@Override
	public void changeImg() {
		// TODO Auto-generated method stub
		epNum = (int)(Math.random()*4)+1;
		DecimalFormat df = new DecimalFormat("00");
		String ep= df.format(epNum);
		epImg = new ImageIcon("img/ep"+ep+".png").getImage();	
	}

}
