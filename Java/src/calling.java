import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;

public class calling extends JFrame{
	JPanel panel;
	
	public calling(){
		getContentPane().setBackground(new Color(245, 245, 220));
	
	Toolkit kit = Toolkit.getDefaultToolkit();

	Image image = kit.getImage(calling.class.getResource("images/call2.png"));
	this.setIconImage(image);

	setTitle("ÀüÈ­°É¾î ÀüÈ­");
	panel = new JPanel();
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setBounds(100, 100, 551, 645);
	getContentPane().setLayout(null);
	

	JButton btnNewButton = new JButton("´Ý±â");
	btnNewButton.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
	btnNewButton.addActionListener(new closeButton());
	btnNewButton.setBounds(426, 574, 97, 23);
	getContentPane().add(btnNewButton);
	
	JButton btnNewButton_1 = new JButton("050-7458-0490");
	btnNewButton_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
	
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	btnNewButton_1.setBounds(268, 131, 231, 35);
	getContentPane().add(btnNewButton_1);
	
	JButton btnNewButton_2 = new JButton("02-973-8364");
	btnNewButton_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
	btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	btnNewButton_2.setBounds(268, 218, 231, 35);
	getContentPane().add(btnNewButton_2);
	
	JButton btnNewButton_3 = new JButton("02-972-0824");
	btnNewButton_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
	btnNewButton_3.setBounds(268, 308, 231, 35);
	getContentPane().add(btnNewButton_3);
	
	JButton btnNewButton_4 = new JButton("02-991-1523");
	btnNewButton_4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
	btnNewButton_4.setBounds(268, 398, 231, 35);
	getContentPane().add(btnNewButton_4);
	
	JButton btnNewButton_5 = new JButton("02-977-7557");
	btnNewButton_5.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
	btnNewButton_5.setBounds(268, 488, 231, 35);
	getContentPane().add(btnNewButton_5);
	
	JLabel lblNewLabel = new JLabel("ÀüÈ­¹øÈ£ºÎ");
	lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 21));
	lblNewLabel.setBounds(33, 30, 110, 45);
	getContentPane().add(lblNewLabel);
	
	JLabel lblNewLabel_3 = new JLabel("New label");
	lblNewLabel_3.setIcon(new ImageIcon(calling.class.getResource("/images/sware.PNG")));
	lblNewLabel_3.setBounds(24, 285, 180, 80);
	getContentPane().add(lblNewLabel_3);
	
	JLabel lblNewLabel_5 = new JLabel("New label");
	lblNewLabel_5.setIcon(new ImageIcon(calling.class.getResource("/images/chicken.PNG")));
	lblNewLabel_5.setBounds(24, 465, 180, 80);
	getContentPane().add(lblNewLabel_5);
	
	JLabel lblNewLabel_1 = new JLabel("New label");
	lblNewLabel_1.setIcon(new ImageIcon(calling.class.getResource("/images/guibin1.PNG")));
	lblNewLabel_1.setBounds(24, 111, 180, 74);
	getContentPane().add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("New label");
	lblNewLabel_2.setIcon(new ImageIcon(calling.class.getResource("/images/sorabusic.PNG")));
	lblNewLabel_2.setBounds(24, 195, 180, 80);
	getContentPane().add(lblNewLabel_2);
	
	JLabel lblNewLabel_4 = new JLabel("New label");
	lblNewLabel_4.setIcon(new ImageIcon(calling.class.getResource("/images/yongwoodong1.PNG")));
	lblNewLabel_4.setBounds(24, 375, 180, 80);
	getContentPane().add(lblNewLabel_4);
	this.setVisible(true);
	
	
	
	
	}
	
	class closeButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();
		}
		
	}
}
