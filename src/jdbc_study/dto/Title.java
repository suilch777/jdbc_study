package jdbc_study.dto;

public class Title {
	int no;
	String titlename;
	
	public Title() {
	}
	

	public Title(int no, String titlename) {
		this.no = no;
		this.titlename = titlename;
	}


	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitlename() {
		return titlename;
	}

	public void setTitlename(String titlename) {
		this.titlename = titlename;
	}


	public Object[] toArray() {
	
		return new Object[]{no, titlename}; 
	}


	public int updateTitle(Title newTtl) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
}
