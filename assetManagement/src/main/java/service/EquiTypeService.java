package service;

import java.util.List;

import dao.EquiTypeDAO;
import vo.EquiTypeVO;

public class EquiTypeService {
	EquiTypeDAO eqTypeDao = new EquiTypeDAO();
	public List<String> allEqTypeList(){
		return eqTypeDao.allEqTypeList();
	}
	
	public List<EquiTypeVO> EquiTypeSelectAll(){
		return eqTypeDao.EquiTypeSelectAll();
	}
}
