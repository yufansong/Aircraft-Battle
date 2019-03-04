package playgame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.activation.ActivationInstantiator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//2nd class    
// Q1:���⣺��ʼ��ť�ͽ�����ť���ܵ�ʵ�ֹ���(��ť���ܵ�ʵ�ֹ���)
public class Start extends JFrame implements ActionListener{
	private static final long serialVersionUID = 293145988993785462L;
	private JButton button_start = new JButton ();
	private JButton button_end = new JButton ();
	private int level,grade,time;
	private String name;
	private Hero hero = Hero.getHero();
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	
	public Start(int level, int grade, String name, int time) {
		// TODO Auto-generated constructor stub
		this.level = level;
		this.grade = grade;
		this.name = name;
		this.time = time;
		
		DB_Operater db_Operater = new DB_Operater();
		JFrame frame = new JFrame("��ʼ����");
		
		frame.setBounds((dim.width-300)/2,(dim.height-400)/2,500,400);		
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.setBounds((dim.width-300)/2,(dim.height-400)/2,500,400);		
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		button_start.setText("��ʼ��Ϸ");
		button_end.setText("������Ϸ");
		
		button_start.addActionListener(this);
		button_end.addActionListener(this);
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		
		JTextField Level = new JTextField(20);
		JTextField Grade = new JTextField(20);
		JTextField Time = new JTextField(20);
		
		Level.setEnabled(false);
		Grade.setEnabled(false);
		Time.setEnabled(false);
		
		Level.setText(level+"");
		Grade.setText(grade+"");
		Time.setText(time+"��");
		
		panel1.add(button_start);
		panel1.add(button_end);
		panel2.add(new Label("�ȼ���"));
		panel2.add(Level);
		panel3.add(new Label("�ɼ���"));
		panel3.add(Grade);
		panel4.add(new Label("�ϴ�����ʱ�䣺"));
		panel4.add(Time);
		panel5.add(panel2, BorderLayout.NORTH);
		panel5.add(panel3, BorderLayout.CENTER);
		panel5.add(panel4, BorderLayout.SOUTH);
		
		frame.add(panel1, BorderLayout.SOUTH);
		frame.add(panel5, BorderLayout.CENTER);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button_start){
               new Started(level, grade, name);
		}
		if(e.getSource() == button_end){
			CareTaker ct = new CareTaker();
			ct.saveMemento(hero.createMemento());
			ct.getMemento();
			System.exit(0);

		}
	}
	
}
