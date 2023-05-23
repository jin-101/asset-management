package controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import service.EquipmentService;
import vo.EquiVO;

public class SearchEquipmentByEmployeeController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		HttpServletRequest request = (HttpServletRequest) data.get("request");
		EquipmentService service = new EquipmentService();
		int empId = Integer.parseInt(request.getParameter("index"));
		
		List<EquiVO> eqlist = service.userEqSearch(empId);
		request.setAttribute("eqAll", eqlist);
		String page = "searchEquipment.jsp";
		return page;
	}

}
