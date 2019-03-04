package other;

import javax.swing.ImageIcon;

public class FirstBullet extends Bullet{

	@Override
	protected void initialImage() {
		// TODO Auto-generated method stub
		bulletImg = new ImageIcon("img/fire.png").getImage();
	}
	
}
