package service;

import java.util.List;

import dao.EquiCompanyDAO;
import vo.EquiCompanyVO;

public class EquiCompanyService {
	EquiCompanyDAO eqComDao = new EquiCompanyDAO();
	public List<EquiCompanyVO> EquiCompanySelectAll(){
		return eqComDao.EquiCompanySelectAll();
	}
}
