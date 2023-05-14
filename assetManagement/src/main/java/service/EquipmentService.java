package service;

import java.util.List;

import dao.EquipmentDAO;
import vo.EquiVO;

public class EquipmentService {
	EquipmentDAO eqDao = new EquipmentDAO();
	
	//모든 장비 조회
	public List<EquiVO> eqSelectAll() {
		return eqDao.eqSelectAll();
	}
	
	//대여가능장비 조회
	public List<EquiVO> rentPossible() {
		return eqDao.rentPossible();
	}
	
	//사용중인 장비 모두 조회
	public List<EquiVO> empUseEqAllSearch() {
		return eqDao.empUseEqAllSearch();
	}
	// 대여장비 유형별조회
	public List<EquiVO> eqTypeSearch(String typeName) {
		return eqDao.eqTypeSearch(typeName);
	}
	//모든 장비모델명 중복없이 가져오기
	public List<String> allModelList() {
		return eqDao.allModelList();
	}
	// 대여장비 모델별조회
	public List<EquiVO> rentModelSearch(String model) {
		return eqDao.rentModelSearch(model);
	}
	
	//장비대여
	public int eqRental(int equipmentId, int employeeId) {
		return eqDao.eqRental(equipmentId, employeeId);
	}
	
	//장비반납
	public int eqRetrun(int eqId) {
		return eqDao.eqRetrun(eqId);
	}
	
	//rent테이블에 정보 삭제
	public int rentInfoDelete(int eqId) {
		return eqDao.rentInfoDelete(eqId);
	}
}