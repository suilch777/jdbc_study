package jdbc_study.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import jdbc_study.dao.TitleDao;
import jdbc_study.dto.Title;
import jdbc_study.jdbc.MySQLjdbcUtil;

public class TitleDaoImpl implements TitleDao{
	 static final Logger log =LogManager.getLogger();
	 
	@Override
	public List<Title> selectTitleByAll() {
		List<Title> lists = new ArrayList<Title>();
		String sql = "select no, titlename from Title";
		
		try(Connection conn = MySQLjdbcUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			log.trace(pstmt);

			while(rs.next()) {
				lists.add(getTitle(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return lists;
	}

	private Title getTitle(ResultSet rs) throws SQLException {
		
		return new Title(rs.getInt("no"),
						rs.getString("titleName"));
	}

	@Override
	public Title selectTitleByNo(Title title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertTitle(Title title) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTitle(Title title) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTitle(Title ttl) throws SQLException {
		String sql = "update department set deptname=?, floor=? where deptno=?;";
		int res = -1;
		
		try(Connection conn = MySQLjdbcUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setInt(1, ttl.getNo());
			pstmt.setString(2, ttl.getTitlename());
			
			log.trace(pstmt);
			res = pstmt.executeUpdate();
		}
		return res;
	}

}
