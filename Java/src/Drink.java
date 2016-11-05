import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Color;

public class Drink extends JPanel{
	boolean bDrink=true;
	private JTextField menuname,price, drinkname1,drinkname3;
	private JTextField drinkname2;
	private JTextField drinkprice1,drinkprice2,drinkprice3;
	private JComboBox comboBox, cola_comboBox, fanta_comboBox,  sprite_comboBox;
	DefaultTableModel tableModel;
	private JScrollPane order;
	private JTable table;
	private JButton TotalButton;
	private JTextField TotalTextField;
	
	
	public Drink(){
		setBackground(new Color(255, 250, 240));
		setLayout(null);
		this.setBounds(300,300,600,600);
		JLabel drink = new JLabel("음료");
		drink.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		drink.setBounds(258, 22, 41, 29);
		add(drink);
		JLabel cola = new JLabel("콜라");
		cola.setIcon(new ImageIcon(Guibin.class.getResource("/images/cola.jpg")));
		cola.setBounds(84, 57, 102, 121);
		add(cola);
		
		JLabel fanta = new JLabel("환타");
		fanta.setIcon(new ImageIcon(Guibin.class.getResource("/images/fanta.jpg")));
		fanta.setBounds(226, 55, 102, 125);
		add(fanta);
		
		JLabel sprite = new JLabel("사이다");
		sprite.setIcon(new ImageIcon(Guibin.class.getResource("/images/sprite.png")));
		sprite.setBounds(372, 57, 102, 125);
		add(sprite);
		
		drinkname1 = new JTextField();
		drinkname1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		drinkname1.setText("콜라");
		drinkname1.setBounds(105, 201, 41, 21);
		add(drinkname1);
		drinkname1.setColumns(10);
		
		drinkname2 = new JTextField();
		drinkname2.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		drinkname2.setText("환타");
		drinkname2.setBounds(247, 201, 41, 21);
		add(drinkname2);
		drinkname2.setColumns(10);
		
		drinkname3 = new JTextField();
		drinkname3.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		drinkname3.setText("사이다");
		drinkname3.setBounds(382, 203, 55, 21);
		add(drinkname3);
		drinkname3.setColumns(10);
		
		drinkprice1 = new JTextField();
		drinkprice1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		drinkprice1.setText("1000");
		drinkprice1.setBounds(146, 201, 41, 21);
		add(drinkprice1);
		drinkprice1.setColumns(10);
		
		drinkprice2 = new JTextField();
		drinkprice2.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		drinkprice2.setText("1000");
		drinkprice2.setBounds(437, 203, 41, 21);
		add(drinkprice2);
		drinkprice2.setColumns(10);
		
		drinkprice3 = new JTextField();
		drinkprice3.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		drinkprice3.setText("1000");
		drinkprice3.setBounds(285, 201, 41, 21);
		add(drinkprice3);
		drinkprice3.setColumns(10);
		
		cola_comboBox = new JComboBox();
		cola_comboBox.setBounds(106, 236, 80, 36);
		add(cola_comboBox);

		for(int i =0; i<=10;i++){
			cola_comboBox.addItem(Integer.toString(i));
		}
		cola_comboBox.setSelectedIndex(1);
		
		fanta_comboBox = new JComboBox();
		
		fanta_comboBox.setBounds(397, 238, 81, 36);
		add(fanta_comboBox);

		for(int i =0; i<=10;i++){
			fanta_comboBox.addItem(Integer.toString(i));
		}
		fanta_comboBox.setSelectedIndex(1);

		sprite_comboBox = new JComboBox();
		
		sprite_comboBox.setBounds(244, 236, 81, 36);
		add(sprite_comboBox);

		for(int i =0; i<=10;i++){
			sprite_comboBox.addItem(Integer.toString(i));
		}
		sprite_comboBox.setSelectedIndex(1);

		JButton drink_choose1 = new JButton("음료선택");
		drink_choose1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		drink_choose1.addActionListener(new MyAddTableButton_drink());
		drink_choose1.setBounds(106, 282, 81, 37);
		add(drink_choose1);
		
		JButton drink_choose2 = new JButton("음료선택");
		drink_choose2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		drink_choose2.addActionListener(new MyAddTableButton_drink2());
		drink_choose2.setBounds(397, 282, 81, 37);
		add(drink_choose2);

		JButton drink_choose3 = new JButton("음료선택");
		drink_choose3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		drink_choose3.addActionListener(new MyAddTableButton_drink3());
		drink_choose3.setBounds(245, 282, 81, 37);
		add(drink_choose3);
		
		String[] tableTitle = {"메뉴", "가격", "개수"};
		tableModel = new DefaultTableModel(null, tableTitle);
		order = new JScrollPane();
		
		order.setBounds(26, 329, 530, 121);
		add(order);
		table = new JTable(tableModel);
		order.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		TotalButton = new JButton("합계");
		TotalButton.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		TotalButton.setBounds(324, 460, 102, 36);
		TotalButton.addActionListener(new TotalButtonListener());
		add(TotalButton);
		
		TotalTextField = new JTextField();
		TotalTextField.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		TotalTextField.setBounds(438, 468, 116, 21);
		add(TotalTextField);
		TotalTextField.setColumns(10);
		
		Random rand = new Random();
		int num = rand.nextInt(3);
		
		String Person[] = {"최미연", "김유나", "임연주", "박은인"};

		String person = rand.nextInt(4)+"";
		table.addKeyListener(new KeyAdapter(){
			
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if(code == KeyEvent.VK_DELETE)
				{
					int row = table.getSelectedRow();
					
					tableModel.removeRow(row);
				}	
				
			}
		});
		}
	

	class MyAddTableButton_drink implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String strItem, strPrice;
			
			int cola_selNum = cola_comboBox.getSelectedIndex(); //이거는 콜라 콤보박스 선택한개수 받아오는 것 이거는 했어ㅠㅠㅠ근데
			
			
			//strItem = menuname.getText(); //여기가 콜라이름 받아서 테이블에 표시하는곳 이게안됨
			strItem = drinkname1.getText();
			strPrice = drinkprice1.getText(); //여기는 가격
			strPrice.replace(",", "");
	
			Object rowData[] = {strItem, strPrice.replace(",", ""), cola_selNum};
			
			tableModel.addRow(rowData);
		}
		
	}
	
	class MyAddTableButton_drink2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String strItem, strPrice;

			int fanta_selNum = fanta_comboBox.getSelectedIndex();
			strItem = drinkname2.getText(); //여기가 콜라이름 받아서 테이블에 표시하는곳 이게안됨
			strPrice = drinkprice2.getText(); //여기는 가격
			strPrice.replace(",", "");
	
			Object rowData[] = {strItem, strPrice.replace(",", ""), fanta_selNum};
			
			tableModel.addRow(rowData);
		}
	}
	
	class MyAddTableButton_drink3 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String strItem, strPrice;
			int sprite_selNum = sprite_comboBox.getSelectedIndex();
			strItem = drinkname3.getText(); //여기가 콜라이름 받아서 테이블에 표시하는곳 이게안됨
			strPrice = drinkprice3.getText(); //여기는 가격
			strPrice.replace(",", "");
	
			Object rowData[] = {strItem, strPrice.replace(",", ""), sprite_selNum};
			
			tableModel.addRow(rowData);
		
		}
	}
	
	class TotalButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			int TotalPrice = 0; 

	        for (int i = 0; i < table.getRowCount(); i++) { 
	            int price = (Integer.parseInt((String) table.getValueAt(i, 1))) ;
	            int count = (int)tableModel.getValueAt(i, 2); 
	            
	            int total = price*count;
	            TotalPrice += total; 
	        }

	        String str = TotalTextField.getText();
	        TotalTextField.setText(TotalPrice + ""); 
		}
	}
}