package jdbc_study.dao;

import java.sql.SQLException;
import java.util.List;

import jdbc_study.dto.Title;



public interface TitleDao {

	List<Title> selectTitleByAll();
	Title selectTitleByNo(Title title);
	int insertTitle(Title title);
	int deleteTitle(Title title);
	int updateTitle(Title title)throws SQLException;;

}
