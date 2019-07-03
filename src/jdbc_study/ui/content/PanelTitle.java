package jdbc_study.ui.content;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JList;

public class PanelTitle extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelTitle() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JList list = new JList();
		add(list, BorderLayout.CENTER);
	}

}
