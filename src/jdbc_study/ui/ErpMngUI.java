package jdbc_study.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc_study.dao.TitleDao;
import jdbc_study.daoimpl.DepartmentDaoImpl;
import jdbc_study.daoimpl.EmployeeDaoImpl;
import jdbc_study.daoimpl.TitleDaoImpl;
import jdbc_study.dto.Title;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ErpMngUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnTtl;
	private TitleDao ttlDao;
	 private TitleListUI frameTitleList;
	
	public ErpMngUI() {
		ttlDao = new TitleDaoImpl();
		initComponents();
	}
	private void initComponents() {
		setTitle("ERP관리프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 121);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(20, 20));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnEmp = new JButton("사원관리");
		btnEmp.setPreferredSize(new Dimension(100, 50));
		contentPane.add(btnEmp);
		
		JButton btnDpt = new JButton("부서관리");
		btnDpt.setPreferredSize(new Dimension(100, 50));
		contentPane.add(btnDpt);
		
		btnTtl = new JButton("직책관리");
		btnTtl.addActionListener(this);
		btnTtl.setPreferredSize(new Dimension(100, 50));
		contentPane.add(btnTtl);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnTtl) {
			actionPerformedBtnTtl(e);
		}
	}
	protected void actionPerformedBtnTtl(ActionEvent e) {
		List<Title> ttlList = ((TitleDao) ttlDao).selectTitleByAll();
		Title[] eList = new Title[ttlList.size()];
		ttlList.toArray(eList);
		
	}

	public void refreshUI() {
		
		if (frameTitleList != null && frameTitleList.isVisible()) {
			frameTitleList.setTitleList(ttlDao.selectTitleByAll());
			frameTitleList.reloadData();
		}
		
		
		
	}
}
