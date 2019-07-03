package jdbc_study.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import jdbc_study.dto.Department;
import jdbc_study.dto.Title;

import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class TitleListUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private List<Title> ttlList;
	private JPopupMenu popupMenu;
	private JMenuItem mntmPopUpdate;
	private JMenuItem mntmPopDelete;
	private JTable table_1;
	
	private ErpManagementUI parent;

	
	public TitleListUI() {
		initComponents();
	}
	private void initComponents() {
		setTitle("직책목록");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "직책목록", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table);
		
		popupMenu = new JPopupMenu();

		mntmPopUpdate = new JMenuItem("수정");
		mntmPopUpdate.addActionListener(this);
		popupMenu.add(mntmPopUpdate);
		
		mntmPopDelete = new JMenuItem("삭제");
		popupMenu.add(mntmPopDelete);
		
		table.setComponentPopupMenu(popupMenu);
		scrollPane.setComponentPopupMenu(popupMenu);
	}
	public void reloadData() {
		table.setModel(new DefaultTableModel(getRows(),getColumnNames()));
		
		// 부서번호, 부서명은 가운데 정렬
		tableCellAlignment(SwingConstants.CENTER, 0,1);
		// 위치(층)은 우측 정렬
		tableCellAlignment(SwingConstants.RIGHT, 2);	
		// 부서번호, 부서명, 위치 의 폭을 (100, 200, 70)으로 가능하면 설정 
		tableSetWidth(100, 200);
	}
	private Object[][] getRows() {
		Object[][] rows = new Object[ttlList.size()][];
		for(int i=0; i<ttlList.size(); i++) {
			rows[i] = ttlList.get(i).toArray();
		}
		return rows;
	}

	private String[] getColumnNames() {
		return new String[] {"직책번호", "직책명"};
	}

	
	// 테이블 셀 내용의 정렬
	protected void tableCellAlignment(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel model = table.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	// 테이블 셀의 폭 설정
	protected void tableSetWidth(int... width) {
		TableColumnModel cModel = table.getColumnModel();

		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int i = table.getSelectedRow();
		if (table.getModel().getRowCount() == 0) {	// 부서정보가 존재하지 않을 경우
			parent.showDepartmentUI();
			return;
		}
		if (i  < 0 || i > table.getModel().getRowCount()-1) { //선택하지 않은 경우
			JOptionPane.showMessageDialog(null, "선택된 부서가 없습니다.");
			return;
		}
		int deptNo = (int) table.getModel().getValueAt(i, 0);
		parent.showDepartmentUI(deptNo);// TODO Auto-generated method stub
		
	}
	public void setTitleList(List<Title> selectTitleByAll) {
		this.ttlList = ttlList;
		
	}

}
