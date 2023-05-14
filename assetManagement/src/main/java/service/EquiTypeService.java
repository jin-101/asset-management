package service;

import java.util.List;

import dao.EquiTypeDAO;

public class EquiTypeService {
	EquiTypeDAO eqTypeDao = new EquiTypeDAO();
	public List<String> allEqTypeList(){
		return eqTypeDao.allEqTypeList();
	}
}
