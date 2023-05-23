package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import service.EquipmentService;
import vo.EmpVO;

public class SearchEmployeeByEquipmentIdController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		HttpServletRequest request = (HttpServletRequest) data.get("request");
		EquipmentService service = new EquipmentService();
		int eqId = Integer.parseInt(request.getParameter("eqId"));
		EmpVO emp =  service.equiIdSearch(eqId);
		request.setAttribute("empInfo", emp);
		String page = "/assetManagement/emp/empDetail.jsp";
		return page;
	}

}