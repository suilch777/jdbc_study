package jdbc_study;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import jdbc_study.daoimpl.DepartmentDaoImpl;
import jdbc_study.dto.Department;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentDaoTest {
	static final Logger log = LogManager.getLogger();
	static DepartmentDaoTest dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		log.trace("setUpBeforeClass()");
		dao = new DepartmentDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		log.trace("tearDownAfterClass()");
		dao = null;
	}

	@Test
	public void test01SelectDepartmentByAll() {
		List<Department> lists = dao.test01SelectDepartmentByAll();
		for(Department d : lists) {
			log.trace(d);
		}
		Assert.assertNotEquals(0, lists.size());
	}

	@Test
	public void test02SelectDepartmentByNo() throws SQLException {
		Department dto = new Department(1);
		
		Department selDept = dao.selectDepartmentByNo(dto);
		
		log.trace(selDept);
		Assert.assertNotNull(selDept);
	}
	
	@Test
	public void test03InsertDepartment() throws SQLException {
		Department newDept = new Department(5, "마케팅", 40);
		int res = dao.insertDepartment(newDept);
		Assert.assertNotEquals(-1, res);
	}
	
	@Test
	public void test04UpdateDepartment() throws SQLException {
		Department newDept = new Department(5, "마케팅2", 60);
		int res = dao.updateDepartment(newDept);
		Assert.assertNotEquals(-1, res);
	}
	
	
	@Test
	public void test05DeleteDepartment() throws SQLException {
		Department newDept = new Department(5);
		int res = dao.deleteDepartment(newDept);
		Assert.assertNotEquals(-1, res);
	}
	
}










