package playgame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Jm_start extends JFrame implements MouseListener{
	private JButton bt_signup;
	private JButton bt_login;
	private JTextField tf_name;
	private JTextField tf_pass;
	private Image startImg = new ImageIcon("img/gtx.jpg").getImage();
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

	DB_Operater db_Operater;
	Jm_start(){
		db_Operater = new DB_Operater();
		this.setTitle("welcom∑…ª˙¥Û’Ω");
		
		JPanel p_text1= new JPanel();
		JPanel p_text2= new JPanel();
		tf_name = new JTextField(20);
		tf_pass = new JTextField(20);
		p_text1.add(new Label("’À∫≈"));
		p_text2.add(new Label("√‹¬Î"));
		p_text1.add(tf_name);
		p_text2.add(tf_pass);
		
		JPanel p_bt = new JPanel();
		bt_signup = new JButton("◊¢≤·’ ∫≈");
		bt_login = new JButton("µ«¬º”Œœ∑");
		p_bt.add(bt_signup);
		p_bt.add(bt_login);
		
		bt_signup.addMouseListener(this);
		bt_login.addMouseListener(this);
		
		this.add(p_text1,BorderLayout.NORTH);
		this.add(p_text2,BorderLayout.CENTER);
		this.add(p_bt,BorderLayout.SOUTH);
		this.setBounds((dim.width-400)/2, (dim.height-300)/2, 350, 150);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Jm_start();
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String name = tf_name.getText().toString().trim();
		String pass = tf_pass.getText().toString().trim();
		
		if(e.getSource() == bt_signup){
			if(name.equals("") || name.length() == 0 || pass.equals("") || pass.length() == 0){
				JOptionPane.showMessageDialog(null, "«Î ‰»Î’ ∫≈∫Õ√‹¬Î");
			}else{
				if(db_Operater.exist(name)){
					JOptionPane.showMessageDialog(null, "’ ∫≈“—¥Ê‘⁄£¨«Î÷ÿ–¬ ‰»Î’ ∫≈∫Õ√‹¬Î");
				}else{
					db_Operater.add(name, pass);
					JOptionPane.showMessageDialog(null, "◊¢≤·≥…π¶£¨«Îµ«¬º");
				}
			}
		}else if(e.getSource() == bt_login){
			if(name.equals("") || name.length() == 0 || pass.equals("") || pass.length() == 0){
				JOptionPane.showMessageDialog(null, "«Î ‰»Î’ ∫≈∫Õ√‹¬Î");
			}else{
				if(db_Operater.check(name, pass)){
					this.setVisible(false);
					int level = db_Operater.get(name,"level");
					int grade = db_Operater.get(name,"grade");
					int time = db_Operater.get(name,"time");
					new Start(level , grade , name , time);
				}else{
					JOptionPane.showMessageDialog(null, "«Î ‰»Î’˝»∑µƒ’ ∫≈∫Õ√‹¬Î");
				}
			}
		}
	}
	
	public void paint(Graphics g) {
		g.drawImage(startImg, 0, 0, (dim.width-400)/2, (dim.height-300)/2, null);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}