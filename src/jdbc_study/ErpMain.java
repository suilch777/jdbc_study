package jdbc_study;

import java.awt.EventQueue;

import jdbc_study.ui.ErpManagementUI;
import jdbc_study.ui.ErpMngUI;

public class ErpMain {

	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir") + System.getProperty("file.separator"));
		System.out.println("첫 번째 수정");
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErpMngUI frame = new ErpMngUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
