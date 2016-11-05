import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
public class First extends JPanel {
	JTabbedPane tabPane;
	int selnum;
	public First() {
		setBackground(new Color(255, 255, 240));
		setLayout(null);
		this.setBounds(300,300,600,600);
		JLabel lblNewLabel = new JLabel("¿À´ÃÀÇ ¸Þ´º¸¦ Á¤ÇØº¾½Ã´Ù~!");
		lblNewLabel.setBackground(new Color(105, 105, 105));
		lblNewLabel.setForeground(new Color(105, 105, 105));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		lblNewLabel.setBounds(17, 64, 566, 107);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setBackground(new Color(255, 250, 250));
		lblNewLabel_1.setIcon(new ImageIcon(First.class.getResource("/images/jokbal.jpg")));
		lblNewLabel_1.setBounds(131, 128, 388, 263);
		add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("µû    ¶õ");
		btnNewButton.setBackground(new Color(255, 250, 240));
		btnNewButton.setForeground(new Color(169, 169, 169));
		btnNewButton.setBounds(202, 384, 144, 58);
		btnNewButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 21));
		add(btnNewButton);
		btnNewButton.addActionListener(new btnClickListener());
		
	}
	
	void setTabPane(JTabbedPane tabPane)
	{
		this.tabPane = tabPane;
	}
	class btnClickListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random();
				int num = rand.nextInt(3);
				tabPane.setSelectedIndex(num);
				
			}
	}
}

	
