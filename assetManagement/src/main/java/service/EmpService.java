package service;

import java.util.List;

import dao.EmpDAO;
import vo.EmpVO;

public class EmpService {
	EmpDAO empDao = new EmpDAO();
	
	public List<EmpVO> empSelectAll() {
		return empDao.empSelectAll();
	}
	public List<EmpVO> allEmpAndDept() {
		return empDao.allEmpAndDept();
	}
}
