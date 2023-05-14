package controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import service.EquipmentService;
import vo.EquiVO;

public class SearchEquipmentByTypeController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		HttpServletRequest request = (HttpServletRequest) data.get("request");
		EquipmentService service = new EquipmentService();
		String typeName = request.getParameter("type_name");

		List<EquiVO> eqlist = service.eqTypeSearch(typeName);
		request.setAttribute("eqAll", eqlist);
		String page = "searchEquipment.jsp";
		return page;
	}

}