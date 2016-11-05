import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.Image;
import java.awt.Toolkit;

public class MyUtility extends JFrame{
	JPanel panel;
	public static JTabbedPane tabbedPane;
	
	MyUtility(){
		
		Toolkit kit = Toolkit.getDefaultToolkit();

		Image image = kit.getImage(MyUtility.class.getResource("images/question.jpg"));
		this.setIconImage(image);

		setTitle("¿À´Ã ¹¹¸ÔÁö?");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(300,200,600,600);
		
		panel = new JPanel();
		
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 774, 929);
		panel.add(tabbedPane);
		
		First panel_1 = new First();
		tabbedPane.addTab("·£´ý", null, panel_1, null);
		panel_1.setLayout(null);
		panel_1.setTabPane(tabbedPane);
		
		Guibin panel_2 = new Guibin();
		tabbedPane.addTab("±Íºó", null, panel_2, null);
		panel_2.setLayout(null);
			
		Yongwoodong panel_3 = new Yongwoodong();
		tabbedPane.addTab("¿ë¿ìµ¿", null, panel_3, null);
		panel_3.setLayout(null);
		
		
		Drink panel_4 = new Drink();
		tabbedPane.addTab("À½·á", null, panel_4, null);
		panel_4.setLayout(null);
		
		
		
		this.setVisible(true);
	}
	private static void setIconImage(ImageIcon imageIcon) {
		// TODO Auto-generated method stub
		
	}
	
	public void setSelectTab(int num)
	{
		tabbedPane.setSelectedIndex(num);
	}
}
