import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import java.awt.Color;

public class Guibin extends JPanel {
	JComboBox combo = null;
	
	private final Object [] colNames = {"ChkBox","�޴�","����","����", "������"};
	private Object [][] datas = {{false,"¥���","","4500",null},
								{false,"«��","","5000", null},
								{false,"������","","10000",null}};
	
	JLabel lblNewLabel_1;
	
	int TotalPrice = 0;
	int TotalPrice2 = 0;
	int DuchPrice = 0; 
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JTable table;
	DefaultTableModel tableModel;
	private JTextField textField;
	private JTextField textField_1;
	JComboBox combo_people;
	public Guibin() {
		setBackground(new Color(240, 255, 240));

		this.setBounds(300,300,600,600);
		//JPanel panel = new JPanel(new BorderLayout());

		tableModel = new DefaultTableModel(datas,colNames);
		table = new JTable(tableModel);
		table.setFont(new Font("���� ���", Font.PLAIN, 18));
		add(table);
		
		//CheckBox �׸��� ��
		table.getColumn("ChkBox").setCellRenderer(new MyCheckCellRender());	
		JCheckBox box = new JCheckBox();
	   	box.setHorizontalAlignment(JLabel.CENTER);
	   	table.getColumn("ChkBox").setCellEditor(new DefaultCellEditor(box));
	   	
	   	combo = new JComboBox();
	   	for(int i=0; i<100; i++)
	   	{
	   		combo.addItem(i+"");
	   		
	   	}
		
		table.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(combo));
		table.getColumnModel().getColumn(4).setCellRenderer(new MyIconRenderer());
		table.getColumnModel().getColumn(4).setPreferredWidth(200);
		setLayout(null);
		table.setRowHeight(180);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(30, 52, 541, 260);
		add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("�޴�(���� �ʾƵ� ����)");
		lblNewLabel.setFont(new Font("���� ���", Font.BOLD, 18));
		lblNewLabel.setBounds(30, 20, 427, 15);
		add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("����");
		rdbtnNewRadioButton.setFont(new Font("���� ���", Font.PLAIN, 18));
		rdbtnNewRadioButton.setBackground(new Color(240, 255, 240));
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(30, 337, 121, 23);
		rdbtnNewRadioButton.addActionListener(new TotalButton());
		add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("��ġ����  �ο�");
		rdbtnNewRadioButton_1.setFont(new Font("���� ���", Font.PLAIN, 18));
		rdbtnNewRadioButton_1.setBackground(new Color(240, 255, 240));
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(30, 429, 153, 23);
		rdbtnNewRadioButton_1.addActionListener(new DuchButton());
		add(rdbtnNewRadioButton_1);
		
		JButton calling = new JButton("��ȭ�ֹ�");
		calling.setFont(new Font("���� ���", Font.BOLD, 20));
		calling.setBackground(new Color(240, 255, 255));
		calling.setBounds(433, 337, 121, 172);
		calling.addActionListener(new CallButton());
		add(calling);
		
		combo_people = new JComboBox();
		combo_people.setBounds(183, 430, 45, 21);
		for(int i=1; i<11; i++)
	   	{
			combo_people.addItem(i+"");
	   		
	   	}
		combo_people.setSelectedIndex(3);
		add(combo_people);
		
		textField = new JTextField();
		textField.setBounds(30, 385, 252, 21);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(30, 488, 252, 21);
		add(textField_1);

	}
	class CallButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			calling call = new calling();
			call.setVisible(true);
		}
	}
	
	class MyCheckCellRender extends DefaultTableCellRenderer{
		public Component getTableCellRendererComponent  // ��������
		(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int umn)
		{
			JCheckBox box=  new JCheckBox();
			box.setSelected(((Boolean)value).booleanValue());  
			box.setHorizontalAlignment(JLabel.CENTER);
			return box;
		}
	}
	 
	 class MyIconRenderer extends DefaultTableCellRenderer{
		 JLabel lbl = new JLabel();

		  ImageIcon icon[] ={ new ImageIcon(getClass().getResource("/images/zzazzang.jpg")),
				  new ImageIcon(getClass().getResource("/images/zzambbong.jpg")),
				  new ImageIcon(getClass().getResource("/images/tangsu.jpg"))
		  };

		  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
		      boolean hasFocus, int row, int column) {
		    lbl.setText((String) value);
		    lbl.setIcon(icon[row]);
		    lbl.setHorizontalAlignment(JLabel.CENTER);
		    return lbl;
		  }

	 } 
	 class TotalButton implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for (int i = 0; i < table.getRowCount(); i++) { 
		            int price = (Integer.parseInt((String) table.getValueAt(i, 3))) ;
		            int count = Integer.valueOf(table.getValueAt(i, 2).toString());
		            int total = price*count;
		            TotalPrice += total;
				} 
		        textField.setText("�� �հ�� "+ TotalPrice +"�� �Դϴ�.");
			}
	}
	 class DuchButton implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for (int i = 0; i < table.getRowCount(); i++) { 
		            int price = (Integer.parseInt((String) table.getValueAt(i, 3))) ;
		            int count = Integer.valueOf(table.getValueAt(i, 2).toString());
		            int total = price*count;
		            TotalPrice2 += total;
				}
				int People_Num = combo_people.getSelectedIndex()+1;
				DuchPrice = TotalPrice2/People_Num;
				textField_1.setText("1�δ� ������ �� "+ DuchPrice +"�� �Դϴ�.");
				
			}	
	 }
}