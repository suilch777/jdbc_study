package jdbc_study.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc_study.dto.Department;
import jdbc_study.dto.Title;


@SuppressWarnings("serial")
public class TitleUI extends JFrame implements ActionListener{

	private JPanel contentPane;
	private PanelTitle pContent;
	private JButton btnAdd;
	private JButton btnClear;
	
	private Title dao;
	private ErpMngUI ErpMngUI;

	
	
	
	public TitleUI() {
		initComponents();
	}
	private void initComponents() {
		setTitle("직책관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pContent = new PanelTitle();
		contentPane.add(pContent, BorderLayout.CENTER);
		
		JPanel pBtn = new JPanel();
		contentPane.add(pBtn, BorderLayout.SOUTH);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtn.add(btnAdd);
		
		btnClear = new JButton("취소");
		btnClear.addActionListener(this);
		pBtn.add(btnClear);
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClear) {
			actionPerformedBtnClear(e);
		}
		if (e.getSource() == btnAdd) {
			if (btnAdd.getText().equals("추가")) {
				actionPerformedBtnAdd(e);
			}else {
				try {
					actionPerformedBtnUpdate(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}

	private void actionPerformedBtnUpdate(ActionEvent e) throws SQLException {
		Title newTtl = pContent.getTitle();
		int res;
		res = dao.updateTitle(newTtl);
		if (res != -1) {
			JOptionPane.showMessageDialog(null, String.format("%s 직책이 수정되었습니다.", newTtl.getTitlename()));
			pContent.clearTextField();
			btnAdd.setText("추가");
		}
		ErpMngUI.refreshUI();		
	}

	private void actionPerformedBtnAdd(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	private void actionPerformedBtnClear(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public ErpMngUI getErpMngUI() {
		return ErpMngUI;
	}

	public void setErpMngUI(ErpMngUI erpMngUI) {
		ErpMngUI = erpMngUI;
	}

}
