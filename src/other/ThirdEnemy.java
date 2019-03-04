package other;

import java.text.DecimalFormat;

import javax.swing.ImageIcon;

public class ThirdEnemy extends Enemy{

	@Override
	public void Initial() {
		// TODO Auto-generated method stub
		epNum = 1;
		while (epNum<10)
			epNum = (int)(Math.random()*15)+1;
		DecimalFormat df = new DecimalFormat("00");
		String ep= df.format(epNum);
		epImg = new ImageIcon("img/ep"+ep+".png").getImage();	
	}

	@Override
	public void changeImg() {
		// TODO Auto-generated method stub
		epNum = 1;
		while (epNum<10)
			epNum = (int)(Math.random()*15)+1;
		DecimalFormat df = new DecimalFormat("00");
		String ep= df.format(epNum);
		epImg = new ImageIcon("img/ep"+ep+".png").getImage();	
	}

}
