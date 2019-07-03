package jdbc_study.ui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import jdbc_study.dto.Department;
import jdbc_study.dto.Title;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;

public class PanelTitle extends JPanel {

	private JTextField tfTtlNo;
	private JTextField tfTtlName;
	
	public PanelTitle() {

		initComponents();
	}
	private void initComponents() {
		setBorder(new TitledBorder(null, "직책정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblTtlNo = new JLabel("직책 번호");
		lblTtlNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblTtlNo);
		
		tfTtlNo = new JTextField();
		add(tfTtlNo);
		tfTtlNo.setColumns(10);
		
		JLabel lblTtlName = new JLabel("직책명");
		lblTtlName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblTtlName);
		
		tfTtlName = new JTextField();
		tfTtlName.setColumns(10);
		add(tfTtlName);
		
		
	}
	
	public void setTitle(Title ttl) {
		tfTtlNo.setText(ttl.getNo()+"");
		tfTtlName.setText(ttl.getTitlename());
		
	}
	
	public Title getTitle() {
		int ttlNo = Integer.parseInt(tfTtlNo.getText().trim());
		String ttlName = tfTtlName.getText().trim();
		return new Title(ttlNo, ttlName);
	}
	
	public void clearTextField() {
		tfTtlNo.setText("");
		tfTtlName.setText("");
		
	}
	
	public void setTfAllEditable(boolean isEditable) {
		tfTtlNo.setEditable(isEditable);
		tfTtlName.setEditable(isEditable);
}
}
